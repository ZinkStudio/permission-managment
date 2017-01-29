package fr.marseille.permissionmanagement.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
@Entity
public class User implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer           id;

    /** The name. */
    private String            name;

    /** The first name. */
    private String            firstName;

    /** The comment. */
    private String            comment;

    /** The profiles. */
    @ManyToMany(mappedBy = "users")
    private List<Profile>     profiles;

    /**
     * Instantiates a new user.
     */
    public User() {
    }

    /**
     * Instantiates a new user.
     *
     * @param id
     *            the id
     * @param name
     *            the name
     * @param firstName
     *            the first name
     * @param comment
     *            the comment
     */
    public User(Integer id, String name, String firstName, String comment) {
        this();
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.comment = comment;
    }

    /**
     * Instantiates a new user.
     *
     * @param id
     *            the id
     * @param name
     *            the name
     * @param firstName
     *            the first name
     * @param comment
     *            the comment
     * @param profiles
     *            the profiles
     */
    public User(Integer id, String name, String firstName, String comment, List<Profile> profiles) {
        this(id, name, firstName, comment);
        this.profiles = profiles;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id
     *            the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name
     *            the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName
     *            the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the comment.
     *
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the comment.
     *
     * @param comment
     *            the new comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Gets the profiles.
     *
     * @return the profiles
     */
    public List<Profile> getProfiles() {
        return profiles;
    }

    /**
     * Sets the profiles.
     *
     * @param profiles
     *            the new profiles
     */
    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", firstName=" + firstName + ", comment=" + comment + "]";
    }
}