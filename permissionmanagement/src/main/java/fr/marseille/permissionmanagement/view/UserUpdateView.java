package fr.marseille.permissionmanagement.view;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.User;
import fr.marseille.permissionmanagement.service.UserService;

// TODO: Auto-generated Javadoc
/**
 * The Class UserUpdateView.
 */
@ManagedBean
@SessionScoped
public class UserUpdateView implements Serializable {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The user service. */
    private UserService       userService      = new UserService();
    
    /** The user. */
    private User              user;

    /**
     * Update.
     */
    public void update() {
        try {

            userService.update(user);
        } catch (ServiceException e) {

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Error while Updating the User : " + e.getMessage()));
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Updated"));
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
     * @param user the new user
     */
    public void setUser(User user) {
        this.user = user;
    }
}
