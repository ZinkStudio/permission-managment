package fr.marseille.permissionmanagement.view;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import fr.marseille.permissionmanagement.bean.PermissionController;
import fr.marseille.permissionmanagement.model.Permission;

@ManagedBean
@ViewScoped
public class PermissionView implements Serializable {

    /**
     * 
     */
    private static final long    serialVersionUID = 1L;

    private List<Permission>     permissions;

    private Permission           permission;

    @ManagedProperty("#{permissionController}")
    private PermissionController controller;

    @PostConstruct
    public void init() {
        permissions = controller.findAll();
    }

    public void delete() {

    }

    public void onRowEdit(RowEditEvent event) {
        Permission permission = (Permission) event.getObject();

        Permission update = this.controller.update(permission);

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
        return permissions;
    }

    public void setController(PermissionController permissionController) {
        this.controller = permissionController;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
