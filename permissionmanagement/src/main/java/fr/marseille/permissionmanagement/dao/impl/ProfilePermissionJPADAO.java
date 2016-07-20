package fr.marseille.permissionmanagement.dao.impl;

import java.util.List;
import fr.marseille.permissionmanagement.dao.ProfilePermissionDAO;
import fr.marseille.permissionmanagement.model.Permission;
import fr.marseille.permissionmanagement.model.Profile;

public class ProfilePermissionJPADAO implements ProfilePermissionDAO {

    public ProfilePermissionJPADAO() {
    }

    @Override
    public void include(Profile profile, List<Permission> permissions) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exclude(Integer id_profile, Integer id_permission) {
        // TODO Auto-generated method stub

    }

    @Override
    public void include(Profile profile, Permission permission) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exclude(Integer id_profile, List<Permission> permissions) {
        // TODO Auto-generated method stub

    }

}