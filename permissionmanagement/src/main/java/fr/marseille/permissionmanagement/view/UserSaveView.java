package fr.marseille.permissionmanagement.view;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.User;
import fr.marseille.permissionmanagement.service.UserService;

@ManagedBean
@ViewScoped
public class UserSaveView implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private UserService       userService      = new UserService();

    private User              user             = new User();

    public void save() {
        try {
            userService.save(user);
        } catch (ServiceException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Error while Saving User: " + e.getMessage()));
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Saved"));
    }

    public User getUser() {
        return this.user;
    }

    public UserSaveView() {
        super();
    }

}
