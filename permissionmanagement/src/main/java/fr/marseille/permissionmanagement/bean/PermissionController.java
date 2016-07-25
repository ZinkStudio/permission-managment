package fr.marseille.permissionmanagement.bean;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Permission;
import fr.marseille.permissionmanagement.service.PermissionService;

@ManagedBean(name = "permissionController")
@RequestScoped
public class PermissionController implements Serializable {

    private static final long serialVersionUID  = 1L;

    private PermissionService permissionService = new PermissionService();

    public void delete(Permission permission) throws ServiceException {
        permissionService.delete(permission.getId());
    }

    public Permission update(Permission permission) throws ServiceException {
        return permissionService.update(permission);
    }

    public List<Permission> findAll() throws ServiceException {
        return permissionService.findAll();
    }

    public Permission find(Permission permission) throws ServiceException {
        return permissionService.find(permission.getId());
    }

    public List<Permission> createPermissions() {
        return permissionService.createPermissions(10);
    }
}