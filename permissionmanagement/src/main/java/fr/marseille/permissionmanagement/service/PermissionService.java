package fr.marseille.permissionmanagement.service;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import fr.marseille.permissionmanagement.dao.DAOFactory;
import fr.marseille.permissionmanagement.dao.PermissionDAO;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Permission;

// TODO: Auto-generated Javadoc
/**
 * The Class PermissionService.
 */
public class PermissionService {

    /** The Constant LOG. */
    private static final Logger LOG           = Logger.getLogger(PermissionService.class);

    /** The permission dao. */
    public PermissionDAO        permissionDAO = DAOFactory.getPermissionDAO();

    /**
     * Instantiates a new permission service.
     */
    public PermissionService() {

    }

    /**
     * Creates the permissions.
     *
     * @param size the size
     * @return the list
     */
    public List<Permission> createPermissions(int size) {
        List<Permission> permissions = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            permissions.add(new Permission(i, "mainapp.ressource" + i));
        }

        LOG.debug("generate false permission data");

        return permissions;
    }

    /**
     * Find.
     *
     * @param id the id
     * @return the permission
     * @throws ServiceException the service exception
     */
    public Permission find(Integer id) throws ServiceException {
        return permissionDAO.find(id);
    }

    /**
     * Find all.
     *
     * @return the list
     * @throws ServiceException the service exception
     */
    public List<Permission> findAll() throws ServiceException {
        return permissionDAO.findAll();
    }

    /**
     * Update.
     *
     * @param permission the permission
     * @return the permission
     * @throws ServiceException the service exception
     */
    public Permission update(Permission permission) throws ServiceException {
        return permissionDAO.update(permission);
    }

    /**
     * Delete.
     *
     * @param id the id
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    public boolean delete(Integer id) throws ServiceException {
        return permissionDAO.delete(id);
    }

    /**
     * Save.
     *
     * @param permission the permission
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    public boolean save(Permission permission) throws ServiceException {
        return permissionDAO.save(permission);
    }

}