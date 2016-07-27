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
import fr.marseille.permissionmanagement.model.User;
import fr.marseille.permissionmanagement.service.UserService;

@ManagedBean
public class ProfileUserView implements Serializable {
    /**
     * 
     */
    private static final long     serialVersionUID = 1L;

    private DualListModel<String> userNames        = new DualListModel<String>();
    private UserService           userService      = new UserService();

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
                usersTarget.add(user.getName());
            } else {
                usersSource.add(user.getName());
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

    // public UserService getUserService() {
    // return userService;
    // }
    //
    // public void setUserService(UserService userService) {
    // this.userService = userService;
    // }

    public ProfileView getProfileView() {
        return profileView;
    }

    public void setProfileView(ProfileView profileView) {
        this.profileView = profileView;
    }

}
