package fr.marseille.permissionmanagement.service;

import java.util.ArrayList;
import java.util.List;

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

	// private static final Logger LOG =
	// LogManager.getLogger(FormateurService.class);

	private UserDAO userDAO = DAOFactory.getUserDAO();

	/**
	 * Default constructor
	 */
	public UserService() {
	}

	/**
	 * @throws ServiceException
	 * 
	 */
	public List<User> findAll() throws ServiceException {
		List<User> lstUsers = new ArrayList<>();
		try {
			lstUsers = userDAO.findAll();
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return lstUsers;
	}

	/**
	 * @throws ServiceException
	 * 
	 */
	public User update(User user) throws ServiceException {
		try {
			userDAO.update(user);
			// UserService.LOG.info("Log user id : " + user.getId() + " is
			// updated "));
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return user;
	}

	/**
	 * @throws ServiceException
	 * 
	 */
	public void delete(Integer id) throws ServiceException {
		try {
			userDAO.delete(id);
			// UserService.LOG.warning("Log user id : " + id + " is suppressed
			// "));
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * @throws ServiceException
	 * 
	 */
	public User save(User user) throws ServiceException {
		try {
			userDAO.save(user);
			// UserService.LOG.debug("Log user id : " + user.getId());
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return user;
	}

	/**
	 * 
	 * 
	 * @throws ServiceException
	 */

	public User find(Integer id) throws ServiceException {
		User user;
		try {
			user = userDAO.find(id);
			// UserService.LOG.info("Log user id : " + id + " is found
			// "));
		} catch (DAOException e) {
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