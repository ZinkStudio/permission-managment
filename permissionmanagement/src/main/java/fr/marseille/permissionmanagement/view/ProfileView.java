package fr.marseille.permissionmanagement.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import fr.marseille.permissionmanagement.bean.ProfileController;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Profile;

@ManagedBean(name = "dtProfileView")
@RequestScoped
public class ProfileView implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Profile>     profiles;
    private Profile           profile;

    @ManagedProperty("#{profileController}")
    private ProfileController controller;

    // @PostConstruct
    public void init() {
        List<Profile> profiles = new ArrayList<>();
        Profile profile = new Profile();
        // profile.setName("tota");
        // profile.setDescription("dsds");

        // profiles.addAll(controller.createProfiles());

        try {

            profiles = controller.findAll();
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        this.profiles = profiles;
    }

    // List<Profile> findAll() throws ServiceException {
    // return profiles = controller.findAll();
    //
    // }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    public List<Profile> getProfiles() {
        init();
        return profiles;
    }

    public void setController(ProfileController controller) {
        this.controller = controller;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

}
