package fr.marseille.permissionmanagement.dao;

import java.util.List;
import fr.marseille.permissionmanagement.exception.DAOException;
import fr.marseille.permissionmanagement.model.Permission;

public interface PermissionDAO {

    public boolean save(Permission permission) throws DAOException;

    public List<Permission> findAll() throws DAOException;

    public Permission find(Integer id) throws DAOException;

    public Permission update(Permission permission) throws DAOException;

    public void delete(Integer id) throws DAOException;

}