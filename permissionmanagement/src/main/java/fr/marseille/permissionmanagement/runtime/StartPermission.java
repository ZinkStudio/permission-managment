package fr.marseille.permissionmanagement.runtime;

import java.util.ArrayList;
import java.util.List;
import fr.marseille.permissionmanagement.exception.DAOException;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Language;
import fr.marseille.permissionmanagement.model.Permission;
import fr.marseille.permissionmanagement.model.Profile;
import fr.marseille.permissionmanagement.model.User;
import fr.marseille.permissionmanagement.service.PermissionService;
import fr.marseille.permissionmanagement.service.ProfileService;
import fr.marseille.permissionmanagement.service.UserService;
import fr.marseille.permissionmanagement.util.JPAUtil;

public class StartPermission {
    private static ProfileService    profileService    = new ProfileService();
    private static PermissionService permissionService = new PermissionService();

    public static void main(String[] args) throws ServiceException, DAOException {

        JPAUtil.closeAll();
    }

    private static void insertPermissions() throws ServiceException, DAOException {
        List<Language> languages = new ArrayList<Language>();
        List<Permission> permissions = new ArrayList<Permission>();

    }

    private static void createUserAndProfile() {
        ProfileService profil = new ProfileService();
        UserService use = new UserService();
        User user = new User();
        user.setName("louiza");
        user.setFirstName("zerrad");
        user.setComment("J'aime les chips :) ");

        Profile profile = new Profile();
        profile.setName("Admin5");
        profile.setDescription("Administrateur de l'application5");
        profile.setPermissions(null);

        try {
            profil.save(profile);
        } catch (DAOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        List<User> users = new ArrayList<>();
        users.add(user);
        // profil.setUsers(users);

        List<Profile> profiles = new ArrayList<>();
        profiles.add(profile);
        user.setProfiles(profiles);
        try {
            use.save(user);
        } catch (ServiceException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            List<User> findAll = use.findAll();
        } catch (ServiceException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
