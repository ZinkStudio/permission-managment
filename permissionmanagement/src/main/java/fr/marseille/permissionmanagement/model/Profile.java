package fr.marseille.permissionmanagement.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

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

    public Profile(Integer id, String name, String description, List<Permission> permissions, List<User> users) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.permissions = permissions;
        this.users = users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}