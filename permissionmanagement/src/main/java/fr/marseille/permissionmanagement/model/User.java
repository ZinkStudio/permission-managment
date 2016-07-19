package fr.marseille.permissionmanagement.model;

import java.io.Serializable;
import java.util.List;

/**
 * 
 */
public class User implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor
     */
    public User() {
    }

    /**
     * 
     */
    private Integer       id;

    /**
     * 
     */
    private String        name;

    /**
     * 
     */
    private String        firstName;

    /**
     * 
     */
    private String        comment;

    /**
     * 
     */
    private List<Profile> profiles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

}