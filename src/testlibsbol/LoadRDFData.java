/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testlibsbol;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.*;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.util.DefaultPrefixManager;

/**
 *
 * @author mgaldzic
 */
public class LoadRDFData {

    public static void main(String[] args) {
        try {
            // Get hold of an ontology manager
            OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
            OWLDataFactory factory = manager.getOWLDataFactory();
            String base = "http://sbol.bhi.washington.edu/rdf/sbol.owl";
            PrefixManager pm = new DefaultPrefixManager(base);

            OWLClass part = factory.getOWLClass(":Part", pm);

            File file = new File("C:/Documents and Settings/mgaldzic/My Documents/NetBeansProjects/TestlibSBOL/src/testlibsbol/SBOLtestdata.rdf");
            OWLOntology ont = manager.loadOntologyFromOntologyDocument(file);
            System.out.println("Loaded ontology: " + ont);
            IRI documentIRI = manager.getOntologyDocumentIRI(ont);
            System.out.println("    from: " + documentIRI);
            String indname = "http://sbol.bhi.washington.edu/rdf/sbol.owl#rQprqhqP12083";
            String propname = "http://sbol.bhi.washington.edu/rdf/sbol.owl#name";
            OWLIndividual ind = factory.getOWLNamedIndividual(IRI.create(indname));
            OWLDataPropertyExpression prop = factory.getOWLDataProperty(IRI.create(propname));
            Map<OWLDataPropertyExpression, Set<OWLLiteral>> dataprops = ind.getDataPropertyValues(ont);
            Set<OWLDataPropertyExpression> datapropskeyset = dataprops.keySet();
            Set<String> values = new HashSet();
            for (OWLDataPropertyExpression expression : datapropskeyset) {
                if (expression.equals(prop)) {
                    if (dataprops.get(expression) != null) {
                        for (OWLLiteral referstovalue : dataprops.get(expression)) {
                            values.add(referstovalue.getLiteral());
                            System.out.println("referstovalue :" + referstovalue.getLiteral());
                        }
                    }
                }
            }


            //getIndDatatypeProperty(ont, indname, propname)
        } catch (OWLOntologyCreationIOException e) {
            // IOExceptions during loading get wrapped in an OWLOntologyCreationIOException
            IOException ioException = e.getCause();
            if (ioException instanceof FileNotFoundException) {
                System.out.println("Could not load ontology. File not found: " + ioException.getMessage());
            } else if (ioException instanceof UnknownHostException) {
                System.out.println("Could not load ontology. Unknown host: " + ioException.getMessage());
            } else {
                System.out.println("Could not load ontology: " + ioException.getClass().getSimpleName() + " " + ioException.getMessage());
            }
        } catch (UnparsableOntologyException e) {
            // If there was a problem loading an ontology because there are syntax errors in the document (file) that
            // represents the ontology then an UnparsableOntologyException is thrown
            System.out.println("Could not parse the ontology: " + e.getMessage());
            // A map of errors can be obtained from the exception
            Map<OWLParser, OWLParserException> exceptions = e.getExceptions();
            // The map describes which parsers were tried and what the errors were
            for (OWLParser parser : exceptions.keySet()) {
                System.out.println("Tried to parse the ontology with the " + parser.getClass().getSimpleName() + " parser");
                System.out.println("Failed because: " + exceptions.get(parser).getMessage());
            }
        } catch (UnloadableImportException e) {
            // If our ontology contains imports and one or more of the imports could not be loaded then an
            // UnloadableImportException will be thrown (depending on the missing imports handling policy)
            System.out.println("Could not load import: " + e.getImportsDeclaration());
            // The reason for this is specified and an OWLOntologyCreationException
            OWLOntologyCreationException cause = e.getOntologyCreationException();
            System.out.println("Reason: " + cause.getMessage());
        } catch (OWLOntologyCreationException e) {
            System.out.println("Could not load ontology: " + e.getMessage());
        }
    }

    // RETRIEVE THE DATATYPE PROPERTY VALUES FOR ONE INDIVIDUAL (RETURNS A SET)
    public static Set<String> getIndDatatypeProperty(OWLOntology ont, String indname, String propname) throws OWLException {
        Set<String> values = new HashSet();
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        OWLDataFactory factory = manager.getOWLDataFactory();
        OWLIndividual ind = factory.getOWLNamedIndividual(IRI.create(indname));
        OWLDataPropertyExpression prop = factory.getOWLDataProperty(IRI.create(propname));
        Map<OWLDataPropertyExpression, Set<OWLLiteral>> dataprops = ind.getDataPropertyValues(ont);
        Set<OWLDataPropertyExpression> datapropskeyset = dataprops.keySet();
        for (OWLDataPropertyExpression expression : datapropskeyset) {
            if (expression.equals(prop)) {
                if (dataprops.get(expression) != null) {
                    for (OWLLiteral referstovalue : dataprops.get(expression)) {
                        values.add(referstovalue.getLiteral());
                    }
                }
            }
        }

        return values;
    }
}
