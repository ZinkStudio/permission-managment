package fr.marseille.permissionmanagement.view;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import fr.marseille.permissionmanagement.bean.ProfileController;
import fr.marseille.permissionmanagement.exception.DAOException;
import fr.marseille.permissionmanagement.model.Profile;

@ManagedBean(name = "dtProfileView")
@ViewScoped
public class ProfileView implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Profile>     profiles;

    @ManagedProperty("#{profileController}")
    private ProfileController controller;

    @PostConstruct

    public void init() {
        // List<Profile> profiles = new ArrayList<>();
        Profile profile = new Profile();
        // profile.setName("tota");
        // profile.setDescription("dsds");

        // profiles.addAll(controller.createProfiles());

        try {
            // profiles.addAll(controller.findAll());

            // controller.save(profile);
            profiles = controller.findAll();
        } catch (DAOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.profiles = profiles;
    }

    List<Profile> findAll() throws DAOException {
        return profiles = controller.findAll();

    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setController(ProfileController controller) {
        this.controller = controller;
    }

}
