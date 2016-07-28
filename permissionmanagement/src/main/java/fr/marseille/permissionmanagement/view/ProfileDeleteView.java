package fr.marseille.permissionmanagement.view;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Profile;
import fr.marseille.permissionmanagement.service.ProfileService;
import fr.marseille.permissionmanagement.util.JPAUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class ProfileDeleteView.
 */
@ManagedBean
@SessionScoped
public class ProfileDeleteView implements Serializable {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The profile service. */
    private ProfileService    profileService   = new ProfileService();
    
    /** The profile. */
    private Profile           profile;

    /**
     * Delete.
     *
     * @param id the id
     */
    public void delete(Integer id) {
        try {
            profileService.delete(id);
        } catch (ServiceException e) {
            JPAUtil.closeAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error : " + e.getMessage()));
        }

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("profile deleted"));
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
