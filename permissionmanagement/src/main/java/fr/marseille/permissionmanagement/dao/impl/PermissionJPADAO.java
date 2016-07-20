package fr.marseille.permissionmanagement.dao.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;
import fr.marseille.permissionmanagement.dao.PermissionDAO;
import fr.marseille.permissionmanagement.exception.DAOException;
import fr.marseille.permissionmanagement.model.Permission;
import fr.marseille.permissionmanagement.util.JPAUtil;

public class PermissionJPADAO implements PermissionDAO {

    /**
     * Default constructor
     */
    public PermissionJPADAO() {

    }

    @Override
    public boolean save(Permission permission) {
        boolean status = true;
        JPAUtil.getEntityManager().persist(permission);
        return status;
    }

    @Override
    public List<Permission> findAll() {
        return new ArrayList<Permission>();
    }

    @Override
    public Permission find(Integer id) {
        return JPAUtil.getEntityManager().find(Permission.class, id);
    }

    @Override
    public Permission update(Permission permission) throws DAOException {
        try {
            JPAUtil.getEntityManager().getTransaction().begin();
            JPAUtil.getEntityManager().merge(permission);
            JPAUtil.getEntityManager().getTransaction().commit();
        } catch (PersistenceException e) {
            JPAUtil.closeAll();
            throw new DAOException("persist : " + e.getMessage(), e);
        }
        return permission;
    }

    @Override
    public void delete(Integer id) {

    }

}