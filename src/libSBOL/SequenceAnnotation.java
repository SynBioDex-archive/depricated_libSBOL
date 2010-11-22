/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package libSBOL;

import java.util.List;

/**
 *
 * @author mgaldzic
 */
public class SequenceAnnotation extends SBOLbase{
    public String start;
    public String stop;
    public String strand;
    public List<SequenceFeature> feature;

    public List<SequenceFeature> getFeature() {
        return feature;
    }

    public void setFeature(List<SequenceFeature> feature) {
        this.feature = feature;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public String getStrand() {
        return strand;
    }

    public void setStrand(String strand) {
        this.strand = strand;
    }

}
