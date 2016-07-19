package fr.marseille.permissionmanagement.dao.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;
import fr.marseille.permissionmanagement.dao.RightDAO;
import fr.marseille.permissionmanagement.exception.DAOException;
import fr.marseille.permissionmanagement.model.Right;
import fr.marseille.permissionmanagement.util.JPAUtil;

public class RightJPADAO implements RightDAO {

    /**
     * Default constructor
     */
    public RightJPADAO() {

    }

    @Override
    public boolean save(Right right) {
        boolean status = true;
        JPAUtil.getEntityManager().persist(right);
        return status;
    }

    @Override
    public List<Right> findAll() {
        return new ArrayList<Right>();
    }

    @Override
    public Right find(Integer id) {
        return JPAUtil.getEntityManager().find(Right.class, id);
    }

    @Override
    public Right update(Right right) throws DAOException {
        try {
            JPAUtil.getEntityManager().getTransaction().begin();
            JPAUtil.getEntityManager().merge(right);
            JPAUtil.getEntityManager().getTransaction().commit();
        } catch (PersistenceException e) {
            JPAUtil.closeAll();
            throw new DAOException("persist : " + e.getMessage(), e);
        }
        return right;
    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub

    }

}