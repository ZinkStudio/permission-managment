package fr.marseille.permissionmanagement.view;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import fr.marseille.permissionmanagement.model.Permission;
import fr.marseille.permissionmanagement.model.Profile;
import fr.marseille.permissionmanagement.service.PermissionService;
import fr.marseille.permissionmanagement.service.ProfileService;

@ManagedBean
@SessionScoped
public class ProfilePermissionInclude implements Serializable {
    private static final long serialVersionUID  = 1L;
    private ProfileService    profileService    = new ProfileService();
    private Profile           profile;
    private Permission        permission;
    private PermissionService permissionService = new PermissionService();

    public ProfileService getProfileService() {
        return profileService;
    }

    public void setProfileService(ProfileService profileService) {
        this.profileService = profileService;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public PermissionService getPermissionService() {
        return permissionService;
    }

    public void setPermissionService(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    protected static void includePermission() {

    }

}
