package fr.marseille.permissionmanagement.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Profile;
import fr.marseille.permissionmanagement.service.ProfileService;

// TODO: Auto-generated Javadoc
/**
 * The Class ProfileView.
 */
@ManagedBean(name = "dtProfileView")
@SessionScoped
public class ProfileView implements Serializable {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The service. */
    private ProfileService    service          = new ProfileService();
    
    /** The profiles. */
    private List<Profile>     profiles;
    
    /** The profile. */
    private Profile           profile;

    /**
     * Inits the.
     */
    public void init() {
        List<Profile> profiles = new ArrayList<>();
        profile = new Profile();

        try {
            profiles = service.findAll();
        } catch (ServiceException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error : " + e.getMessage()));
        }

        this.profiles = profiles;
    }

    /**
     * Sets the profiles.
     *
     * @param profiles the new profiles
     */
    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    /**
     * Gets the profiles.
     *
     * @return the profiles
     */
    public List<Profile> getProfiles() {
        init();
        return profiles;
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

}
