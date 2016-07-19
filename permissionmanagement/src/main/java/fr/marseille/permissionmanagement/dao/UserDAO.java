package fr.marseille.permissionmanagement.dao;

import fr.marseille.permissionmanagement.model.User;

/**
 * 
 */
public interface UserDAO {

    /**
     * 
     */
    public void save(User user);

    /**
     * 
     */
    public void findAll();

    /**
     * 
     */
    public void find(Integer id);

    /**
     * 
     */
    public void update(User user);

    /**
     * 
     */
    public void delete(Integer id);

}