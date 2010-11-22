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
