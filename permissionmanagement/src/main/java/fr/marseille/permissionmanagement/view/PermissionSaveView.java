package fr.marseille.permissionmanagement.view;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Permission;
import fr.marseille.permissionmanagement.service.PermissionService;

// TODO: Auto-generated Javadoc
/**
 * The Class PermissionSaveView.
 */
@ManagedBean
@RequestScoped
public class PermissionSaveView extends BaseView implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The service. */
    private PermissionService service          = new PermissionService();

    /** The permission. */
    private Permission        permission;

    /**
     * Inits the.
     */
    @PostConstruct
    public void init() {
        permission = new Permission();
    }

    /**
     * Save.
     */
    public void save() {
        try {
            service.save(permission);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Data Saved : " + permission.toString()));
        } catch (ServiceException e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Permission Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

        this.redirectWithMessages("permissionIndex.jsf");

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
     * @param permission
     *            the new permission
     */
    public void setPermission(Permission permission) {
        this.permission = permission;
    }

}
