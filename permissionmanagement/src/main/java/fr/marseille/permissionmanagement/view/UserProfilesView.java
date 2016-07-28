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
import fr.marseille.permissionmanagement.model.Profile;
import fr.marseille.permissionmanagement.model.User;
import fr.marseille.permissionmanagement.service.ProfileService;

// TODO: Auto-generated Javadoc
/**
 * The Class UserProfilesView.
 */
@ManagedBean
public class UserProfilesView implements Serializable {
    
    /** The Constant serialVersionUID. */
    private static final long     serialVersionUID = 1L;
    
    /** The profile names. */
    private DualListModel<String> profileNames     = new DualListModel<String>();
    
    /** The profile service. */
    private ProfileService        profileService   = new ProfileService();

    /** The user view. */
    @ManagedProperty("#{userView}")
    private UserView              userView;

    /**
     * Inits the.
     */
    @PostConstruct
    public void init() {
        List<String> profilesSource = new ArrayList<String>();
        List<String> profilesTarget = new ArrayList<String>();
        List<Profile> allProfiles = new ArrayList<Profile>();

        try {
            allProfiles = profileService.findAll();

        } catch (ServiceException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Error while Getting Profiles: " + e.getMessage()));
        }

        for (Profile profile : allProfiles) {
            if (userView.getUser().getProfiles().contains(profile)) {
                profilesTarget.add(profile.getId() + "#" + profile.getName());
            } else {
                profilesSource.add(profile.getId() + "#" + profile.getName());
            }
        }

        profileNames = new DualListModel<String>(profilesSource, profilesTarget);
    }

    /**
     * Gets the profiles.
     *
     * @return the profiles
     */
    public DualListModel<String> getProfiles() {
        return profileNames;
    }

    /**
     * Sets the profiles.
     *
     * @param profilesView the new profiles
     */
    public void setProfiles(DualListModel<String> profilesView) {
        this.profileNames = profilesView;
    }

    /**
     * Gets the user view.
     *
     * @return the user view
     */
    public UserView getUserView() {
        return userView;
    }

    /**
     * Sets the user view.
     *
     * @param userView the new user view
     */
    public void setUserView(UserView userView) {
        this.userView = userView;
    }

    /**
     * Update.
     *
     * @throws ServiceException the service exception
     */
    public void update() throws ServiceException {
        User user = userView.getUser();
        user.setProfiles(new ArrayList<Profile>());

        for (Profile profile : profileService.findAll()) {
            profile.getUsers().remove(user);
            profileService.update(profile);
        }

        for (String profileString : profileNames.getTarget()) {
            String[] split = profileString.split("#");
            int profileId = Integer.parseInt(split[0]);
            Profile profile = profileService.find(profileId);
            profile.getUsers().add(user);
            profileService.update(profile);
        }
    }

}
