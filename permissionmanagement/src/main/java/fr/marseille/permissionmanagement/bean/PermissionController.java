package fr.marseille.permissionmanagement.bean;

import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import fr.marseille.permissionmanagement.model.Permission;
import fr.marseille.permissionmanagement.service.PermissionService;

@ManagedBean(name = "permissionController")
@ApplicationScoped
public class PermissionController {

    private PermissionService permissionService = new PermissionService();

    public List<Permission> createPermissions() {
        return permissionService.createPermissions(10);
    }
}