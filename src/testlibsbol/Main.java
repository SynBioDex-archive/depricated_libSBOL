/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testlibsbol;

import com.google.gson.Gson;
import java.io.BufferedReader;
import libSBOL.Part;
import libSBOL.SBOLutils;
import org.biojavax.SimpleNamespace;
import org.biojavax.bio.seq.RichSequence;

/**
 *
 * @author mgaldzic
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

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
        System.out.println("json SBOL form:\n"+jsonSBOL);
        
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
