package fr.marseille.permissionmanagement.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Profile;
import fr.marseille.permissionmanagement.service.ProfileService;
import fr.marseille.permissionmanagement.util.JPAUtil;

@ManagedBean
@ApplicationScoped
public class ProfileDeleteView {
    private ProfileService profileService = new ProfileService();
    private Profile        profile;

    public ProfileDeleteView() {
        super();
    }

    public void delete(Profile profile) {
        try {
            JPAUtil.beginTransaction();
            JPAUtil.getEntityManager().merge(profile);
            JPAUtil.commitTransaction();
            profileService.delete(profile.getId());

        } catch (ServiceException e) {
            JPAUtil.closeAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error : " + e.getMessage()));
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Profile deleted"));
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
