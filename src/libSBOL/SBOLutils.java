/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package libSBOL;

/**
 *
 * @author mgaldzic
 */
import java.io.BufferedReader;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

import org.biojavax.SimpleNamespace;
import org.biojavax.bio.seq.RichSequence;
import org.biojavax.bio.seq.RichSequenceIterator;

import org.biojava.bio.Annotation;
import org.biojava.bio.BioException;
import org.biojava.bio.seq.Feature;
import org.biojava.bio.seq.FeatureFilter;
import org.biojava.bio.seq.FeatureHolder;
import org.biojavax.Note;
import org.biojavax.RichAnnotation;
import org.biojavax.RichObjectFactory;
import org.biojavax.bio.seq.RichFeature;
import org.biojavax.ontology.ComparableTerm;

public class SBOLutils {

    public static RichSequence readinGBfile(String filename) throws BioException {
        //for now assumes one GB record in file, uses the last one throws away the rest
        BufferedReader br = null;
        SimpleNamespace ns = null;
        String fileString = filename;
        RichSequence rs_1 = null;
        try {
            br = new BufferedReader(new FileReader(fileString));
        } catch (FileNotFoundException fnfe) {
            System.out.println("FileNotFoundException: " + fnfe);
        }
       // try {
            ns = new SimpleNamespace("bioJavaNS");
            //Make a biojava.RichSequenceObject
            RichSequenceIterator rsi = RichSequence.IOTools.readGenbankDNA(br, ns);
            while (rsi.hasNext()) {
                RichSequence rs = rsi.nextRichSequence();
                System.out.println("readGB file of: "+rs.getName());
                 rs_1 = rs;
            }
     /**  } catch (Exception be) {
            System.exit(-1);
        }
        */
        return rs_1;
    }
}

