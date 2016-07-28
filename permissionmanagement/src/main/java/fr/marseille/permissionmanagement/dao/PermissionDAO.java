package fr.marseille.permissionmanagement.dao;

import java.util.List;
import fr.marseille.permissionmanagement.exception.DAOException;
import fr.marseille.permissionmanagement.model.Permission;

// TODO: Auto-generated Javadoc
/**
 * The Interface PermissionDAO.
 */
public interface PermissionDAO {

    /**
     * Save.
     *
     * @param permission the permission
     * @return true, if successful
     * @throws DAOException the DAO exception
     */
    public boolean save(Permission permission) throws DAOException;

    /**
     * Find all.
     *
     * @return the list
     * @throws DAOException the DAO exception
     */
    public List<Permission> findAll() throws DAOException;

    /**
     * Find.
     *
     * @param id the id
     * @return the permission
     * @throws DAOException the DAO exception
     */
    public Permission find(Integer id) throws DAOException;

    /**
     * Update.
     *
     * @param permission the permission
     * @return the permission
     * @throws DAOException the DAO exception
     */
    public Permission update(Permission permission) throws DAOException;

    /**
     * Delete.
     *
     * @param id the id
     * @return true, if successful
     * @throws DAOException the DAO exception
     */
    public boolean delete(Integer id) throws DAOException;

}