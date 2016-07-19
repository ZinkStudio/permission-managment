package fr.marseille.permissionmanagement.service;

import java.util.List;
import fr.marseille.permissionmanagement.dao.RightDAO;
import fr.marseille.permissionmanagement.exception.DAOException;
import fr.marseille.permissionmanagement.model.Right;

public class RightService {

    public RightDAO rightDAO;

    public RightService() {

    }

    /**
     * @throws DAOException
     */
    public List<Right> findAll() throws DAOException {
        return rightDAO.findAll();
    }

    /**
     * 
     */
    public void update(Right right) {
        // TODO implement here
    }

    /**
     * 
     */
    public void delete(Integer id) {
        // TODO implement here
    }

    /**
     * 
     */
    public void save(Right right) {
        // TODO implement here
    }

}