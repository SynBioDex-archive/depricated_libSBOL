/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package libSBOL;

/**
 *
 * @author mgaldzic
 */
class SequenceFeature extends SBOLbase{
    public String name;
    public String shortDescription;
    public String Type;

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
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
