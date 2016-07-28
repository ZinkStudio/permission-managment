package fr.marseille.permissionmanagement.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.DualListModel;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Permission;
import fr.marseille.permissionmanagement.model.Profile;
import fr.marseille.permissionmanagement.service.PermissionService;
import fr.marseille.permissionmanagement.service.ProfileService;

@ManagedBean
@RequestScoped
public class PermissionProfilesView implements Serializable {

    private static final long     serialVersionUID  = 1L;
    private DualListModel<String> profileNames      = new DualListModel<String>();
    private ProfileService        profileService    = new ProfileService();
    private PermissionService     permissionService = new PermissionService();

    @ManagedProperty("#{permissionView}")
    private PermissionView        permissionView;

    // @PostConstruct
    public void init() {
        List<String> profilesSource = new ArrayList<String>();
        List<String> profilesTarget = new ArrayList<String>();
        List<Profile> profiles = new ArrayList<Profile>();

        try {
            profiles = profileService.findAll();

        } catch (ServiceException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Error while Getting Profiles: " + e.getMessage()));
        }

        for (Profile profile : profiles) {
            if (permissionView.getPermission().getProfiles().contains(profile)) {
                profilesTarget.add(profile.getId() + "#" + profile.getName());
            } else {
                profilesSource.add(profile.getId() + "#" + profile.getName());
            }
        }

        profileNames = new DualListModel<String>(profilesSource, profilesTarget);
    }

    public DualListModel<String> getProfileNames() {
        return profileNames;
    }

    public void setProfileNames(DualListModel<String> profileNames) {
        this.profileNames = profileNames;
    }

    public PermissionView getPermissionView() {
        return permissionView;
    }

    public void setPermissionView(PermissionView permissionView) {
        this.permissionView = permissionView;
    }

    public ProfileService getProfileService() {
        return profileService;
    }

    public void setProfileService(ProfileService profileService) {
        this.profileService = profileService;
    }

    public PermissionService getPermissionService() {
        return permissionService;
    }

    public void setPermissionService(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    public void update() throws ServiceException {
        Permission permission = permissionView.getPermission();
        permission.setProfiles(new ArrayList<Profile>());

        for (Profile profile : profileService.findAll()) {
            profile.getPermissions().remove(permission);
            profileService.update(profile);
        }

        for (String profileString : profileNames.getTarget()) {
            String[] split = profileString.split("#");
            int profileId = Integer.parseInt(split[0]);
            Profile profile = profileService.find(profileId);
            profile.getPermissions().add(permission);
            profileService.update(profile);
        }
    }

}
