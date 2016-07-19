package fr.marseille.permissionmanagement.dao;

import java.util.List;
import fr.marseille.permissionmanagement.model.Profile;
import fr.marseille.permissionmanagement.model.User;

/**
 * 
 */
public interface ProfileUserDAO {

    /**
     * 
     */
    public void affect(User user, List<Profile> profiles);

    /**
     * 
     */
    public void unaffect(Integer id_user, Integer id_profile);

    /**
     * 
     */
    public void affect(User user, Profile profile);

    /**
     * 
     */
    public void unaffect(Integer id_user, List<Profile> profiles);

}