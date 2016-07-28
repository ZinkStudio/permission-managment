package fr.marseille.permissionmanagement.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import fr.marseille.permissionmanagement.dao.PermissionLabelDAO;
import fr.marseille.permissionmanagement.exception.DAOException;
import fr.marseille.permissionmanagement.model.PermissionLabel;
import fr.marseille.permissionmanagement.util.JPAUtil;

public class PermissionLabelJPADAO implements PermissionLabelDAO {

    private static final Logger LOG = Logger.getLogger(PermissionLabelJPADAO.class);

    public PermissionLabelJPADAO() {

    }

    @Override
    public boolean save(PermissionLabel label) throws DAOException {
        boolean status = false;

        try {
            JPAUtil.beginTransaction();
            JPAUtil.getEntityManager().persist(label);
            JPAUtil.commitTransaction();
            status = true;
        } catch (RuntimeException e) {
            status = false;
            String msg = "persist : " + e.getMessage();
            LOG.error(msg);
            JPAUtil.rollbackTransaction();
            throw new DAOException(msg, e);
        }

        return status;
    }

    @Override
    public List<PermissionLabel> findAll() throws DAOException {
        List<PermissionLabel> labels = new ArrayList<PermissionLabel>();

        try {
            labels = JPAUtil.getEntityManager().createQuery("from PermissionLabel", PermissionLabel.class)
                    .getResultList();
        } catch (RuntimeException e) {
            String msg = "findAll : " + e.getMessage();
            LOG.error(msg);
            throw new DAOException(msg, e);
        }

        return labels;
    }

    @Override
    public PermissionLabel find(Integer id) throws DAOException {
        PermissionLabel label = null;

        try {
            label = JPAUtil.getEntityManager().find(PermissionLabel.class, id);
        } catch (RuntimeException e) {
            String msg = "find : " + e.getMessage();
            LOG.error(msg);
            throw new DAOException(msg, e);
        }

        return label;
    }

    @Override
    public PermissionLabel update(PermissionLabel label) throws DAOException {
        PermissionLabel mergeLabel = label;

        try {
            JPAUtil.beginTransaction();
            mergeLabel = JPAUtil.getEntityManager().merge(label);
            JPAUtil.commitTransaction();
        } catch (RuntimeException e) {
            String msg = "update : " + e.getMessage();
            LOG.error(msg);
            JPAUtil.rollbackTransaction();
            throw new DAOException(msg, e);
        }

        return mergeLabel;
    }

    @Override
    public boolean delete(Integer id) throws DAOException {
        boolean status = false;

        PermissionLabel label = this.find(id);

        if (null != label) {
            try {
                JPAUtil.beginTransaction();
                JPAUtil.getEntityManager().remove(label);
                JPAUtil.commitTransaction();
                status = true;
            } catch (RuntimeException e) {
                status = false;
                String msg = "remove : " + e.getMessage();
                LOG.error(msg);
                JPAUtil.rollbackTransaction();
                throw new DAOException(msg, e);
            }
        }

        return status;
    }

}