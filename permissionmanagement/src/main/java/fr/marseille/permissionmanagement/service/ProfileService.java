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
    private ProfileDAO          ProfileDAO = DAOFactory.getProfileDAO();

    /**
     * Default constructor
     */
    public ProfileService() {
    }

    public Profile find(Integer id) {
        Profile profile = null;
        try {
            profile = profileDAO.find(id);
        } catch (DAOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return profile;
    }

    /**
     * 
     */
    public ProfileDAO profileDAO;

    /**
     * 
     */
    public List<Profile> findAll() {
        List<Profile> list = new ArrayList<>();
        try {
            list = profileDAO.findAll();
        } catch (DAOException e) {
            // TODO Auto-generated catch block
            try {
                throw new ServiceException(e.getMessage(), e);
            } catch (ServiceException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        return list;
    }

    /**
     * 
     */
    public void update(Profile profile) {
        try {
            profileDAO.update(profile);
        } catch (DAOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 
     */
    public Boolean delete(Integer id) {
        try {
            profileDAO.delete(id);
        } catch (DAOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 
     */
    public Profile save(Profile profile) {
        try {
            profile = profileDAO.save(profile);
            LOG.debug("Log id profile :" + profile.getId());
        } catch (DAOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return profile;
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

}