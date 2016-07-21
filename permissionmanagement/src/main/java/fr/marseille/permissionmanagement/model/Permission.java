package fr.marseille.permissionmanagement.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity
public class Permission implements Serializable {

    private static final long     serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer               id;

    private String                entry;

    @ManyToMany(mappedBy = "permissions")
    private List<Profile>         profiles;

    @OneToMany(mappedBy = "permission", cascade = { CascadeType.ALL })
    @OrderBy("language")
    private List<PermissionLabel> labels;

    public Permission() {

    }

    public Permission(Integer id, String entry) {
        super();
        this.id = id;
        this.entry = entry;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    public List<PermissionLabel> getLabels() {
        return labels;
    }

    public void setLabels(List<PermissionLabel> labels) {
        this.labels = labels;
    }

}