package fr.marseille.permissionmanagement.dao.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.log4j.Logger;
import fr.marseille.permissionmanagement.dao.ProfileDAO;
import fr.marseille.permissionmanagement.exception.DAOException;
import fr.marseille.permissionmanagement.model.Profile;

/**
 * 
 */

public class ProfileJPADAO implements ProfileDAO {
    private static final Logger LOG = Logger.getLogger(ProfileJPADAO.class);

    public ProfileJPADAO() {

    }

    @Override
    public boolean save(Profile profile) throws DAOException {
        EntityManagerFactory entitiManagerFactory = Persistence.createEntityManagerFactory("permissionmanagement");
        EntityManager entityManager = entitiManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        boolean status = false;
        try {

            // Debute une transaction

            entityManager.persist(profile);
            entityManager.getTransaction().commit();

        } catch (RuntimeException e) {
            entityManager.close();
            entitiManagerFactory.close();
            String msg = "persist : " + e.getMessage();
            LOG.error(msg);
            throw new DAOException(msg, e);
        }
        return status;

    }

    @Override
    public List<Profile> findAll() throws DAOException {
        EntityManagerFactory entitiManagerFactory = Persistence.createEntityManagerFactory("permissionmanagement");
        EntityManager entityManager = entitiManagerFactory.createEntityManager();
        // Debute une transaction

        entityManager.getTransaction().begin();
        List<Profile> profiles = new ArrayList<>();
        try {
            profiles = (List<Profile>) entityManager.createQuery("from Profile").getResultList();
            entityManager.getTransaction().commit();

        } catch (RuntimeException e) {
            entityManager.close();
            entitiManagerFactory.close();
            String msg = "findAll : " + e.getMessage();
            LOG.error(msg);
            throw new DAOException(msg, e);
        }

        return profiles;

    }

    @Override
    public Profile find(Integer id) throws DAOException {
        EntityManagerFactory entitiManagerFactory = Persistence.createEntityManagerFactory("permissionmanagement");
        EntityManager entityManager = entitiManagerFactory.createEntityManager();
        // Debute une transaction

        entityManager.getTransaction().begin();
        Profile profile = null;
        try {
            profile = entityManager.find(Profile.class, id);

        } catch (RuntimeException e) {
            entityManager.close();
            entitiManagerFactory.close();
            String msg = "find : " + e.getMessage();
            LOG.error(msg);
            throw new DAOException(msg, e);
        }

        return profile;

    }

    @Override
    public Profile update(Profile profile) throws DAOException {
        EntityManagerFactory entitiManagerFactory = Persistence.createEntityManagerFactory("permissionmanagement");
        EntityManager entityManager = entitiManagerFactory.createEntityManager();
        // Debute une transaction

        entityManager.getTransaction().begin();

        try {
            entityManager.find(Profile.class, profile.getId());
            entityManager.merge(profile);
            entityManager.getTransaction().commit();

        } catch (RuntimeException e) {
            entityManager.close();
            entitiManagerFactory.close();
            String msg = "update : " + e.getMessage();
            LOG.error(msg);
            throw new DAOException(msg, e);
        }
        return profile;
    }

    @Override
    public boolean delete(Integer id) throws DAOException {
        EntityManagerFactory entitiManagerFactory = Persistence.createEntityManagerFactory("permissionmanagement");
        EntityManager entityManager = entitiManagerFactory.createEntityManager();
        // Debute une transaction

        entityManager.getTransaction().begin();
        boolean status = false;
        Profile profile = entityManager.find(Profile.class, id);
        if (null != profile) {
            try {

                entityManager.remove(profile);
                entityManager.getTransaction().commit();

            } catch (RuntimeException e) {
                entityManager.close();
                entitiManagerFactory.close();
                String msg = "delete : " + e.getMessage();
                LOG.error(msg);
                throw new DAOException(msg, e);
            }
        }
        return status;

    }
}
