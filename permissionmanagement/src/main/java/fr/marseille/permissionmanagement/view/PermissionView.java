package fr.marseille.permissionmanagement.view;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import fr.marseille.permissionmanagement.bean.PermissionController;
import fr.marseille.permissionmanagement.model.Permission;

@ManagedBean(name = "dtPermissionView")
@ViewScoped
public class PermissionView implements Serializable {

    /**
     * 
     */
    private static final long    serialVersionUID = 1L;

    private List<Permission>     permissions;

    @ManagedProperty("#{permissionController}")
    private PermissionController controller;

    @PostConstruct
    public void init() {
        // permissions = controller.createPermissions();
        permissions = controller.findAll();
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setController(PermissionController permissionController) {
        this.controller = permissionController;
    }
}
