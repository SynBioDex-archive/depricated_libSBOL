/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testlibsbol;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.io.FileReader;
import java.util.Iterator;

import org.biojavax.SimpleNamespace;
import org.biojavax.bio.seq.RichSequence;
import org.biojavax.bio.seq.RichSequenceIterator;

import libSBOL.Part;
import org.biojava.bio.Annotation;
import org.biojava.bio.seq.Feature;
import org.biojava.bio.seq.FeatureFilter;
import org.biojava.bio.seq.FeatureHolder;
import org.biojavax.Note;
import org.biojavax.RichAnnotation;
import org.biojavax.RichObjectFactory;
import org.biojavax.bio.seq.RichFeature;
import org.biojavax.ontology.ComparableTerm;

/**
 *
 * @author mgaldzic
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader br = null;
        SimpleNamespace ns = null;
        String fileString = null;
        //fileString = "pFab1.str";
        fileString = "B0015.ape";

        try {
            br = new BufferedReader(new FileReader(fileString));
        } catch (FileNotFoundException fnfe) {
            System.out.println("FileNotFoundException: " + fnfe);
        }
        try {
            ns = new SimpleNamespace("bioJavaNS");
            //Make a biojava.RichSequenceObject
            RichSequenceIterator rsi = RichSequence.IOTools.readGenbankDNA(br, ns);
            while (rsi.hasNext()) {
                Part part = new Part();
                RichSequence rs = rsi.nextRichSequence();
                System.out.println(rs.getName());
                part.setName(rs.getName());
                part.setShortDescription(rs.getDescription());
                part.setDnaSequence(rs.seqString());
                System.out.println("SBOLname: "+part.getName());
                System.out.println("SBOLdescription: "+part.getShortDescription());
                System.out.println("SBOL seq: "+part.getDnaSequence());
                Annotation anno = rs.getAnnotation();
                for (Iterator i = anno.keys().iterator(); i.hasNext();) {
                    Object key = i.next();
                    System.out.println(key + " : " + anno.getProperty(key));
                }
                System.out.println(rs.toString() + " " + rs.getFeatureSet());
                //Filter the sequence on CDS features
                //FeatureFilter ff = new FeatureFilter.ByType("misc_feature");
                //FeatureHolder fh = rs.filter(ff);
                FeatureHolder fh = rs.filter(FeatureFilter.all);
                //Iterate through the features (all, could be filtered specifically by type)
                System.out.println("");
                for (Iterator<Feature> i = fh.features(); i.hasNext();) {
                    RichFeature rf = (RichFeature) i.next();

                    //Get the strand orientation of the feature
                    char featureStrand = rf.getStrand().getToken();

                    //Get the location of the feature
                    String featureLocation = rf.getLocation().toString();

                    //Get the annotation of the feature
                    RichAnnotation ra = (RichAnnotation) rf.getAnnotation();

                    //Use BioJava defined ComparableTerms 
                    ComparableTerm geneTerm = new RichSequence.Terms().getGeneNameTerm();
                    ComparableTerm synonymTerm = new RichSequence.Terms().getGeneSynonymTerm();
                    //Create the required additional ComparableTerms
                    ComparableTerm labelTerm = RichObjectFactory.getDefaultOntology().getOrCreateTerm("label");
                    ComparableTerm productTerm = RichObjectFactory.getDefaultOntology().getOrCreateTerm("product");
                    ComparableTerm proteinIDTerm = RichObjectFactory.getDefaultOntology().getOrCreateTerm("protein_id");

                    //Create empty strings
                    
                    String label = "";
                    //Iterate through the notes in the annotation 
                    for (Iterator<Note> it = ra.getNoteSet().iterator(); it.hasNext();) {
                        Note note = it.next();
                        label = note.getValue().toString();
                        //Outout the feature information
                        System.out.println(note.getTerm() + " : " + label);
                    }
                }
            //add part to SBOL JSON conversion here
            }
        } catch (Exception be) {
            be.printStackTrace();
            System.exit(-1);
        }

        //sequences = RichSequence.IOTools.readGenbankDNA(new BufferedReader (new StringReader(fileString)), ns);

        /*
        //map the RichSequence to SBOL.Part

        //write SBOL RDF
        Part testPart = new Part();
        testPart.setName("test_name");
        testPart.setAuthor("author");
        testPart.setDate("test_date");
         */

    }
}
