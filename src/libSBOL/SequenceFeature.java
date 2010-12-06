/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package libSBOL;

/**
 *
 * @author mgaldzic
 */
public class SequenceFeature extends SBOLbase{
    public String name;
    public String shortDescription;
    public String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

}
