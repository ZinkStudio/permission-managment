package fr.marseille.permissionmanagement.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Permission;
import fr.marseille.permissionmanagement.service.PermissionService;

// TODO: Auto-generated Javadoc
/**
 * The Class PermissionView.
 */
@ManagedBean
@SessionScoped
public class PermissionView extends BaseView implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The service. */
    private PermissionService service          = new PermissionService();

    /** The permissions. */
    private List<Permission>  permissions;

    /** The permission. */
    private Permission        permission;

    /**
     * Inits the.
     */
    // @PostConstruct
    public void init() {
        permissions = new ArrayList<Permission>();

        try {
            permissions = service.findAll();
        } catch (ServiceException e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Permission Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    /**
     * Update.
     */
    public void update() {
        try {
            service.update(permission);
        } catch (ServiceException e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Permission Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Updated : " + permission.toString()));

        this.redirectWithMessages("permissionIndex.jsf");
    }

    /**
     * Delete.
     */
    public void delete() {
        try {
            service.delete(permission.getId());
        } catch (ServiceException e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Permission Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Permission" + permission.getId() + " deleted "));
    }

    /**
     * Gets the permissions.
     *
     * @return the permissions
     */
    public List<Permission> getPermissions() {
        init();
        return permissions;
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
