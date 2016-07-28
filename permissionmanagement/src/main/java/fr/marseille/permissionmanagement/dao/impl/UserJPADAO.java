package fr.marseille.permissionmanagement.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import fr.marseille.permissionmanagement.dao.UserDAO;
import fr.marseille.permissionmanagement.exception.DAOException;
import fr.marseille.permissionmanagement.model.User;
import fr.marseille.permissionmanagement.util.JPAUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class UserJPADAO.
 */
public class UserJPADAO implements UserDAO {
    
    /** The Constant LOG. */
    private static final Logger LOG = Logger.getLogger(UserJPADAO.class);

    /**
     * Default constructor.
     */
    public UserJPADAO() {
    }

    /* (non-Javadoc)
     * @see fr.marseille.permissionmanagement.dao.UserDAO#save(fr.marseille.permissionmanagement.model.User)
     */
    @Override
    public boolean save(User user) throws DAOException {
        try {
            JPAUtil.beginTransaction();
            JPAUtil.getEntityManager().persist(user);
            JPAUtil.commitTransaction();
        } catch (RuntimeException e) {
            String msg = "save : " + e.getMessage();
            LOG.warn(msg);
            JPAUtil.rollbackTransaction();
            throw new DAOException(msg, e);
        }
        return true;
    }

    /* (non-Javadoc)
     * @see fr.marseille.permissionmanagement.dao.UserDAO#findAll()
     */
    @Override
    public List<User> findAll() throws DAOException {
        List<User> users = new ArrayList<>();
        try {
            users = (List<User>) JPAUtil.getEntityManager().createQuery("from User").getResultList();
        } catch (RuntimeException e) {
            String msg = "findAll : " + e.getMessage();
            LOG.warn(msg);
            JPAUtil.rollbackTransaction();
            throw new DAOException(msg, e);
        }
        return users;
    }

    /* (non-Javadoc)
     * @see fr.marseille.permissionmanagement.dao.UserDAO#find(java.lang.Integer)
     */
    @Override
    public User find(Integer id) throws DAOException {
        User user = null;
        try {
            user = JPAUtil.getEntityManager().find(User.class, id);
        } catch (RuntimeException e) {
            String msg = "find : " + e.getMessage();
            LOG.warn(msg);
            JPAUtil.rollbackTransaction();
            throw new DAOException(msg, e);
        }
        return user;

    }

    /* (non-Javadoc)
     * @see fr.marseille.permissionmanagement.dao.UserDAO#update(fr.marseille.permissionmanagement.model.User)
     */
    @Override
    public User update(User user) throws DAOException {
        try {
            JPAUtil.beginTransaction();
            JPAUtil.getEntityManager().merge(user);
            JPAUtil.commitTransaction();
        } catch (RuntimeException e) {
            String msg = "update : " + e.getMessage();
            LOG.warn(msg);
            JPAUtil.rollbackTransaction();
            throw new DAOException(msg, e);
        }
        return user;

    }

    /* (non-Javadoc)
     * @see fr.marseille.permissionmanagement.dao.UserDAO#delete(java.lang.Integer)
     */
    @Override
    public boolean delete(Integer id) throws DAOException {
        User user = this.find(id);
        if (null != user) {
            try {
                JPAUtil.beginTransaction();
                JPAUtil.getEntityManager().remove(user);
                JPAUtil.commitTransaction();
            } catch (RuntimeException e) {
                String msg = "remove : " + e.getMessage();
                LOG.warn(msg);
                JPAUtil.rollbackTransaction();
                throw new DAOException(msg, e);
            }
        }
        return true;
    }
}