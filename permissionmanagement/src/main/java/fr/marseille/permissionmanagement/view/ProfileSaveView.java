package fr.marseille.permissionmanagement.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Profile;
import fr.marseille.permissionmanagement.service.ProfileService;

// TODO: Auto-generated Javadoc
/**
 * The Class ProfileSaveView.
 */
@ManagedBean
@ViewScoped
public class ProfileSaveView {
    
    /** The profile service. */
    private ProfileService profileService = new ProfileService();
    
    /** The profile. */
    private Profile        profile        = new Profile();

    /**
     * Save.
     *
     * @throws ServiceException the service exception
     */
    public void save() throws ServiceException {
        profileService.save(profile);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Saved"));

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
     * Gets the profile.
     *
     * @return the profile
     */
    public Profile getProfile() {
        return profile;
    }

    /**
     * Sets the profile.
     *
     * @param profile the new profile
     */
    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    /**
     * Instantiates a new profile save view.
     */
    public ProfileSaveView() {
        super();

    }

}
