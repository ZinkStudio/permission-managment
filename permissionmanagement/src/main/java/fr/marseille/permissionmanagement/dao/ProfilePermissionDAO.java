package fr.marseille.permissionmanagement.dao;

import java.util.List;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Permission;
import fr.marseille.permissionmanagement.model.Profile;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProfilePermissionDAO.
 */
public interface ProfilePermissionDAO {

    /**
     * Include.
     *
     * @param profile the profile
     * @param permissions the permissions
     * @throws ServiceException the service exception
     */
    public void include(Profile profile, List<Permission> permissions) throws ServiceException;

    /**
     * Exclude.
     *
     * @param id_profile the id_profile
     * @param id_permission the id_permission
     * @throws ServiceException the service exception
     */
    public void exclude(Integer id_profile, Integer id_permission) throws ServiceException;

    /**
     * Include.
     *
     * @param profile the profile
     * @param permission the permission
     * @throws ServiceException the service exception
     */
    public void include(Profile profile, Permission permission) throws ServiceException;

    /**
     * Exclude.
     *
     * @param id_profile the id_profile
     * @param permissions the permissions
     * @throws ServiceException the service exception
     */
    public void exclude(Integer id_profile, List<Permission> permissions) throws ServiceException;

}