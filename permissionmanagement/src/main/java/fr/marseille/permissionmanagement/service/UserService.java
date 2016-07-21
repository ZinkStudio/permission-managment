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

/**
 * 
 */
public class UserService {

    private static final Logger LOG     = Logger.getLogger(UserService.class);

    private UserDAO             userDAO = DAOFactory.getUserDAO();

    /**
     * Default constructor
     */
    public UserService() {
    }

    public List<User> createUsers() {
        List<User> users = new ArrayList<User>();

        for (int i = 0; i < 10; i++) {
            users.add(new User(i, "name" + i, "firstName" + i, "super comment" + i));
        }
        return users;
    }

    /**
     * @throws ServiceException
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
     * @throws ServiceException
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
     * @throws ServiceException
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
     * @throws ServiceException
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
     * @throws ServiceException
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
     * 
     */
    public void affect(User user, Profile profile) {
        // TODO implement here
    }

    /**
     * 
     */
    public void unaffect(User user, Profile profile) {
        // TODO implement here
    }

}