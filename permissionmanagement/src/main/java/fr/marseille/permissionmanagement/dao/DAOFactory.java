package fr.marseille.permissionmanagement.dao;

import fr.marseille.permissionmanagement.dao.impl.ProfileJPADAO;
import fr.marseille.permissionmanagement.dao.impl.RightJPADAO;
import fr.marseille.permissionmanagement.dao.impl.UserJPADAO;

public class DAOFactory {

    private static RightDAO   right;

    private static ProfileDAO profile;

    // added from home
    private static UserDAO    user;

    // added from home
    // added from home
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

    public static RightDAO getRightDAO() {

        if (null == right) {
            right = new RightJPADAO();
        }

        return right;
    }
}
