/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package libSBOL;

/**
 *
 * @author mgaldzic
 */
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import org.biojava.bio.seq.Feature;
import org.biojava.bio.seq.FeatureFilter;
import org.biojava.bio.seq.FeatureHolder;
import org.biojavax.Note;
import org.biojavax.RichAnnotation;
import org.biojavax.bio.seq.RichFeature;
import org.biojavax.bio.seq.RichSequence;
import com.clarkparsia.empire.annotation.Namespaces;
import com.clarkparsia.empire.annotation.RdfProperty;
import com.clarkparsia.empire.annotation.RdfsClass;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;

@Namespaces({"sbol", "http://sbols.org/core#"})
@RdfsClass("sbol:Part")
@Entity
public class Part extends SBOLbase {

    @RdfProperty("sbol:uri")
    public String uri;

    @RdfProperty("sbol:id")
    public String id;

    @RdfProperty("sbol:name")
    public String name;

    @RdfProperty("sbol:shortDescription")
    public String shortDescription;

    @RdfProperty("sbol:longDescription")
    public String longDescription;

    @RdfProperty("sbol:date")
    public String date;

    @RdfProperty("sbol:author")
    public String author;

    @RdfProperty("sbol:type")
    public String type;

    @RdfProperty("sbol:status")
    public String status;

    @RdfProperty("sbol:owner_id")
    public String owner_id;

    @RdfProperty("sbol:principal_investogator")
    public String principal_investigator;

    @RdfProperty("sbol:nickname")
    public String nickname;

    @RdfProperty("sbol:subClassOf")
    public String subClassOf;

    @RdfProperty("sbol:dnaSequence")
    public String dnaSequence;

    @OneToMany(fetch = FetchType.LAZY,
    cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @RdfProperty("sbol:annotation")
    public ArrayList<SequenceAnnotation> annotation;

    /**  public Part(String uri, String id, String name, String shortDescription, String longDescription, String date, String author, String type, String status, String owner_id, String principal_investigator, String nickname, String subClassOf, String dnaSequence, ArrayList<SequenceAnnotation> annotation) {
    this.uri = uri;
    this.id = id;
    this.name = name;
    this.shortDescription = shortDescription;
    this.longDescription = longDescription;
    this.date = date;
    this.author = author;
    this.type = type;
    this.status = status;
    this.owner_id = owner_id;
    this.principal_investigator = principal_investigator;
    this.nickname = nickname;
    this.subClassOf = subClassOf;
    this.dnaSequence = dnaSequence;
    this.annotation = annotation;
    }
     */
    public Part() {
        this.uri = "";
        this.id = "";
        this.name = "";
        this.shortDescription = null;
        this.longDescription = null;
        this.date = null;
        this.author = null;
        this.type = null;
        this.status = null;
        this.owner_id = null;
        this.principal_investigator = null;
        this.nickname = null;
        this.subClassOf = null;
        this.dnaSequence = null;
        this.annotation = null;
    }

    public void readRichSequence(RichSequence rs) {
        //The main GenBank Record can be found by the following
        name = rs.getName();
        shortDescription = rs.getDescription();
        dnaSequence = rs.seqString();
        System.out.println("SBOLname: " + name);

        //Now iterate through the features (all)
        FeatureHolder fh = rs.filter(FeatureFilter.all);
        System.out.println("Features");
        for (Iterator<Feature> i = fh.features(); i.hasNext();) {
            SequenceAnnotation anot = new SequenceAnnotation();
            RichFeature rf = (RichFeature) i.next();

            SequenceFeature feat = new SequenceFeature();
            feat.setType(rf.getType());
            System.out.println("featkey: " + feat.type);


            //Get the location of the feature
            anot.setStart(rf.getLocation().getMin());
            System.out.println("start: " + anot.start);
            anot.setStop(rf.getLocation().getMax());
            System.out.println("stop: " + anot.stop);

            //Get the strand orientation of the feature
            char featureStrand = rf.getStrand().getToken();
            anot.setStrand(featureStrand);
            System.out.println("Strand: " + featureStrand);
            //Get the annotation of the feature
            RichAnnotation ra = (RichAnnotation) rf.getAnnotation();

            String label = "";
            //Iterate through the notes in the annotation

            for (Iterator<Note> it = ra.getNoteSet().iterator(); it.hasNext();) {
                Note n = it.next();
                String key = n.getTerm().getName();
                String value = n.getValue();
                int rank = n.getRank();
                // print the qualifier out in key=value (rank) format
                //System.out.println(key+"="+value+" ("+rank+")");
                if (key.equals("label")) {
                    feat.setName(value);
                }
                if (key.equals("gene")) {
                    feat.setName(value);
                }
            }
            System.out.println("name : " + feat.name);
            System.out.println("\n");
            anot.addFeature(feat);
            this.addAnnotation(anot);
        }
        //add part to SBOL JSON conversion here
    }

    public String toJson() {
        // converting to JSON
        Gson gson = new Gson();
        String json = gson.toJson(this);
        System.out.println("js " + json);
        return json;
    }

    public boolean isEmpty() {
        this.isEmpty();

        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Part) {
            Part anotherPart = (Part) obj;
            boolean dnaOK = true;
            boolean uriOK = anotherPart.getUri().equals(this.uri);
            //System.out.println("uri: "+anotherPart.getUri()+this.uri);
            boolean idOK = anotherPart.getId().equals(this.id);
            //System.out.println("id: "+anotherPart.getId()+this.id);
            boolean nameOK = anotherPart.getName().equals(this.name);
            if (this.dnaSequence != null) {
                dnaOK = anotherPart.getDnaSequence().equals(this.dnaSequence);
            }
            //if ((uriOK && idOK && nameOK && dnaOK)|| (this.isEmpty() && anotherPart.isEmpty())) //if (idOK && nameOK && dnaOK)
            if ((uriOK && idOK && nameOK && dnaOK)) //if (idOK && nameOK && dnaOK)
            {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.uri != null ? this.uri.hashCode() : 0);
        hash = 67 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 67 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 67 * hash + (this.dnaSequence != null ? this.dnaSequence.hashCode() : 0);
        return hash;
    }

    public ArrayList<SequenceAnnotation> getAnnotation() {
        return annotation;
    }

    public void setAnnotation(ArrayList newannotation) {
        this.annotation = newannotation;
    }

    public void addAnnotation(SequenceAnnotation newannotation) {
        if (this.annotation == null) {
            annotation = new ArrayList<SequenceAnnotation>();
        }
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
