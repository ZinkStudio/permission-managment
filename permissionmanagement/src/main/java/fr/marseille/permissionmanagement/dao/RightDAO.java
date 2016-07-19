package fr.marseille.permissionmanagement.dao;

import java.util.List;
import fr.marseille.permissionmanagement.exception.DAOException;
import fr.marseille.permissionmanagement.model.Right;

public interface RightDAO {

    /**
     * @return
     */
    public boolean save(Right right) throws DAOException;

    /**
     * @return
     */
    public List<Right> findAll() throws DAOException;

    /**
     * 
     */
    public Right find(Integer id) throws DAOException;

    /**
     * @return
     */
    public Right update(Right right) throws DAOException;

    /**
     * 
     */
    public void delete(Integer id) throws DAOException;

}