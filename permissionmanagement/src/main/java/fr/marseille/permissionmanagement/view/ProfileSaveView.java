package fr.marseille.permissionmanagement.view;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Profile;
import fr.marseille.permissionmanagement.service.ProfileService;

// TODO: Auto-generated Javadoc
/**
 * The Class ProfileSaveView.
 */
@ManagedBean
@RequestScoped
public class ProfileSaveView extends BaseView implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The profile service. */
    private ProfileService    profileService   = new ProfileService();

    /** The profile. */
    private Profile           profile;

    /**
     * Inits the.
     */
    @PostConstruct
    public void init() {
        profile = new Profile();
    }

    /**
     * Save.
     */
    public void save() throws ServiceException {
        try {
            profileService.save(profile);
        } catch (ServiceException e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Profile Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Saved : " + profile.toString()));

        this.redirectWithMessages("profileIndex.jsf");
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
     * @param profileService
     *            the new profile service
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
     * @param profile
     *            the new profile
     */
    public void setProfile(Profile profile) {
        this.profile = profile;
    }

}
