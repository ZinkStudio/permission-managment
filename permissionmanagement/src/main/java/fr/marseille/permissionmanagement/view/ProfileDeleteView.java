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

@ManagedBean
@SessionScoped
public class ProfileDeleteView implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private ProfileService    profileService   = new ProfileService();
    private Profile           profile;

    public void delete(Integer id) {
        try {
            profileService.delete(id);
        } catch (ServiceException e) {
            JPAUtil.closeAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error : " + e.getMessage()));
        }

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("profile deleted"));
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
