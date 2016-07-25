package fr.marseille.permissionmanagement.runtime;

import fr.marseille.permissionmanagement.exception.DAOException;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.util.JPAUtil;

public class Start {

    public enum MODE {
        /** CREATE MODE */
        CREATE,
        /** UPDATE MODE */
        UPDATE;
    }

    // public static MODE mode = MODE.CREATE;
    public static MODE mode = MODE.UPDATE;

    public static void main(String[] args) throws ServiceException, DAOException {

        if (mode.equals(MODE.CREATE)) {
            generateDatabase();
        } else {
            StartUser.main(args);
            StartPermission.main(args);
            StartProfile.main(args);
        }

        JPAUtil.closeAll();

    }

    public static void generateDatabase() {
        JPAUtil.beginTransaction();
        JPAUtil.commitTransaction();
    }

}
