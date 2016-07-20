package fr.marseille.permissionmanagement.model;

import java.io.Serializable;
import java.util.List;

public class Profile implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor
     */
    public Profile() {
    }

    /**
     * 
     */
    private Integer          id;

    /**
     * 
     */
    private String           name;

    /**
     * 
     */
    private String           description;

    /**
     * 
     */
    private List<Permission> permissions;

    /**
     * 
     */
    private List<User>       users;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}