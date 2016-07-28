package fr.marseille.permissionmanagement.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

// TODO: Auto-generated Javadoc
/**
 * The Class PermissionLabel.
 */
@Entity
public class PermissionLabel implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer           id;

    /** The label. */
    private String            label;

    /** The language. */
    @ManyToOne
    private Language          language;

    /** The permission. */
    @ManyToOne
    private Permission        permission;

    /**
     * Instantiates a new permission label.
     */
    public PermissionLabel() {

    }

    /**
     * Instantiates a new permission label.
     *
     * @param id the id
     * @param label the label
     * @param language the language
     * @param permission the permission
     */
    public PermissionLabel(Integer id, String label, Language language, Permission permission) {
        super();
        this.id = id;
        this.label = label;
        this.language = language;
        this.permission = permission;
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
     * Gets the label.
     *
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the label.
     *
     * @param label the new label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Gets the language.
     *
     * @return the language
     */
    public Language getLanguage() {
        return language;
    }

    /**
     * Sets the language.
     *
     * @param language the new language
     */
    public void setLanguage(Language language) {
        this.language = language;
    }

    /**
     * Gets the permission.
     *
     * @return the permission
     */
    public Permission getPermission() {
        return permission;
    }

    /**
     * Sets the permission.
     *
     * @param permission the new permission
     */
    public void setPermission(Permission permission) {
        this.permission = permission;
    }

}
