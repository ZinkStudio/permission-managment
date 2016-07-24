package fr.marseille.permissionmanagement.dao.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.log4j.Logger;
import fr.marseille.permissionmanagement.dao.UserDAO;
import fr.marseille.permissionmanagement.exception.DAOException;
import fr.marseille.permissionmanagement.model.User;
import fr.marseille.permissionmanagement.util.JPAUtil;

/**
 * 
 */
public class UserJPADAO implements UserDAO {
    private static final Logger LOG = Logger.getLogger(UserJPADAO.class);

    /**
     * Default constructor
     */
    public UserJPADAO() {
    }

    @Override
    public boolean save(User user) throws DAOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("permissionmanagement");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();

        } catch (RuntimeException e) {
            entityManager.close();
            entityManagerFactory.close();
            String msg = "persist : " + e.getMessage();
            LOG.warn(msg);
            throw new DAOException(msg, e);
        }
        return true;
    }

    @Override
    public List<User> findAll() throws DAOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("permissionmanagement");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<User> users = new ArrayList<>();
        try {
            users = (List<User>) entityManager.createQuery("from User").getResultList();
        } catch (RuntimeException e) {
            entityManager.close();
            entityManagerFactory.close();
            String msg = "findAll : " + e.getMessage();
            LOG.warn(msg);
            throw new DAOException(msg, e);
        }
        return users;
    }

    @Override
    public User find(Integer id) throws DAOException {
        // EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("permissionmanagement");
        // EntityManager entityManager = entityManagerFactory.createEntityManager();

        User user = null;
        try {
            // user = entityManager.find(User.class, id);
            user = JPAUtil.getEntityManager().find(User.class, id);
        } catch (RuntimeException e) {
            // entityManager.close();
            // entityManagerFactory.close();
            JPAUtil.closeAll();
            String msg = "find : " + e.getMessage();
            LOG.warn(msg);
            throw new DAOException(msg, e);
        }
        return user;

    }

    @Override
    public User update(User user) throws DAOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("permissionmanagement");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(user);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            entityManager.close();
            entityManagerFactory.close();
            String msg = "persist : " + e.getMessage();
            LOG.warn(msg);
            throw new DAOException(msg, e);
        }
        return user;

    }

    @Override
    public boolean delete(Integer id) throws DAOException {
        // EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("permissionmanagement");
        // EntityManager entityManager = entityManagerFactory.createEntityManager();
        User user = this.find(id);
        if (null != user) {
            try {
                // entityManager.getTransaction().begin();
                // entityManager.remove(user);
                // entityManager.getTransaction().commit();
                JPAUtil.beginTransaction();
                JPAUtil.getEntityManager().remove(user);
                JPAUtil.commitTransaction();
            } catch (RuntimeException e) {
                // entityManager.close();
                // entityManagerFactory.close();
                JPAUtil.closeAll();
                String msg = "remove : " + e.getMessage();
                LOG.warn(msg);
                throw new DAOException(msg, e);
            }
        }
        return true;
    }
}