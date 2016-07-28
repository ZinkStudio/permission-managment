package fr.marseille.permissionmanagement.dao;

import java.util.List;
import fr.marseille.permissionmanagement.model.Profile;
import fr.marseille.permissionmanagement.model.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProfileUserDAO.
 */
public interface ProfileUserDAO {

    /**
     * Affect.
     *
     * @param user the user
     * @param profiles the profiles
     */
    public void affect(User user, List<Profile> profiles);

    /**
     * Unaffect.
     *
     * @param id_user the id_user
     * @param id_profile the id_profile
     */
    public void unaffect(Integer id_user, Integer id_profile);

    /**
     * Affect.
     *
     * @param user the user
     * @param profile the profile
     */
    public void affect(User user, Profile profile);

    /**
     * Unaffect.
     *
     * @param id_user the id_user
     * @param profiles the profiles
     */
    public void unaffect(Integer id_user, List<Profile> profiles);

}