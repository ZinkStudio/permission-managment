package fr.marseille.permissionmanagement.dao;

import java.util.List;
import fr.marseille.permissionmanagement.exception.DAOException;
import fr.marseille.permissionmanagement.model.PermissionLabel;

public interface PermissionLabelDAO {

    public boolean save(PermissionLabel label) throws DAOException;

    public List<PermissionLabel> findAll() throws DAOException;

    public PermissionLabel find(Integer id) throws DAOException;

    public PermissionLabel update(PermissionLabel label) throws DAOException;

    public boolean delete(Integer id) throws DAOException;

}