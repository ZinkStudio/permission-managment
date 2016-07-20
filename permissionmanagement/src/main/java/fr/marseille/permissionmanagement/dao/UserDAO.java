package fr.marseille.permissionmanagement.dao;

import java.util.List;
import fr.marseille.permissionmanagement.exception.DAOException;
import fr.marseille.permissionmanagement.model.User;

/**
 * 
 */
public interface UserDAO {

    /**
     * @return
     * @throws DAOException
     */
    public boolean save(User user) throws DAOException;

    /**
     * @return
     */
    public List<User> findAll() throws DAOException;

    /**
     * @return
     */
    public User find(Integer id) throws DAOException;

    /**
     * @return
     */
    public User update(User user) throws DAOException;

    /**
     * @return
     */
    public boolean delete(Integer id) throws DAOException;

}