package fr.marseille.permissionmanagement.runtime;

import fr.marseille.permissionmanagement.util.JPAUtil;

public class Start {

    public static void main(String[] args) {
        JPAUtil.getEntityManager().getTransaction().begin();
        JPAUtil.getEntityManager().getTransaction().commit();
        JPAUtil.closeAll();
    }

}
