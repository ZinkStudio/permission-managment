package fr.marseille.permissionmanagement.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

// TODO: Auto-generated Javadoc
/**
 * The Class Language.
 */
@Entity
public class Language implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long     serialVersionUID = 1L;

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer               id;

    /** The locale. */
    private String                locale;

    /** The is default. */
    private Boolean               isDefault;

    /** The labels. */
    @OneToMany(mappedBy = "language", cascade = { CascadeType.REMOVE })
    private List<PermissionLabel> labels;

    /**
     * Instantiates a new language.
     */
    public Language() {
    }

    /**
     * Instantiates a new language.
     *
     * @param locale
     *            the locale
     * @param isDefault
     *            the is default
     */
    public Language(String locale, Boolean isDefault) {
        super();
        this.locale = locale;
        this.isDefault = isDefault;
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
     * Gets the locale.
     *
     * @return the locale
     */
    public String getLocale() {
        return locale;
    }

    /**
     * Sets the locale.
     *
     * @param locale
     *            the new locale
     */
    public void setLocale(String locale) {
        this.locale = locale;
    }

    /**
     * Gets the checks if is default.
     *
     * @return the checks if is default
     */
    public Boolean getIsDefault() {
        return isDefault;
    }

    /**
     * Sets the checks if is default.
     *
     * @param isDefault
     *            the new checks if is default
     */
    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    @Override
    public String toString() {
        return "Language [id=" + id + ", locale=" + locale + ", isDefault=" + isDefault + "]";
    }

}