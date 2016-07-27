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

@ManagedBean
@SessionScoped
public class PermissionView implements Serializable {

    private static final long serialVersionUID = 1L;

    private PermissionService service          = new PermissionService();

    private List<Permission>  permissions;

    private Permission        permission;

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

    public void update() {
        try {
            service.update(permission);
        } catch (ServiceException e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Permission Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Updated"));
    }

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

    public List<Permission> getPermissions() {
        init();
        return permissions;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
