package fr.marseille.permissionmanagement.dao;

import java.util.List;
import fr.marseille.permissionmanagement.exception.DAOException;
import fr.marseille.permissionmanagement.model.Profile;

/**
 * 
 */
public interface ProfileDAO {

    /**
     * 
     */
    public boolean save(Profile profile) throws DAOException;

    /**
     * 
     */
    public List<Profile> findAll() throws DAOException;

    /**
     * 
     */
    public Profile find(Integer id) throws DAOException;

    /**
     * 
     */
    public Profile update(Profile profile) throws DAOException;

    /**
     * 
     */
    public boolean delete(Integer id) throws DAOException;

}