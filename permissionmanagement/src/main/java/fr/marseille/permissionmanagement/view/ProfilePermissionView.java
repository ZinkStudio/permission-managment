package fr.marseille.permissionmanagement.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import org.primefaces.model.DualListModel;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Permission;
import fr.marseille.permissionmanagement.model.Profile;
import fr.marseille.permissionmanagement.service.PermissionService;
import fr.marseille.permissionmanagement.service.ProfileService;

@ManagedBean

public class ProfilePermissionView implements Serializable {
    private DualListModel<String> permissionNames   = new DualListModel<String>();
    private PermissionService     permissionService = new PermissionService();
    private ProfileService        profileService    = new ProfileService();

    @ManagedProperty("#{dtProfileView}")
    private ProfileView           profileView;

    @PostConstruct
    public void init() {
        List<String> permissionSource = new ArrayList<String>();
        List<String> permissionsTarget = new ArrayList<String>();
        List<Permission> allPermissions = new ArrayList<Permission>();

        try {
            allPermissions = permissionService.findAll();

        } catch (ServiceException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Error while Getting Permission: " + e.getMessage()));
        }

        for (Permission permission : allPermissions) {
            if (profileView.getProfile().getPermissions().contains(permission)) {
                permissionsTarget.add(permission.getId() + "#" + permission.getEntry());
            } else {
                permissionSource.add(permission.getId() + "#" + permission.getEntry());
            }
        }

        permissionNames = new DualListModel<String>(permissionSource, permissionsTarget);
    }

    public DualListModel<String> getPermissionNames() {
        return permissionNames;
    }

    public void setPermissionNames(DualListModel<String> permissionNames) {
        this.permissionNames = permissionNames;
    }

    public PermissionService getPermissionService() {
        return permissionService;
    }

    public void setPermissionService(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    public ProfileView getProfileView() {
        return profileView;
    }

    public void setProfileView(ProfileView profileView) {
        this.profileView = profileView;
    }

    public void update() throws ServiceException {
        Profile profile = profileView.getProfile();
        profile.setPermissions(new ArrayList<Permission>());

        for (Permission permission : permissionService.findAll()) {
            permission.getProfiles().remove(profile);
            permissionService.update(permission);
        }
        // le mappedby oblige à mettre à jour le profile
        for (String permissionString : permissionNames.getTarget()) {
            String[] split = permissionString.split("#");
            int permissionId = Integer.parseInt(split[0]);
            Permission permission = permissionService.find(permissionId);
            profile.getPermissions().add(permission);

        }
        profileService.update(profile);
    }

}
