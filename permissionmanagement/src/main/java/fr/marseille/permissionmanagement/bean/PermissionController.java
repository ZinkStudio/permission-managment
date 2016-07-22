package fr.marseille.permissionmanagement.bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Permission;
import fr.marseille.permissionmanagement.service.PermissionService;

@ManagedBean(name = "permissionController")
@ApplicationScoped
public class PermissionController {

    private PermissionService permissionService = new PermissionService();

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