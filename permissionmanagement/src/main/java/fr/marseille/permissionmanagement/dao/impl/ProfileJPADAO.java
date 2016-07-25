package fr.marseille.permissionmanagement.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import fr.marseille.permissionmanagement.dao.ProfileDAO;
import fr.marseille.permissionmanagement.exception.DAOException;
import fr.marseille.permissionmanagement.model.Profile;
import fr.marseille.permissionmanagement.util.JPAUtil;

/**
 * 
 */

public class ProfileJPADAO implements ProfileDAO {
    private static final Logger LOG = Logger.getLogger(ProfileJPADAO.class);

    public ProfileJPADAO() {

    }

    @Override
    public boolean save(Profile profile) throws DAOException {

        boolean status = false;
        try {

            // Debute une transaction
            JPAUtil.beginTransaction();

            JPAUtil.getEntityManager().persist(profile);

            JPAUtil.commitTransaction();

        } catch (RuntimeException e) {
            JPAUtil.closeAll();
            String msg = "persist : " + e.getMessage();
            LOG.error(msg);
            throw new DAOException(msg, e);
        }
        return status;

    }

    @Override
    public List<Profile> findAll() throws DAOException {

        List<Profile> profiles = new ArrayList<>();
        try {

            profiles = (List<Profile>) JPAUtil.getEntityManager().createQuery("from Profile").getResultList();

        } catch (RuntimeException e) {
            JPAUtil.closeAll();
            String msg = "findAll : " + e.getMessage();
            LOG.error(msg);
            throw new DAOException(msg, e);
        }

        return profiles;

    }

    @Override
    public Profile find(Integer id) throws DAOException {

        // Debute une transaction

        Profile profile = null;
        try {
            profile = JPAUtil.getEntityManager().find(Profile.class, id);

        } catch (RuntimeException e) {
            JPAUtil.closeAll();
            String msg = "find : " + e.getMessage();
            LOG.error(msg);
            throw new DAOException(msg, e);
        }

        return profile;

    }

    @Override
    public Profile update(Profile profile) throws DAOException {

        try {
            JPAUtil.beginTransaction();
            JPAUtil.getEntityManager().merge(profile);
            JPAUtil.commitTransaction();
        } catch (RuntimeException e) {
            JPAUtil.closeAll();
            String msg = "update : " + e.getMessage();
            LOG.error(msg);
            throw new DAOException(msg, e);
        }
        return profile;
    }

    @Override
    public boolean delete(Integer id) throws DAOException {
        boolean status = false;
        Profile profile = this.find(id);
        if (null != profile) {
            try {
                JPAUtil.beginTransaction();
                JPAUtil.getEntityManager().remove(profile);
                JPAUtil.commitTransaction();

            } catch (RuntimeException e) {
                JPAUtil.closeAll();
                String msg = "delete : " + e.getMessage();
                LOG.error(msg);
                throw new DAOException(msg, e);
            }
        }
        return status;

    }
}
