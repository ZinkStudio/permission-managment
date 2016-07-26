package fr.marseille.permissionmanagement.service;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import fr.marseille.permissionmanagement.dao.DAOFactory;
import fr.marseille.permissionmanagement.dao.PermissionDAO;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Permission;

public class PermissionService {

    private static final Logger LOG           = Logger.getLogger(PermissionService.class);

    public PermissionDAO        permissionDAO = DAOFactory.getPermissionDAO();

    public PermissionService() {

    }

    public List<Permission> createPermissions(int size) {
        List<Permission> permissions = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            permissions.add(new Permission(i, "mainapp.ressource" + i));
        }

        LOG.debug("generate false permission data");

        return permissions;
    }

    public Permission find(Integer id) throws ServiceException {
        return permissionDAO.find(id);
    }

    public List<Permission> findAll() throws ServiceException {
        return permissionDAO.findAll();
    }

    public Permission update(Permission permission) throws ServiceException {
        return permissionDAO.update(permission);
    }

    public boolean delete(Integer id) throws ServiceException {
        return permissionDAO.delete(id);
    }

    public boolean save(Permission permission) throws ServiceException {
        return permissionDAO.save(permission);
    }

}