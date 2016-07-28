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

@ManagedBean
@RequestScoped
public class LabelSaveView implements Serializable {

    private static final long serialVersionUID  = 1L;

    private LabelService      service           = new LabelService();
    private PermissionService permissionService = new PermissionService();
    private LanguageService   languageService   = new LanguageService();

    private PermissionLabel   label;
    private List<Language>    languages;
    private List<Permission>  permissions;

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

    public void save() {
        try {

            service.save(label);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Saved"));
        } catch (ServiceException e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Label Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public PermissionLabel getLabel() {
        return label;
    }

    public void setLabel(PermissionLabel label) {
        this.label = label;
    }

}
