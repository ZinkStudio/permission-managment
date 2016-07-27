package fr.marseille.permissionmanagement.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.DualListModel;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Profile;
import fr.marseille.permissionmanagement.model.User;
import fr.marseille.permissionmanagement.service.ProfileService;
import fr.marseille.permissionmanagement.service.UserService;

@ManagedBean
@RequestScoped
public class UserProfilesView implements Serializable {
    /**
    * 
    */
    private static final long     serialVersionUID = 1L;
    private DualListModel<String> profileNames     = new DualListModel<String>();
    private ProfileService        profileService   = new ProfileService();
    private UserService           userService      = new UserService();

    @ManagedProperty("#{userView}")
    private UserView              userView;

    @PostConstruct
    public void init() {
        List<String> profilesSource = new ArrayList<String>();
        List<String> profilesTarget = new ArrayList<String>();
        List<Profile> allProfiles = new ArrayList<Profile>();

        try {
            allProfiles = profileService.findAll();

        } catch (ServiceException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Error while Getting Profiles: " + e.getMessage()));
        }

        for (Profile profile : allProfiles) {
            if (userView.getUser().getProfiles().contains(profile)) {
                profilesTarget.add(profile.getId() + "#" + profile.getName());
            } else {
                profilesSource.add(profile.getId() + "#" + profile.getName());
            }
        }

        profileNames = new DualListModel<String>(profilesSource, profilesTarget);
    }

    public DualListModel<String> getProfiles() {
        return profileNames;
    }

    public void setProfiles(DualListModel<String> profilesView) {
        this.profileNames = profilesView;
    }

    public UserView getUserView() {
        return userView;
    }

    public void setUserView(UserView userView) {
        this.userView = userView;
    }

    public void update() throws ServiceException {
        User user = userView.getUser();
        user.setProfiles(new ArrayList<Profile>());

        for (Profile profile : profileService.findAll()) {
            profile.getUsers().remove(user);
            profileService.update(profile);
        }

        for (String profileString : profileNames.getTarget()) {
            String[] split = profileString.split("#");
            int profileId = Integer.parseInt(split[0]);
            Profile profile = profileService.find(profileId);
            profile.getUsers().add(user);
            profileService.update(profile);
        }
    }

}
