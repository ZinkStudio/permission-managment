package fr.marseille.permissionmanagement.runtime;

import fr.marseille.permissionmanagement.exception.DAOException;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Permission;
import fr.marseille.permissionmanagement.model.Profile;
import fr.marseille.permissionmanagement.model.User;
import fr.marseille.permissionmanagement.service.PermissionService;
import fr.marseille.permissionmanagement.service.ProfileService;
import fr.marseille.permissionmanagement.service.UserService;
import fr.marseille.permissionmanagement.util.JPAUtil;

public class StartProfile {
    private static ProfileService    profileService    = new ProfileService();
    private static UserService       userService       = new UserService();
    private static PermissionService permissionService = new PermissionService();

    public static void main(String[] args) throws ServiceException, DAOException {

        // Start.generateDatabase();
        insertProfiles();
        // affectUser();
        // includePermission();

        JPAUtil.closeAll();
    }

    protected static void affectUser() throws ServiceException, DAOException {
        User user = userService.findAll().get(0);
        Profile profile = profileService.findAll().get(0);

        profile.getUsers().add(user);
        profileService.update(profile);

        profileService.createProfiles();

    }

    protected static void includePermission() throws ServiceException, DAOException {

        Profile profile = profileService.findAll().get(0);
        Permission permission = permissionService.findAll().get(0);
        profile.getPermissions().add(permission);
        profileService.update(profile);

        profileService.createProfiles();

    }

    protected static void excludePermission() throws ServiceException, DAOException {

        Profile profile = profileService.findAll().get(0);
        Permission permission = permissionService.findAll().get(0);
        profile.getPermissions().remove(permission);
        profileService.update(profile);

        profileService.createProfiles();

    }

    protected static void insertProfiles() throws ServiceException {
        String[] applications = StartPermission.applications;
        String[] roles = { "Admin", "Chief", "Editor", "Guest" };

        for (String application : applications) {
            for (String role : roles) {
                profileService.save(
                        new Profile(null, role + "." + application, role + " of " + application + " application"));
            }
        }
    }
}
