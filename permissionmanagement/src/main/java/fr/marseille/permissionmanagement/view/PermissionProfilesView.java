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

// TODO: Auto-generated Javadoc
/**
 * The Class PermissionProfilesView.
 */
@ManagedBean
@RequestScoped
public class PermissionProfilesView implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long     serialVersionUID  = 1L;
    
    /** The profile names. */
    private DualListModel<String> profileNames      = new DualListModel<String>();
    
    /** The profile service. */
    private ProfileService        profileService    = new ProfileService();
    
    /** The permission service. */
    private PermissionService     permissionService = new PermissionService();

    /** The permission view. */
    @ManagedProperty("#{permissionView}")
    private PermissionView        permissionView;

    /**
     * Inits the.
     */
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

    /**
     * Gets the profile names.
     *
     * @return the profile names
     */
    public DualListModel<String> getProfileNames() {
        return profileNames;
    }

    /**
     * Sets the profile names.
     *
     * @param profileNames the new profile names
     */
    public void setProfileNames(DualListModel<String> profileNames) {
        this.profileNames = profileNames;
    }

    /**
     * Gets the permission view.
     *
     * @return the permission view
     */
    public PermissionView getPermissionView() {
        return permissionView;
    }

    /**
     * Sets the permission view.
     *
     * @param permissionView the new permission view
     */
    public void setPermissionView(PermissionView permissionView) {
        this.permissionView = permissionView;
    }

    /**
     * Gets the profile service.
     *
     * @return the profile service
     */
    public ProfileService getProfileService() {
        return profileService;
    }

    /**
     * Sets the profile service.
     *
     * @param profileService the new profile service
     */
    public void setProfileService(ProfileService profileService) {
        this.profileService = profileService;
    }

    /**
     * Gets the permission service.
     *
     * @return the permission service
     */
    public PermissionService getPermissionService() {
        return permissionService;
    }

    /**
     * Sets the permission service.
     *
     * @param permissionService the new permission service
     */
    public void setPermissionService(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    /**
     * Update.
     *
     * @throws ServiceException the service exception
     */
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
