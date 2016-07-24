package fr.marseille.permissionmanagement.dao.impl;

import java.util.ArrayList;
import java.util.List;
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
        try {
            JPAUtil.beginTransaction();
            JPAUtil.getEntityManager().persist(user);
            JPAUtil.commitTransaction();
        } catch (RuntimeException e) {
            JPAUtil.closeAll();
            String msg = "save : " + e.getMessage();
            LOG.warn(msg);
            throw new DAOException(msg, e);
        }
        return true;
    }

    @Override
    public List<User> findAll() throws DAOException {
        List<User> users = new ArrayList<>();
        try {
            users = (List<User>) JPAUtil.getEntityManager().createQuery("from User").getResultList();
        } catch (RuntimeException e) {
            JPAUtil.closeAll();
            String msg = "findAll : " + e.getMessage();
            LOG.warn(msg);
            throw new DAOException(msg, e);
        }
        return users;
    }

    @Override
    public User find(Integer id) throws DAOException {
        User user = null;
        try {
            user = JPAUtil.getEntityManager().find(User.class, id);
        } catch (RuntimeException e) {
            JPAUtil.closeAll();
            String msg = "find : " + e.getMessage();
            LOG.warn(msg);
            throw new DAOException(msg, e);
        }
        return user;

    }

    @Override
    public User update(User user) throws DAOException {
        try {
            JPAUtil.beginTransaction();
            JPAUtil.getEntityManager().merge(user);
            JPAUtil.commitTransaction();
        } catch (RuntimeException e) {
            JPAUtil.closeAll();
            String msg = "update : " + e.getMessage();
            LOG.warn(msg);
            throw new DAOException(msg, e);
        }
        return user;

    }

    @Override
    public boolean delete(Integer id) throws DAOException {
        User user = this.find(id);
        if (null != user) {
            try {
                JPAUtil.beginTransaction();
                JPAUtil.getEntityManager().remove(user);
                JPAUtil.commitTransaction();
            } catch (RuntimeException e) {
                JPAUtil.closeAll();
                String msg = "remove : " + e.getMessage();
                LOG.warn(msg);
                throw new DAOException(msg, e);
            }
        }
        return true;
    }
}