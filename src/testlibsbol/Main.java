/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testlibsbol;

import java.io.BufferedReader;
import libSBOL.Part;
import libSBOL.SBOLutils;
import org.biojava.bio.BioException;
import org.biojava.bio.seq.DNATools;
import org.biojava.bio.seq.Sequence;
import org.biojava.bio.symbol.Alphabet;
import org.biojavax.SimpleNamespace;
import org.biojavax.bio.seq.RichSequence;
import org.biojavax.bio.seq.SimpleRichSequence;

/**
 *
 * @author mgaldzic
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws BioException {

        //fileString = "pFab1.str";
        //String fileString = "B0015.ape";

        String fileString = "BFa_1.15.gb";
        //stuff needed for Rich Sequence intialization a precondition of this test
        BufferedReader br = null;
        SimpleNamespace ns = null;
        ns = new SimpleNamespace("bioJavaNS");
        RichSequence rs = SBOLutils.readinGBfile(fileString);
        Part instance = new Part();
        instance.readRichSequence(rs);
        String jsonSBOL = instance.toJson();
        System.out.println("json SBOL form:\n" + jsonSBOL);

        System.setProperty("empire.configuration.file", "examples/examples.empire.config.properties");
        Empire.init(new OpenRdfEmpireModule());

        // create an EntityManager for the specified persistence context
        EntityManager aManager = Persistence.createEntityManagerFactory("oreilly").createEntityManager();

        // this retrieves a particular book from the database
        Book aBook = aManager.find(Book.class, URI.create("urn:x-domain:oreilly.com:product:9780596514129.IP"));

        // prints: Switching to the Mac: The Missing Manual, Leopard Edition
        System.err.println(aBook.getTitle());

        // prints: O'Reilly Media / Pogue Press
        System.err.println(aBook.getPublisher());

        // creating a new book:
        Book aNewBook = new Book();
        aNewBook.setIssued(new Date());
        aNewBook.setTitle("How to use Empire");
        aNewBook.setPublisher("Clark & Parsia");
        aNewBook.setPrimarySubjectOf(URI.create("http://github.com/clarkparsia/Empire"));

        // grab the ebook manifestation
        Manifestation aEBook = aManager.find(Manifestation.class, URI.create("urn:x-domain:oreilly.com:product:9780596104306.EBOOK"));

        // and we'll use it as the embodiment of our new book.
        aNewBook.setEmbodiments(Arrays.asList(aEBook));

        // save the new book to the database
        aManager.persist(aNewBook);

        Book aNewBookCopy = aManager.find(Book.class, aNewBook.getRdfId());

        // true!
        System.err.println(aNewBook.equals(aNewBookCopy));

        // lets edit our book...
        // maybe we changed the title and published as a PDF
        aNewBook.setTitle("Return of the Empire");

        // create a new manifestation
        Manifestation aPDFManifestation = new Manifestation();
        aPDFManifestation.setIssued(new Date());
        // set the dc:type attribute
        aPDFManifestation.setType(URI.create("http://purl.oreilly.com/product-types/PDF"));

        aNewBook.setEmbodiments(Arrays.asList(aPDFManifestation));

        // now save our edits
        aManager.merge(aNewBook);

        // print the new information we just saved
        System.err.println(aNewBook.getTitle());
        System.err.println(aNewBook.getEmbodiments());

        // and importantly, verify that the new manifestation was also saved due to the cascaded merge operation
        // specified in the Book class via the @OneToMany annotation

        // true!
        System.err.println(aManager.contains(aPDFManifestation));

        // the copy of the book contains the old information
        System.err.println(aNewBookCopy.getTitle());
        System.err.println(aNewBookCopy.getEmbodiments());

        // but can be refreshed...
        aManager.refresh(aNewBookCopy);

        // and now contains the correct, up-to-date information
        System.err.println(aNewBookCopy.getTitle());
        System.err.println(aNewBookCopy.getEmbodiments());

        // now we can delete our new book
        aManager.remove(aNewBook);

        // false!
        System.err.println(aManager.contains(aNewBook));

        // but the new manifestation still exists, since we did not specify that deletes should cascade...

        // true!
        System.err.println(aManager.contains(aPDFManifestation));

        // Lastly, we can use the query API to run arbitrary sparql queries
        // create a jpql-style partial SPARQL query (JPQL is currently unsupported)
        Query aQuery = aManager.createQuery("where { ?result frbr:embodiment ?manifest."
                + "		 ?foo <http://purl.org/goodrelations/v1#typeOfGood> ?manifest . "
                + "        ?foo <http://purl.org/goodrelations/v1#hasPriceSpecification> ?price. "
                + "        ?price <http://purl.org/goodrelations/v1#hasCurrencyValue> ?value. "
                + "        ?price <http://purl.org/goodrelations/v1#hasCurrency> \"USD\"@en."
                + "        filter(?value > ??min). }");

        // this query should return instances of type Book
        aQuery.setHint(RdfQuery.HINT_ENTITY_CLASS, Book.class);

        // set the parameter in the query to the value for the min price
        // parameters are prefixed with ??
        aQuery.setParameter("min", 30);

        // now execute the query to get the list of all books which are $30 USD
        List aResults = aQuery.getResultList();

        // 233 results
        System.err.println("Num Results:  " + aResults.size());

        // print the titles of the first five results
        for (int i = 0; i < 5; i++) {
            Book aBookResult = (Book) aResults.get(i);
            System.err.println(aBookResult.getTitle());
        }

        /*
         * Switching to the Mac: The Missing Manual, Leopard Edition
         * O'Reilly Media / Pogue Press
         * true
         * Return of the Empire
         * [http://purl.oreilly.com/product-types/PDF]
         * true
         * How to use Empire
         * [http://purl.oreilly.com/product-types/EBOOK]
         * Return of the Empire
         * [http://purl.oreilly.com/product-types/PDF]
         * false
         * true
         *
         */
    }
}

//Object o =rse.getClass();
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
