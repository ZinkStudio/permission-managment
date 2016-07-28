package fr.marseille.permissionmanagement.dao;

import java.util.List;
import fr.marseille.permissionmanagement.exception.DAOException;
import fr.marseille.permissionmanagement.model.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserDAO.
 */
public interface UserDAO {

    /**
     * Save.
     *
     * @param user the user
     * @return true, if successful
     * @throws DAOException the DAO exception
     */
    public boolean save(User user) throws DAOException;

    /**
     * Find all.
     *
     * @return the list
     * @throws DAOException the DAO exception
     */
    public List<User> findAll() throws DAOException;

    /**
     * Find.
     *
     * @param id the id
     * @return the user
     * @throws DAOException the DAO exception
     */
    public User find(Integer id) throws DAOException;

    /**
     * Update.
     *
     * @param user the user
     * @return the user
     * @throws DAOException the DAO exception
     */
    public User update(User user) throws DAOException;

    /**
     * Delete.
     *
     * @param id the id
     * @return true, if successful
     * @throws DAOException the DAO exception
     */
    public boolean delete(Integer id) throws DAOException;

}