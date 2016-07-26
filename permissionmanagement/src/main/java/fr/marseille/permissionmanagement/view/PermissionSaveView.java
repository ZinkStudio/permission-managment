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

@ManagedBean
@RequestScoped
public class PermissionSaveView implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private PermissionService service          = new PermissionService();
    private Permission        permission;

    @PostConstruct
    public void init() {
        permission = new Permission();
    }

    public void save() {
        try {
            service.save(permission);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Saved"));
        } catch (ServiceException e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Permission Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

}
