package fr.marseille.permissionmanagement.dao;

import fr.marseille.permissionmanagement.dao.impl.PermissionJPADAO;
import fr.marseille.permissionmanagement.dao.impl.ProfileJPADAO;
import fr.marseille.permissionmanagement.dao.impl.ProfilePermissionJPADAO;
import fr.marseille.permissionmanagement.dao.impl.ProfileUserJPADAO;
import fr.marseille.permissionmanagement.dao.impl.UserJPADAO;

public class DAOFactory {

    private static UserDAO              user;

    private static ProfileDAO           profile;

    private static PermissionDAO        permission;

    private static ProfileUserDAO       profileUser;

    private static ProfilePermissionDAO profilePermission;

    public static UserDAO getUserDAO() {
        if (null == user) {
            user = new UserJPADAO();
        }

        return user;
    }

    public static ProfileDAO getProfileDAO() {
        if (null == profile) {
            profile = new ProfileJPADAO();
        }

        return profile;
    }

    public static PermissionDAO getPermissionDAO() {
        if (null == permission) {
            permission = new PermissionJPADAO();
        }

        return permission;
    }

    public static ProfileUserDAO getProfileUserDAO() {
        if (null == profileUser) {
            profileUser = new ProfileUserJPADAO();
        }

        return profileUser;
    }

    public static ProfilePermissionDAO getProfilePermission() {
        if (null == profilePermission) {
            profilePermission = new ProfilePermissionJPADAO();
        }

        return profilePermission;
    }

}
