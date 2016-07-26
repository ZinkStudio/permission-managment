package fr.marseille.permissionmanagement.dao.impl;

import java.util.List;
import fr.marseille.permissionmanagement.dao.ProfilePermissionDAO;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Permission;
import fr.marseille.permissionmanagement.model.Profile;
import fr.marseille.permissionmanagement.service.PermissionService;
import fr.marseille.permissionmanagement.service.ProfileService;

public class ProfilePermissionJPADAO implements ProfilePermissionDAO {

    private static ProfileService    profileService    = new ProfileService();
    private static PermissionService permissionService = new PermissionService();

    public ProfilePermissionJPADAO() {
    }

    @Override
    public void include(Profile profile, List<Permission> permissions) throws ServiceException {

        List<Profile> listprofiles = profileService.findAll();

        List<Permission> listpermissions = permissionService.findAll();

        profile.getPermissions().addAll(permissions);

        profileService.update(profile);

        profileService.createProfiles();

    }

    @Override
    public void exclude(Integer id_profile, Integer id_permission) throws ServiceException {
        Profile profile = profileService.find(id_profile);
        Permission permission = permissionService.find(id_permission);
        profile.getPermissions().remove(permission);
        profileService.update(profile);

        profileService.createProfiles();

    }

    @Override
    public void include(Profile profile, Permission permission) throws ServiceException {

        List<Profile> listprofiles = profileService.findAll();

        List<Permission> listpermissions = permissionService.findAll();

        profile.getPermissions().add(permission);

        profileService.update(profile);

        profileService.createProfiles();

    }

    @Override
    public void exclude(Integer id_profile, List<Permission> permissions) throws ServiceException {
        Profile profile = profileService.find(id_profile);
        permissions = permissionService.findAll();
        profile.getPermissions().remove(permissions);
        profileService.update(profile);

        profileService.createProfiles();
    }
}