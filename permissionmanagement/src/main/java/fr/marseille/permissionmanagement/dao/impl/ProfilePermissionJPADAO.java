package fr.marseille.permissionmanagement.dao.impl;

import java.util.List;
import fr.marseille.permissionmanagement.dao.ProfilePermissionDAO;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Permission;
import fr.marseille.permissionmanagement.model.Profile;
import fr.marseille.permissionmanagement.service.PermissionService;
import fr.marseille.permissionmanagement.service.ProfileService;

// TODO: Auto-generated Javadoc
/**
 * The Class ProfilePermissionJPADAO.
 */
public class ProfilePermissionJPADAO implements ProfilePermissionDAO {

    /** The profile service. */
    private static ProfileService    profileService    = new ProfileService();
    
    /** The permission service. */
    private static PermissionService permissionService = new PermissionService();

    /**
     * Instantiates a new profile permission jpadao.
     */
    public ProfilePermissionJPADAO() {
    }

    /* (non-Javadoc)
     * @see fr.marseille.permissionmanagement.dao.ProfilePermissionDAO#include(fr.marseille.permissionmanagement.model.Profile, java.util.List)
     */
    @Override
    public void include(Profile profile, List<Permission> permissions) throws ServiceException {

        List<Profile> listprofiles = profileService.findAll();

        List<Permission> listpermissions = permissionService.findAll();

        profile.getPermissions().addAll(permissions);

        profileService.update(profile);

        profileService.createProfiles();

    }

    /* (non-Javadoc)
     * @see fr.marseille.permissionmanagement.dao.ProfilePermissionDAO#exclude(java.lang.Integer, java.lang.Integer)
     */
    @Override
    public void exclude(Integer idProfile, Integer id_permission) throws ServiceException {
        Profile profile = profileService.find(idProfile);
        Permission permission = permissionService.find(id_permission);
        profile.getPermissions().remove(permission);
        profileService.update(profile);

        profileService.createProfiles();

    }

    /* (non-Javadoc)
     * @see fr.marseille.permissionmanagement.dao.ProfilePermissionDAO#include(fr.marseille.permissionmanagement.model.Profile, fr.marseille.permissionmanagement.model.Permission)
     */
    @Override
    public void include(Profile profile, Permission permission) throws ServiceException {

        List<Profile> listprofiles = profileService.findAll();

        List<Permission> listpermissions = permissionService.findAll();

        profile.getPermissions().add(permission);

        profileService.update(profile);

        profileService.createProfiles();

    }

    /* (non-Javadoc)
     * @see fr.marseille.permissionmanagement.dao.ProfilePermissionDAO#exclude(java.lang.Integer, java.util.List)
     */
    @Override
    public void exclude(Integer id_profile, List<Permission> permissions) throws ServiceException {
        Profile profile = profileService.find(id_profile);
        permissions = permissionService.findAll();
        profile.getPermissions().remove(permissions);
        profileService.update(profile);

        profileService.createProfiles();
    }
}