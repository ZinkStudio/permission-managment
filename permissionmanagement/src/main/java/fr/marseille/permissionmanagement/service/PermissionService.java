package fr.marseille.permissionmanagement.service;

import java.util.List;
import fr.marseille.permissionmanagement.dao.PermissionDAO;
import fr.marseille.permissionmanagement.exception.DAOException;
import fr.marseille.permissionmanagement.model.Permission;

public class PermissionService {

    public PermissionDAO permissionDAO;

    public PermissionService() {

    }

    /**
     * @throws DAOException
     */
    public List<Permission> findAll() throws DAOException {
        return permissionDAO.findAll();
    }

    /**
     * 
     */
    public void update(Permission permission) {
        // TODO implement here
    }

    /**
     * 
     */
    public void delete(Integer id) {
        // TODO implement here
    }

    /**
     * 
     */
    public void save(Permission permission) {
        // TODO implement here
    }

}