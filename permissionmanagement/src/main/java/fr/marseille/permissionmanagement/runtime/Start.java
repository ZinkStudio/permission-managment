package fr.marseille.permissionmanagement.runtime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Start {

    public static void main(String[] args) {

        // JPAUtil.getEntityManager().getTransaction().begin();
        // JPAUtil.getEntityManager().getTransaction().commit();
        // JPAUtil.closeAll();

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("permissionmanagement");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

    }

}
