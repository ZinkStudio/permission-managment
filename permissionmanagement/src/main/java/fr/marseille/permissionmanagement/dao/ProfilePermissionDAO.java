package fr.marseille.permissionmanagement.dao;

import java.util.List;
import fr.marseille.permissionmanagement.model.Permission;
import fr.marseille.permissionmanagement.model.Profile;

/**
 * 
 */
public interface ProfilePermissionDAO {

    /**
     * 
     */
    public void include(Profile profile, List<Permission> permissions);

    /**
     * 
     */
    public void exclude(Integer id_profile, Integer id_permission);

    /**
     * 
     */
    public void include(Profile profile, Permission permission);

    /**
     * 
     */
    public void exclude(Integer id_profile, List<Permission> permissions);

}