package fr.marseille.permissionmanagement.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer           id;

    private String            name;

    private String            firstName;

    private String            comment;

    @ManyToMany(mappedBy = "users")
    private List<Profile>     profiles;

    public User() {
    }

    public User(Integer id, String name, String firstName, String comment) {
        this();
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.comment = comment;
    }

    public User(Integer id, String name, String firstName, String comment, List<Profile> profiles) {
        this(id, name, firstName, comment);
        this.profiles = profiles;
    }

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