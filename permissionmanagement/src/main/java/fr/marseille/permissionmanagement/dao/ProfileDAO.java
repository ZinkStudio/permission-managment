package fr.marseille.permissionmanagement.dao;

import fr.marseille.permissionmanagement.model.Profile;

/**
 * 
 */
public interface ProfileDAO {

    /**
     * 
     */
    public void save(Profile profile);

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
    public void update(Profile profile);

    /**
     * 
     */
    public void delete(Integer id);

}