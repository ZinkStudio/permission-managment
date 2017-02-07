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

// TODO: Auto-generated Javadoc
/**
 * The Class ProfilePermissionView.
 */
@ManagedBean
public class ProfilePermissionView implements Serializable {

    /**
     * 
     */
    private static final long     serialVersionUID  = 1L;

    /** The permission names. */
    private DualListModel<String> permissionNames   = new DualListModel<String>();

    /** The permission service. */
    private PermissionService     permissionService = new PermissionService();

    /** The profile service. */
    private ProfileService        profileService    = new ProfileService();

    /** The profile view. */
    @ManagedProperty("#{dtProfileView}")
    private ProfileView           profileView;

    /**
     * Inits the.
     */
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

    /**
     * Gets the permission names.
     *
     * @return the permission names
     */
    public DualListModel<String> getPermissionNames() {
        return permissionNames;
    }

    /**
     * Sets the permission names.
     *
     * @param permissionNames
     *            the new permission names
     */
    public void setPermissionNames(DualListModel<String> permissionNames) {
        this.permissionNames = permissionNames;
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
     * @param permissionService
     *            the new permission service
     */
    public void setPermissionService(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    /**
     * Gets the profile view.
     *
     * @return the profile view
     */
    public ProfileView getProfileView() {
        return profileView;
    }

    /**
     * Sets the profile view.
     *
     * @param profileView
     *            the new profile view
     */
    public void setProfileView(ProfileView profileView) {
        this.profileView = profileView;
    }

    /**
     * Update.
     *
     * @throws ServiceException
     *             the service exception
     */
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
