package fr.marseille.permissionmanagement.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import fr.marseille.permissionmanagement.bean.PermissionController;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Permission;

@ManagedBean
@RequestScoped
public class PermissionView implements Serializable {

    private static final long    serialVersionUID = 1L;

    private List<Permission>     permissions;

    private Permission           permission;

    @ManagedProperty("#{permissionController}")
    private PermissionController controller;

    // @PostConstruct
    public void init() {
        permissions = new ArrayList<Permission>();
        try {
            permissions = controller.findAll();
        } catch (ServiceException e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Permission Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void onRowEdit(RowEditEvent event) {
        Permission permission = (Permission) event.getObject();

        try {
            this.controller.update(permission);
        } catch (ServiceException e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Permission Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

        FacesMessage msg = new FacesMessage("Permission Edited", ((Permission) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Permission) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed",
                    "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
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

    public void setController(PermissionController permissionController) {
        this.controller = permissionController;
    }
}
