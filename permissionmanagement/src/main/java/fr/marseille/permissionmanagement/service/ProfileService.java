package fr.marseille.permissionmanagement.service;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import fr.marseille.permissionmanagement.dao.DAOFactory;
import fr.marseille.permissionmanagement.dao.ProfileDAO;
import fr.marseille.permissionmanagement.exception.DAOException;
import fr.marseille.permissionmanagement.exception.ServiceException;
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

    public Profile find(Integer id) throws ServiceException {
        Profile profile = null;
        try {
            profile = profileDAO.find(id);
            LOG.debug("profile found:" + id);
        } catch (DAOException e) {
            LOG.error(e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }

        return profile;
    }

    /**
     * 
     */

    /**
     * @throws DAOException
     * @throws ServiceException
     */
    public List<Profile> findAll() throws ServiceException {
        List<Profile> list = new ArrayList<>();
        try {
            list = profileDAO.findAll();
            ProfileService.LOG.debug("profile found:" + list.size());
        } catch (DAOException e) {
            LOG.error(e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
        return list;
    }

    /**
     * @throws DAOException
     * @throws ServiceException
     */
    public Profile update(Profile profile) throws ServiceException {

        try {
            profileDAO.update(profile);
            LOG.debug("profile update:" + profile.getId());
        } catch (DAOException e) {
            LOG.error(e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
        return profile;
    }

    /**
     * @throws DAOException
     * @throws ServiceException
     */
    public Boolean delete(Integer id) throws ServiceException {
        boolean status = false;
        try {
            status = profileDAO.delete(id);

        } catch (DAOException e) {
            status = false;
            LOG.error(e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
        return status;
    }

    /**
     * @throws DAOException
     * @throws ServiceException
     */
    public boolean save(Profile profile) throws ServiceException {
        boolean status = false;
        try {
            status = profileDAO.save(profile);

        } catch (DAOException e) {
            status = false;
            LOG.error(e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
        return status;
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