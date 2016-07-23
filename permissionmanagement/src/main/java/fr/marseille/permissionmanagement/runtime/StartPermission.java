package fr.marseille.permissionmanagement.runtime;

import java.util.ArrayList;
import java.util.List;
import fr.marseille.permissionmanagement.exception.DAOException;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Language;
import fr.marseille.permissionmanagement.model.Permission;
import fr.marseille.permissionmanagement.model.PermissionLabel;
import fr.marseille.permissionmanagement.service.PermissionService;
import fr.marseille.permissionmanagement.util.JPAUtil;

public class StartPermission {

    public static String[]          locales           = { "en", "fr" };
    public static String[]          ressources        = { "home", "support", "adminpanel" };
    public static String[]          actions           = { "create", "read", "update", "delete" };
    public static String[]          applications      = { "cognava", "spotpulse", "sharelytic", "cloudovio" };
    public static PermissionService permissionService = new PermissionService();

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

}
