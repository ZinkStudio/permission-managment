package fr.marseille.permissionmanagement.dao.impl;

import java.util.List;
import fr.marseille.permissionmanagement.dao.ProfileUserDAO;
import fr.marseille.permissionmanagement.model.Profile;
import fr.marseille.permissionmanagement.model.User;

// TODO: Auto-generated Javadoc
/**
 * The Class ProfileUserJPADAO.
 */
public class ProfileUserJPADAO implements ProfileUserDAO {

    /**
     * Default constructor.
     */
    public ProfileUserJPADAO() {

    }

    /* (non-Javadoc)
     * @see fr.marseille.permissionmanagement.dao.ProfileUserDAO#affect(fr.marseille.permissionmanagement.model.User, java.util.List)
     */
    @Override
    public void affect(User user, List<Profile> profiles) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see fr.marseille.permissionmanagement.dao.ProfileUserDAO#unaffect(java.lang.Integer, java.lang.Integer)
     */
    @Override
    public void unaffect(Integer id_user, Integer id_profile) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see fr.marseille.permissionmanagement.dao.ProfileUserDAO#affect(fr.marseille.permissionmanagement.model.User, fr.marseille.permissionmanagement.model.Profile)
     */
    @Override
    public void affect(User user, Profile profile) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see fr.marseille.permissionmanagement.dao.ProfileUserDAO#unaffect(java.lang.Integer, java.util.List)
     */
    @Override
    public void unaffect(Integer id_user, List<Profile> profiles) {
        // TODO Auto-generated method stub

    }

}