package fr.marseille.permissionmanagement.dao;

import fr.marseille.permissionmanagement.dao.impl.RightJPADAO;

public class DAOFactory {

    private static RightDAO right;

    public static RightDAO getRightDAO() {

        if (null == right) {
            right = new RightJPADAO();
        }

        return right;
    }
}
