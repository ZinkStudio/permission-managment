package fr.marseille.permissionmanagement.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

// TODO: Auto-generated Javadoc
/**
 * The Class Permission.
 */
@Entity
public class Permission implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long     serialVersionUID = 1L;

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer               id;

    /** The entry. */
    @Column(unique = true)
    private String                entry;

    /** The profiles. */
    @ManyToMany(mappedBy = "permissions")
    private List<Profile>         profiles;

    /** The labels. */
    @OneToMany(mappedBy = "permission", cascade = { CascadeType.ALL })
    @OrderBy("language")
    private List<PermissionLabel> labels;

    /**
     * Instantiates a new permission.
     */
    public Permission() {

    }

    /**
     * Instantiates a new permission.
     *
     * @param id the id
     * @param entry the entry
     */
    public Permission(Integer id, String entry) {
        super();
        this.id = id;
        this.entry = entry;
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
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the entry.
     *
     * @return the entry
     */
    public String getEntry() {
        return entry;
    }

    /**
     * Sets the entry.
     *
     * @param entry the new entry
     */
    public void setEntry(String entry) {
        this.entry = entry;
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
     * @param profiles the new profiles
     */
    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    /**
     * Gets the labels.
     *
     * @return the labels
     */
    public List<PermissionLabel> getLabels() {
        return labels;
    }

    /**
     * Sets the labels.
     *
     * @param labels the new labels
     */
    public void setLabels(List<PermissionLabel> labels) {
        this.labels = labels;
    }

}