package fr.marseille.permissionmanagement.dao.impl;

import java.util.List;
import fr.marseille.permissionmanagement.dao.ProfileUserDAO;
import fr.marseille.permissionmanagement.model.Profile;
import fr.marseille.permissionmanagement.model.User;

/**
 * 
 */
public class ProfileUserJPADAO implements ProfileUserDAO {

    /**
     * Default constructor
     */
    public ProfileUserJPADAO() {

    }

    @Override
    public void affect(User user, List<Profile> profiles) {
        // TODO Auto-generated method stub

    }

    @Override
    public void unaffect(Integer id_user, Integer id_profile) {
        // TODO Auto-generated method stub

    }

    @Override
    public void affect(User user, Profile profile) {
        // TODO Auto-generated method stub

    }

    @Override
    public void unaffect(Integer id_user, List<Profile> profiles) {
        // TODO Auto-generated method stub

    }

}