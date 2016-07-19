package fr.marseille.permissionmanagement.dao.impl;

import java.util.List;
import fr.marseille.permissionmanagement.dao.ProfileRightDAO;
import fr.marseille.permissionmanagement.model.Profile;
import fr.marseille.permissionmanagement.model.Right;

public class ProfileRightJPADAO implements ProfileRightDAO {

    public ProfileRightJPADAO() {
    }

    @Override
    public void include(Profile profile, List<Right> rights) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exclude(Integer id_profile, Integer id_right) {
        // TODO Auto-generated method stub

    }

    @Override
    public void include(Profile profile, Right right) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exclude(Integer id_profile, List<Right> rights) {
        // TODO Auto-generated method stub

    }

}