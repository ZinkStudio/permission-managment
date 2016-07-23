package fr.marseille.permissionmanagement.view;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import fr.marseille.permissionmanagement.bean.PermissionController;

@ManagedBean
@ViewScoped
public class IndexView implements Serializable {

    /**
     * 
     */
    private static final long    serialVersionUID = 1L;

    @ManagedProperty("#{permissionController}")
    private PermissionController controller;

    @PostConstruct
    public void init() {
        // permissions = controller.createPermissions();
        // permissions = controller.findAll();
    }

    public void setController(PermissionController permissionController) {
        this.controller = permissionController;
    }
}
