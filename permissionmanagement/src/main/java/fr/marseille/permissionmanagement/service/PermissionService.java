package fr.marseille.permissionmanagement.service;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import fr.marseille.permissionmanagement.dao.DAOFactory;
import fr.marseille.permissionmanagement.dao.PermissionDAO;
import fr.marseille.permissionmanagement.exception.DAOException;
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

        return permissions;
    }

    public Permission find(Integer id) throws ServiceException {
        Permission permission = null;
        try {
            Permission find = permissionDAO.find(id);
        } catch (DAOException e) {
            LOG.error(e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }

        return permission;
    }

    public List<Permission> findAll() throws ServiceException {
        List<Permission> permissions = new ArrayList<Permission>();

        try {
            permissions = permissionDAO.findAll();
            LOG.debug("permissions found : " + permissions.size());
        } catch (DAOException e) {
            LOG.error(e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }

        return permissions;
    }

    public Permission update(Permission permission) throws ServiceException {
        try {
            permission = permissionDAO.update(permission);
            LOG.debug("update permission id : " + permission.getId());
        } catch (DAOException e) {
            LOG.error(e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }

        return permission;
    }

    public boolean delete(Integer id) throws ServiceException {
        boolean status = false;
        try {
            status = permissionDAO.delete(id);
        } catch (DAOException e) {
            status = false;
            LOG.error(e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }

        return status;
    }

    public boolean save(Permission permission) throws ServiceException {
        boolean status = false;
        try {
            status = permissionDAO.save(permission);
        } catch (DAOException e) {
            status = false;
            LOG.error(e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }

        return status;
    }

}