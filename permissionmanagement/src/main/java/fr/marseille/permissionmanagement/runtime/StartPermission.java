package fr.marseille.permissionmanagement.runtime;

import java.util.ArrayList;
import java.util.List;
import fr.marseille.permissionmanagement.exception.DAOException;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Language;
import fr.marseille.permissionmanagement.model.Permission;
import fr.marseille.permissionmanagement.model.PermissionLabel;
import fr.marseille.permissionmanagement.model.Profile;
import fr.marseille.permissionmanagement.model.User;
import fr.marseille.permissionmanagement.service.PermissionService;
import fr.marseille.permissionmanagement.service.ProfileService;
import fr.marseille.permissionmanagement.service.UserService;
import fr.marseille.permissionmanagement.util.JPAUtil;

public class StartPermission {

    private static String[]          locales           = { "en", "fr" };
    private static String[]          ressources        = { "home", "support", "adminpanel" };
    private static String[]          actions           = { "create", "read", "update", "delete" };
    private static String[]          applications      = { "cognava", "spotpulse", "sharelytic", "cloudovio" };
    private static ProfileService    profileService    = new ProfileService();
    private static PermissionService permissionService = new PermissionService();

    public static void main(String[] args) throws ServiceException, DAOException {
        // generateDatabase();
        insertPermissions();
        insertLanguages();
        localizePermissions();
        JPAUtil.closeAll();
    }

    private static void generateDatabase() {
        JPAUtil.getEntityManager().getTransaction().begin();
        JPAUtil.getEntityManager().getTransaction().commit();
    }

    private static void localizePermissions() throws ServiceException {
        List<Permission> permissions = permissionService.findAll();
        List<Language> languages = (List<Language>) JPAUtil.getEntityManager().createQuery("from Language")
                .getResultList();

        for (Permission permission : permissions) {
            String[] split = permission.getEntry().split("\\.");

            for (Language language : languages) {
                PermissionLabel label = new PermissionLabel();
                label.setLanguage(language);
                label.setPermission(permission);

                if ("en".equals(language.getLocale())) {
                    label.setLabel("allow to " + split[2] + " for resource " + split[1] + " from " + split[0]
                            + " application");
                } else if ("fr".equals(language.getLocale())) {
                    label.setLabel("permet de " + split[2] + " la ressource " + split[1] + " depuis l'application "
                            + split[0]);
                }

                JPAUtil.getEntityManager().getTransaction().begin();
                JPAUtil.getEntityManager().persist(label);
                JPAUtil.getEntityManager().getTransaction().commit();
            }
        }
    }

    private static void insertPermissions() throws ServiceException, DAOException {
        List<Permission> permissions = new ArrayList<Permission>();

        for (int i = 0; i < applications.length; i++) {

            for (int j = 0; j < ressources.length; j++) {

                for (int k = 0; k < actions.length; k++) {
                    Permission permission = new Permission();
                    permission.setEntry(applications[i] + "." + ressources[j] + "." + actions[k]);
                    permissionService.save(permission);
                    permissions.add(permission);
                }
            }
        }

    }

    private static void insertLanguages() {

        for (String locale : locales) {
            boolean isDefault = false;

            if ("fr".equals(locale)) {
                isDefault = true;
            }

            Language language = new Language(locale, isDefault);
            JPAUtil.getEntityManager().getTransaction().begin();
            JPAUtil.getEntityManager().persist(language);
            JPAUtil.getEntityManager().getTransaction().commit();
        }
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
