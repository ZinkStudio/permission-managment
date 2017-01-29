package fr.marseille.permissionmanagement.view;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Language;
import fr.marseille.permissionmanagement.model.Permission;
import fr.marseille.permissionmanagement.model.PermissionLabel;
import fr.marseille.permissionmanagement.service.LabelService;
import fr.marseille.permissionmanagement.service.LanguageService;
import fr.marseille.permissionmanagement.service.PermissionService;

// TODO: Auto-generated Javadoc
/**
 * The Class LabelSaveView.
 */
@ManagedBean
@RequestScoped
public class LabelSaveView implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID  = 1L;

    /** The service. */
    private LabelService      service           = new LabelService();

    /** The permission service. */
    private PermissionService permissionService = new PermissionService();

    /** The language service. */
    private LanguageService   languageService   = new LanguageService();

    /** The label. */
    private PermissionLabel   label;

    /** The languages. */
    private List<Language>    languages;

    /** The permissions. */
    private List<Permission>  permissions;

    /**
     * Inits the.
     */
    @PostConstruct
    public void init() {
        label = new PermissionLabel();

        try {
            languages = languageService.findAll();
            permissions = permissionService.findAll();
        } catch (ServiceException e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Permission/Language Error",
                    e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }

    /**
     * Save.
     */
    public void save() {
        try {
            service.save(label);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Saved"));
        } catch (ServiceException e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Label Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
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
     * Gets the languages.
     *
     * @return the languages
     */
    public List<Language> getLanguages() {
        return languages;
    }

    /**
     * Sets the languages.
     *
     * @param languages
     *            the new languages
     */
    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    /**
     * Gets the label.
     *
     * @return the label
     */
    public PermissionLabel getLabel() {
        return label;
    }

    /**
     * Sets the label.
     *
     * @param label
     *            the new label
     */
    public void setLabel(PermissionLabel label) {
        this.label = label;
    }

}
