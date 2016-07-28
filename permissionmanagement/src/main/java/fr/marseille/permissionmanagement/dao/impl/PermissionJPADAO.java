package fr.marseille.permissionmanagement.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import fr.marseille.permissionmanagement.dao.PermissionDAO;
import fr.marseille.permissionmanagement.exception.DAOException;
import fr.marseille.permissionmanagement.model.Permission;
import fr.marseille.permissionmanagement.util.JPAUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class PermissionJPADAO.
 */
public class PermissionJPADAO implements PermissionDAO {

    /** The Constant LOG. */
    private static final Logger LOG = Logger.getLogger(PermissionJPADAO.class);

    /**
     * Instantiates a new permission jpadao.
     */
    public PermissionJPADAO() {

    }

    /* (non-Javadoc)
     * @see fr.marseille.permissionmanagement.dao.PermissionDAO#save(fr.marseille.permissionmanagement.model.Permission)
     */
    @Override
    public boolean save(Permission permission) throws DAOException {
        boolean status = false;

        try {
            JPAUtil.beginTransaction();
            JPAUtil.getEntityManager().persist(permission);
            JPAUtil.commitTransaction();
            status = true;
        } catch (RuntimeException e) {
            status = false;
            String msg = "persist : " + e.getMessage();
            LOG.error(msg);
            JPAUtil.getTransaction().rollback();
            throw new DAOException(msg, e);
        }

        return status;
    }

    /* (non-Javadoc)
     * @see fr.marseille.permissionmanagement.dao.PermissionDAO#findAll()
     */
    @Override
    public List<Permission> findAll() throws DAOException {
        List<Permission> permissions = new ArrayList<Permission>();

        try {
            permissions = JPAUtil.getEntityManager().createQuery("from Permission", Permission.class).getResultList();
        } catch (RuntimeException e) {
            JPAUtil.closeAll();
            String msg = "findAll : " + e.getMessage();
            LOG.error(msg);
            throw new DAOException(msg, e);
        }

        return permissions;
    }

    /* (non-Javadoc)
     * @see fr.marseille.permissionmanagement.dao.PermissionDAO#find(java.lang.Integer)
     */
    @Override
    public Permission find(Integer id) throws DAOException {
        Permission permission = null;

        try {
            permission = JPAUtil.getEntityManager().find(Permission.class, id);
        } catch (RuntimeException e) {
            String msg = "find : " + e.getMessage();
            LOG.error(msg);
            throw new DAOException(msg, e);
        }

        return permission;
    }

    /* (non-Javadoc)
     * @see fr.marseille.permissionmanagement.dao.PermissionDAO#update(fr.marseille.permissionmanagement.model.Permission)
     */
    @Override
    public Permission update(Permission permission) throws DAOException {
        Permission mergePermission = permission;

        try {
            JPAUtil.beginTransaction();
            mergePermission = JPAUtil.getEntityManager().merge(permission);
            JPAUtil.commitTransaction();
        } catch (RuntimeException e) {
            String msg = "update : " + e.getMessage();
            LOG.error(msg);
            JPAUtil.getTransaction().rollback();
            throw new DAOException(msg, e);
        }

        return mergePermission;
    }

    /* (non-Javadoc)
     * @see fr.marseille.permissionmanagement.dao.PermissionDAO#delete(java.lang.Integer)
     */
    @Override
    public boolean delete(Integer id) throws DAOException {
        boolean status = false;

        Permission permission = this.find(id);

        if (null != permission) {
            try {
                JPAUtil.beginTransaction();
                JPAUtil.getEntityManager().remove(permission);
                JPAUtil.commitTransaction();
                status = true;
            } catch (RuntimeException e) {
                status = false;
                String msg = "remove : " + e.getMessage();
                LOG.error(msg);
                JPAUtil.getTransaction().rollback();
                throw new DAOException(msg, e);
            }
        }

        return status;
    }

}