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
    Profile save(Profile profile) throws DAOException;

    /**
     * 
     */
    List<Profile> findAll() throws DAOException;

    /**
     * 
     */
    Profile find(Integer id) throws DAOException;

    /**
     * 
     */
    public void update(Profile profile) throws DAOException;

    /**
     * 
     */
    public Boolean delete(Integer id) throws DAOException;

}