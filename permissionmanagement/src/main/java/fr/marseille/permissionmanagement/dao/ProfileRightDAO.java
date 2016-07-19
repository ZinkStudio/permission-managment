package fr.marseille.permissionmanagement.dao;

import java.util.List;
import fr.marseille.permissionmanagement.model.Profile;
import fr.marseille.permissionmanagement.model.Right;

/**
 * 
 */
public interface ProfileRightDAO {

    /**
     * 
     */
    public void include(Profile profile, List<Right> rights);

    /**
     * 
     */
    public void exclude(Integer id_profile, Integer id_right);

    /**
     * 
     */
    public void include(Profile profile, Right right);

    /**
     * 
     */
    public void exclude(Integer id_profile, List<Right> rights);

}