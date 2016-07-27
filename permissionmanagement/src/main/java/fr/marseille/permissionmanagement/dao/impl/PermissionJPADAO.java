package fr.marseille.permissionmanagement.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import fr.marseille.permissionmanagement.dao.PermissionDAO;
import fr.marseille.permissionmanagement.exception.DAOException;
import fr.marseille.permissionmanagement.model.Permission;
import fr.marseille.permissionmanagement.util.JPAUtil;

public class PermissionJPADAO implements PermissionDAO {

    private static final Logger LOG = Logger.getLogger(PermissionJPADAO.class);

    public PermissionJPADAO() {

    }

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