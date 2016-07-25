package fr.marseille.permissionmanagement.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Permission;
import fr.marseille.permissionmanagement.service.PermissionService;

@ManagedBean(name = "permissionController")
@SessionScoped
public class PermissionController implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID  = 1L;

    private PermissionService permissionService = new PermissionService();

    public Permission update(Permission permission) {
        Permission update = permission;

        try {
            update = permissionService.update(permission);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return update;
    }

    public List<Permission> findAll() {
        List<Permission> permissions = new ArrayList<>();

        try {
            permissions = permissionService.findAll();
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return permissions;
    }

    public Permission find(Integer id) {
        Permission permission = null;

        try {
            permission = permissionService.find(id);
        } catch (ServiceException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return permission;
    }

    public List<Permission> createPermissions() {
        return permissionService.createPermissions(10);
    }
}