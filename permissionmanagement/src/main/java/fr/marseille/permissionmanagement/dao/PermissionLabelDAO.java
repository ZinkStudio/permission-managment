package fr.marseille.permissionmanagement.dao;

import java.util.List;
import fr.marseille.permissionmanagement.exception.DAOException;
import fr.marseille.permissionmanagement.model.PermissionLabel;

// TODO: Auto-generated Javadoc
/**
 * The Interface PermissionLabelDAO.
 */
public interface PermissionLabelDAO {

    /**
     * Save.
     *
     * @param label the label
     * @return true, if successful
     * @throws DAOException the DAO exception
     */
    public boolean save(PermissionLabel label) throws DAOException;

    /**
     * Find all.
     *
     * @return the list
     * @throws DAOException the DAO exception
     */
    public List<PermissionLabel> findAll() throws DAOException;

    /**
     * Find.
     *
     * @param id the id
     * @return the permission label
     * @throws DAOException the DAO exception
     */
    public PermissionLabel find(Integer id) throws DAOException;

    /**
     * Update.
     *
     * @param label the label
     * @return the permission label
     * @throws DAOException the DAO exception
     */
    public PermissionLabel update(PermissionLabel label) throws DAOException;

    /**
     * Delete.
     *
     * @param id the id
     * @return true, if successful
     * @throws DAOException the DAO exception
     */
    public boolean delete(Integer id) throws DAOException;

}