package fr.marseille.permissionmanagement.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.User;
import fr.marseille.permissionmanagement.service.UserService;

// TODO: Auto-generated Javadoc
/**
 * The Class UserView.
 */
@ManagedBean
@SessionScoped
public class UserView extends BaseView implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The users. */
    private List<User>        users;

    /** The user. */
    private User              user;

    /** The user service. */
    private UserService       userService      = new UserService();

    /**
     * Inits the.
     */
    // @PostConstruct
    public void init() {
        users = new ArrayList<User>();

        try {
            users = userService.findAll();
        } catch (ServiceException e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "User Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    /**
     * Update.
     */
    public void update() {
        try {
            userService.update(user);
        } catch (ServiceException e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "User Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Updated : " + user.toString()));

        this.redirectWithMessages("userReadAll.jsf");
    }

    /**
     * Delete.
     */
    public void delete() {
        try {
            userService.delete(user.getId());
        } catch (ServiceException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error : " + e.getMessage()));
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User " + user.getId() + " deleted"));

    }

    /**
     * Gets the users.
     *
     * @return the users
     */
    public List<User> getUsers() {
        init();
        return users;
    }

    /**
     * Sets the users.
     *
     * @param users
     *            the new users
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }

    /**
     * Gets the user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user.
     *
     * @param user
     *            the new user
     */
    public void setUser(User user) {
        this.user = user;
    }
}
