package fr.marseille.permissionmanagement.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Profile;
import fr.marseille.permissionmanagement.service.ProfileService;

@ManagedBean(name = "dtProfileView")
@RequestScoped
public class ProfileView implements Serializable {
    private static final long serialVersionUID = 1L;

    private ProfileService    service;
    private List<Profile>     profiles;
    private Profile           profile;

    // @PostConstruct
    public void init() {
        List<Profile> profiles = new ArrayList<>();
        profile = new Profile();
        // profile.setName("tota");
        // profile.setDescription("dsds");

        // profiles.addAll(service.createProfiles());

        try {
            profiles = service.findAll();
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        this.profiles = profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    public List<Profile> getProfiles() {
        init();
        return profiles;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

}
