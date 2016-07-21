package fr.marseille.permissionmanagement.service;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import fr.marseille.permissionmanagement.dao.DAOFactory;
import fr.marseille.permissionmanagement.dao.ProfileDAO;
import fr.marseille.permissionmanagement.exception.DAOException;
import fr.marseille.permissionmanagement.model.Permission;
import fr.marseille.permissionmanagement.model.Profile;

public class ProfileService {
    private static final Logger LOG        = Logger.getLogger(ProfileService.class);
    private ProfileDAO          profileDAO = DAOFactory.getProfileDAO();

    /**
     * Default constructor
     */
    public ProfileService() {
    }

    public Profile find(Integer id) throws DAOException {
        Profile profile = null;
        try {
            profile = profileDAO.find(id);
            LOG.debug("profile found:" + id);
        } catch (RuntimeException e) {

            String msg = "find : " + e.getMessage();

            throw new DAOException(msg, e);
        }

        return profile;
    }

    /**
     * 
     */

    /**
     * @throws DAOException
     */
    public List<Profile> findAll() throws DAOException {
        List<Profile> list = new ArrayList<>();
        try {
            list = profileDAO.findAll();
            LOG.debug("profile found:" + list.size());
        } catch (RuntimeException e) {

            String msg = "findAll : " + e.getMessage();
            LOG.error(msg);
            throw new DAOException(msg, e);

        }
        return list;
    }

    /**
     * @throws DAOException
     */
    public Profile update(Profile profile) throws DAOException {

        try {
            profileDAO.update(profile);
            LOG.debug("profile update:" + profile.getId());
        } catch (RuntimeException e) {

            String msg = "update : " + e.getMessage();
            LOG.error(msg);
            throw new DAOException(msg, e);

        }
        return profile;
    }

    /**
     * @throws DAOException
     */
    public Boolean delete(Integer id) throws DAOException {
        try {
            profileDAO.delete(id);
            LOG.debug("profile deleted:" + id);
        } catch (RuntimeException e) {

            String msg = "delete : " + e.getMessage();
            LOG.error(msg);
            throw new DAOException(msg, e);

        }
        return true;
    }

    /**
     * @throws DAOException
     */
    public boolean save(Profile profile) throws DAOException {
        try {
            profileDAO.save(profile);
            LOG.debug("profile saved:" + profile.getId());

        } catch (RuntimeException e) {

            String msg = "save : " + e.getMessage();
            LOG.error(msg);
            throw new DAOException(msg, e);

        }
        return true;
    }

    /**
     * 
     */
    public void exclude(Profile profile, Permission permission) {

    }

    /**
     * 
     */
    public void include(Profile profile, Permission permission) {
        // TODO implement here
    }

    public List<Profile> createProfiles() {
        List<Profile> profiles = new ArrayList<Profile>();

        for (int i = 0; i < 10; i++) {
            profiles.add(new Profile(i, "name" + i, "description" + i));
        }
        return profiles;

    }
}