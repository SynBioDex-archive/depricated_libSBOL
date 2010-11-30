/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package libSBOL;

import java.io.BufferedReader;

import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

import org.biojavax.SimpleNamespace;
import org.biojavax.bio.seq.RichSequence;
import org.biojavax.bio.seq.RichSequenceIterator;

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
public class Part extends SBOLbase{
    public String uri;
    public String id;
    public String name;
    public String shortDescription;
    public String longDescription;
    public String date;
    public String author;
    public String type;
    public String status;
    public String owner_id;
    public String principal_investigator;
    public String nickname;
    public String subClassOf;
    public String dnaSequence;
    public List <SequenceAnnotation> annotation;

    public void readinGBfile (String filename) {
        BufferedReader br = null;
        SimpleNamespace ns = null;
        String fileString = filename;
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
                RichSequence rs = rsi.nextRichSequence();
                System.out.println(rs.getName());
                name = rs.getName();
                shortDescription = rs.getDescription();
                dnaSequence = rs.seqString();
                System.out.println("SBOLname: "+name);
                System.out.println("SBOLdescription: "+shortDescription);
                System.out.println("SBOL seq: "+dnaSequence);

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
    }

    public List <SequenceAnnotation> getAnnotation() {
        return annotation;
    }

    public void setAnnotation(List newannotation) {
        this.annotation = newannotation;
    }

    public void addAnnotation(SequenceAnnotation newannotation) {
        this.annotation.add(newannotation);
    }
    
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDnaSequence() {
        return dnaSequence;
    }

    public void setDnaSequence(String dnaSequence) {
        this.dnaSequence = dnaSequence;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(String owner_id) {
        this.owner_id = owner_id;
    }

    public String getPrincipal_investigator() {
        return principal_investigator;
    }

    public void setPrincipal_investigator(String principal_investigator) {
        this.principal_investigator = principal_investigator;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubClassOf() {
        return subClassOf;
    }

    public void setSubClassOf(String subClassOf) {
        this.subClassOf = subClassOf;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

}
