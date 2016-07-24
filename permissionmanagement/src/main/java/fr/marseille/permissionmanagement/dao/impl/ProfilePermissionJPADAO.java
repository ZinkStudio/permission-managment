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
    public void include(Profile profile, List<Permission> permissions) {
        try {
            List<Profile> listprofiles = profileService.findAll();
        } catch (ServiceException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            List<Permission> listpermissions = permissionService.findAll();
        } catch (ServiceException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        profile.getPermissions().addAll(permissions);
        try {
            profileService.update(profile);
        } catch (ServiceException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        profileService.createProfiles();

    }

    @Override
    public void exclude(Integer id_profile, Integer id_permission) {
        // TODO Auto-generated method stub

    }

    @Override
    public void include(Profile profile, Permission permission) {
        try {
            List<Profile> listprofiles = profileService.findAll();
        } catch (ServiceException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            List<Permission> listpermissions = permissionService.findAll();
        } catch (ServiceException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        profile.getPermissions().add(permission);
        try {
            profileService.update(profile);
        } catch (ServiceException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        profileService.createProfiles();

    }

    @Override
    public void exclude(Integer id_profile, List<Permission> permissions) {

    }
}