package fr.marseille.permissionmanagement.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Profile;
import fr.marseille.permissionmanagement.service.ProfileService;

@ManagedBean
@ViewScoped
public class ProfileSaveView {
    private ProfileService profileService = new ProfileService();
    private Profile        profile        = new Profile();

    public void save() throws ServiceException {
        profileService.save(profile);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Saved"));

    }

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

    public ProfileSaveView() {
        super();

    }

}
