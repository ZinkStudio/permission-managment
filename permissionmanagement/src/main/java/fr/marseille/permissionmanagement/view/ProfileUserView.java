package fr.marseille.permissionmanagement.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import org.primefaces.model.DualListModel;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Profile;
import fr.marseille.permissionmanagement.model.User;
import fr.marseille.permissionmanagement.service.ProfileService;
import fr.marseille.permissionmanagement.service.UserService;

@ManagedBean
public class ProfileUserView implements Serializable {
    /**
     * 
     */
    private static final long     serialVersionUID = 1L;

    private DualListModel<String> userNames        = new DualListModel<String>();
    private UserService           userService      = new UserService();
    private ProfileService        profileService   = new ProfileService();

    @ManagedProperty("#{dtProfileView}")
    private ProfileView           profileView;

    @PostConstruct
    public void init() {
        List<String> usersSource = new ArrayList<String>();
        List<String> usersTarget = new ArrayList<String>();
        List<User> allUsers = new ArrayList<User>();

        try {
            allUsers = userService.findAll();

        } catch (ServiceException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Error while Getting Users: " + e.getMessage()));
        }

        for (User user : allUsers) {
            if (profileView.getProfile().getUsers().contains(user)) {
                usersTarget.add((user.getId() + "#" + user.getName()));
            } else {
                usersSource.add(user.getId() + "#" + user.getName());
            }
        }

        userNames = new DualListModel<String>(usersSource, usersTarget);
    }

    public DualListModel<String> getUserNames() {
        return userNames;
    }

    public void setUserNames(DualListModel<String> userNames) {
        this.userNames = userNames;
    }

    public ProfileView getProfileView() {
        return profileView;
    }

    public void setProfileView(ProfileView profileView) {
        this.profileView = profileView;
    }

    public void update() throws ServiceException {
        Profile profile = profileView.getProfile();
        profile.setUsers(new ArrayList<User>());

        for (User user : userService.findAll()) {
            user.getProfiles().remove(profile);
            userService.update(user);
        }
        // le mappedby oblige à mettre à jour le profile
        for (String userString : userNames.getTarget()) {
            String[] split = userString.split("#");
            int userId = Integer.parseInt(split[0]);
            User user = userService.find(userId);
            profile.getUsers().add(user);

        }
        profileService.update(profile);
    }
}
