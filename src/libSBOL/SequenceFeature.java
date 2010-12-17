/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package libSBOL;

import com.clarkparsia.empire.annotation.Namespaces;
import com.clarkparsia.empire.annotation.RdfProperty;
import com.clarkparsia.empire.annotation.RdfsClass;

import javax.persistence.Entity;

/**
 *
 * @author mgaldzic
 */

@Namespaces({"sbol", "http://sbols.org/core#"})
@RdfsClass("sbol:SequenceAnnotation")
@Entity
public class SequenceFeature extends SBOLbase{

    @RdfProperty("sbol:name")
    public String name;

    @RdfProperty("sbol:shortDescription")
    public String shortDescription;

    @RdfProperty("sbol:type")
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
