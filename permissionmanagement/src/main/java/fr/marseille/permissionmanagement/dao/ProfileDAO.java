package fr.marseille.permissionmanagement.dao;

import java.util.List;
import fr.marseille.permissionmanagement.exception.DAOException;
import fr.marseille.permissionmanagement.model.Profile;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProfileDAO.
 */
public interface ProfileDAO {

    /**
     * Save.
     *
     * @param profile the profile
     * @return true, if successful
     * @throws DAOException the DAO exception
     */
    public boolean save(Profile profile) throws DAOException;

    /**
     * Find all.
     *
     * @return the list
     * @throws DAOException the DAO exception
     */
    public List<Profile> findAll() throws DAOException;

    /**
     * Find.
     *
     * @param id the id
     * @return the profile
     * @throws DAOException the DAO exception
     */
    public Profile find(Integer id) throws DAOException;

    /**
     * Update.
     *
     * @param profile the profile
     * @return the profile
     * @throws DAOException the DAO exception
     */
    public Profile update(Profile profile) throws DAOException;

    /**
     * Delete.
     *
     * @param id the id
     * @return true, if successful
     * @throws DAOException the DAO exception
     */
    public boolean delete(Integer id) throws DAOException;

}