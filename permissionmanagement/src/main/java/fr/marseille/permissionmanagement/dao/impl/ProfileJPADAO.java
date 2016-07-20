package fr.marseille.permissionmanagement.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import fr.marseille.permissionmanagement.dao.ProfileDAO;
import fr.marseille.permissionmanagement.model.Profile;

/**
 * 
 */

public class ProfileJPADAO implements ProfileDAO {

    public ProfileJPADAO() {

    }

    @Override
    public Profile save(Profile profile) {
        EntityManagerFactory entitiManagerFactory = Persistence.createEntityManagerFactory("permissionmanagement");
        EntityManager entityManager = entitiManagerFactory.createEntityManager();
        // Debute une transaction

        entityManager.getTransaction().begin();
        entityManager.persist(profile);
        entityManager.getTransaction().commit();
        return profile;

    }

    @Override
    public List<Profile> findAll() {
        EntityManagerFactory entitiManagerFactory = Persistence.createEntityManagerFactory("permissionmanagement");
        EntityManager entityManager = entitiManagerFactory.createEntityManager();
        // Debute une transaction

        entityManager.getTransaction().begin();
        List<Profile> profiles = (List<Profile>) entityManager.createQuery("from Profile");
        entityManager.getTransaction().commit();
        return profiles;

    }

    @Override
    public Profile find(Integer id) {
        EntityManagerFactory entitiManagerFactory = Persistence.createEntityManagerFactory("permissionmanagement");
        EntityManager entityManager = entitiManagerFactory.createEntityManager();
        // Debute une transaction

        entityManager.getTransaction().begin();

        Profile profile = entityManager.find(Profile.class, id);

        return profile;

        // TODO Auto-generated method stub

    }

    @Override
    public void update(Profile profile) {
        EntityManagerFactory entitiManagerFactory = Persistence.createEntityManagerFactory("permissionmanagement");
        EntityManager entityManager = entitiManagerFactory.createEntityManager();
        // Debute une transaction

        entityManager.getTransaction().begin();
        entityManager.find(Profile.class, profile.getId());
        entityManager.merge(profile);
        entityManager.getTransaction().commit();

        entityManager.close();
        entitiManagerFactory.close();
    }

    @Override
    public Boolean delete(Integer id) {
        EntityManagerFactory entitiManagerFactory = Persistence.createEntityManagerFactory("permissionmanagement");
        EntityManager entityManager = entitiManagerFactory.createEntityManager();
        // Debute une transaction

        entityManager.getTransaction().begin();

        Profile profile = entityManager.find(Profile.class, id);
        entityManager.remove(profile);
        entityManager.getTransaction().commit();

        entityManager.close();
        entitiManagerFactory.close();
        return true;
    }

}