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
    public void init() throws DAOException {
        // profiles = controller.createProfiles();
        controller.findAll();
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
