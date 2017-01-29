package fr.marseille.permissionmanagement.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

// TODO: Auto-generated Javadoc
/**
 * The Class Profile.
 */
@Entity
public class Profile implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer           id;

    /** The name. */
    @Column(unique = true)
    private String            name;

    /** The description. */
    private String            description;

    /** The permissions. */
    @ManyToMany
    private List<Permission>  permissions;

    /** The users. */
    @ManyToMany
    private List<User>        users;

    /**
     * Instantiates a new profile.
     */
    public Profile() {

    }

    /**
     * Instantiates a new profile.
     *
     * @param id
     *            the id
     * @param name
     *            the name
     * @param description
     *            the description
     */
    public Profile(Integer id, String name, String description) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
    }

    /**
     * Instantiates a new profile.
     *
     * @param id
     *            the id
     * @param name
     *            the name
     * @param description
     *            the description
     * @param permissions
     *            the permissions
     * @param users
     *            the users
     */
    public Profile(Integer id, String name, String description, List<Permission> permissions, List<User> users) {
        this(id, name, description);
        this.permissions = permissions;
        this.users = users;
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
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     *
     * @param description
     *            the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the permissions.
     *
     * @return the permissions
     */
    public List<Permission> getPermissions() {
        return permissions;
    }

    /**
     * Sets the permissions.
     *
     * @param permissions
     *            the new permissions
     */
    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    /**
     * Gets the users.
     *
     * @return the users
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * Sets the users.
     *
     * @param users
     *            the new users
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Profile [id=" + id + ", name=" + name + ", description=" + description + "]";
    }

}