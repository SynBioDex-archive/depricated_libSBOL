/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package libSBOL;

import com.clarkparsia.empire.annotation.Namespaces;
import com.clarkparsia.empire.annotation.RdfProperty;
import com.clarkparsia.empire.annotation.RdfsClass;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;

/**
 *
 * @author mgaldzic
 */
@Namespaces({"sbol", "http://sbols.org/core#"})
@RdfsClass("sbol:SequenceAnnotation")
@Entity
public class SequenceAnnotation extends SBOLbase {

    @RdfProperty("sbol:start")
    public Integer start;

    @RdfProperty("sbol:stop")
    public Integer stop;

    @RdfProperty("sbol:strand")
    public char strand;

    @OneToMany(fetch = FetchType.LAZY,
    cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @RdfProperty("sbol:feature")
    public ArrayList<SequenceFeature> feature;

    public SequenceAnnotation() {
        this.start = null;
        this.stop = null;
        //this.strand;
    }

    public SequenceAnnotation(Integer start, Integer stop, char strand) {
        this.start = start;
        this.stop = stop;
        this.strand = strand;
    }
    public void addFeature(SequenceFeature newfeature){
        if (this.feature == null){
            feature = new ArrayList<SequenceFeature>();
        }
        this.feature.add(newfeature);
    }
    public ArrayList<SequenceFeature> getFeature() {
        return feature;
    }

    public void setFeature(ArrayList<SequenceFeature> feature) {
        this.feature = feature;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getStop() {
        return stop;
    }

    public void setStop(Integer stop) {
        this.stop = stop;
    }

    public char getStrand() {
        return strand;
    }

    public void setStrand(char strand) {
        this.strand = strand;
    }
}
