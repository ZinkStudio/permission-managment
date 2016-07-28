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
 * The Class UserDeleteView.
 */
@ManagedBean
@SessionScoped
public class UserDeleteView implements Serializable {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The user service. */
    private UserService       userService      = new UserService();
    
    /** The user. */
    private User              user;

    /**
     * Delete.
     *
     * @param id the id
     */
    public void delete(Integer id) {
        try {
            userService.delete(id);
        } catch (ServiceException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error : " + e.getMessage()));
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User deleted"));
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
