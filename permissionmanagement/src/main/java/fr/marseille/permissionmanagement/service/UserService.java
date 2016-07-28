package fr.marseille.permissionmanagement.service;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import fr.marseille.permissionmanagement.dao.DAOFactory;
import fr.marseille.permissionmanagement.dao.UserDAO;
import fr.marseille.permissionmanagement.exception.DAOException;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Profile;
import fr.marseille.permissionmanagement.model.User;

// TODO: Auto-generated Javadoc
/**
 * The Class UserService.
 */
public class UserService {

    /** The Constant LOG. */
    private static final Logger LOG     = Logger.getLogger(UserService.class);

    /** The user dao. */
    private UserDAO             userDAO = DAOFactory.getUserDAO();

    /**
     * Default constructor.
     */
    public UserService() {
    }

    /**
     * Creates the users.
     *
     * @return the list
     */
    public List<User> createUsers() {
        List<User> users = new ArrayList<User>();

        for (int i = 0; i < 10; i++) {
            users.add(new User(i, "name" + i, "firstName" + i, "super comment" + i));
        }
        return users;
    }

    /**
     * Find all.
     *
     * @return the list
     * @throws ServiceException the service exception
     */
    public List<User> findAll() throws ServiceException {
        List<User> users = new ArrayList<>();
        try {
            users = userDAO.findAll();
            UserService.LOG.debug("users found : " + users.size());
        } catch (DAOException e) {
            UserService.LOG.error("findAll : " + e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
        return users;
    }

    /**
     * Update.
     *
     * @param user the user
     * @return the user
     * @throws ServiceException the service exception
     */
    public User update(User user) throws ServiceException {
        try {
            userDAO.update(user);
            UserService.LOG.debug("Log user id updated : " + user.getId());
        } catch (DAOException e) {
            UserService.LOG.error("update : " + e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
        return user;
    }

    /**
     * Delete.
     *
     * @param id the id
     * @throws ServiceException the service exception
     */
    public void delete(Integer id) throws ServiceException {
        try {
            userDAO.delete(id);
            UserService.LOG.debug("Log user id deleted : " + id);
        } catch (DAOException e) {
            UserService.LOG.error("delete : " + e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * Save.
     *
     * @param user the user
     * @return the user
     * @throws ServiceException the service exception
     */
    public User save(User user) throws ServiceException {
        try {
            userDAO.save(user);
            UserService.LOG.debug("Log user id saved : " + user.getId());
        } catch (DAOException e) {
            UserService.LOG.error("save : " + e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
        return user;
    }

    /**
     * Find.
     *
     * @param id the id
     * @return the user
     * @throws ServiceException the service exception
     */

    public User find(Integer id) throws ServiceException {
        User user;
        try {
            user = userDAO.find(id);
            UserService.LOG.debug("Log user id found : " + id);
        } catch (DAOException e) {
            UserService.LOG.error("find : " + e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
        return user;
    }

    /**
     * Affect.
     *
     * @param user the user
     * @param profile the profile
     * @return the list
     */
    public List<Profile> affect(User user, Profile profile) {
        List<Profile> userProfiles = user.getProfiles();
        try {
            user = userDAO.find(user.getId());
            userProfiles.add(profile);
            userDAO.update(user);
            UserService.LOG.debug("Log profile affected to user OK : " + user + "added new profile " + profile);
        } catch (DAOException e) {
            UserService.LOG.error("affect : " + e.getMessage());
        }
        return userProfiles;
    }

    /**
     * Unaffect.
     *
     * @param user the user
     * @param profile the profile
     * @return the list
     */
    public List<Profile> unaffect(User user, Profile profile) {
        List<Profile> userProfiles = user.getProfiles();
        try {
            user = userDAO.find(user.getId());
            userProfiles.remove(profile);
            userDAO.update(user);
            UserService.LOG.debug("Log profile affected to user OK : " + user + "added new profile " + profile);
        } catch (DAOException e) {
            UserService.LOG.error("affect : " + e.getMessage());
        }
        return userProfiles;
    }

}