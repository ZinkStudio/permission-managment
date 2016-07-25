package fr.marseille.permissionmanagement.view;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.User;
import fr.marseille.permissionmanagement.service.UserService;
import fr.marseille.permissionmanagement.util.JPAUtil;

@ManagedBean
@ApplicationScoped
public class UserUpdateView implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private UserService       userService      = new UserService();
    private User              user;

    public void update() {
        try {
            // JPAUtil.beginTransaction();
            // JPAUtil.getEntityManager().merge(user);
            // JPAUtil.commitTransaction();
            userService.update(user);
        } catch (ServiceException e) {
            JPAUtil.closeAll();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Error while Updating the User : " + e.getMessage()));
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Updated"));
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
