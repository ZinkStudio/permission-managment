package fr.marseille.permissionmanagement.dao;

import java.util.List;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Permission;
import fr.marseille.permissionmanagement.model.Profile;

/**
 * 
 */
public interface ProfilePermissionDAO {

    /**
     * @throws ServiceException
     */
    public void include(Profile profile, List<Permission> permissions) throws ServiceException;

    /**
     * @throws ServiceException
     */
    public void exclude(Integer id_profile, Integer id_permission) throws ServiceException;

    /**
     * @throws ServiceException
     */
    public void include(Profile profile, Permission permission) throws ServiceException;

    /**
     * @throws ServiceException
     */
    public void exclude(Integer id_profile, List<Permission> permissions) throws ServiceException;

}