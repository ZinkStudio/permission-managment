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

@ManagedBean
@SessionScoped
public class UserView implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private List<User>        users;
    private User              user;
    private UserService       userService      = new UserService();

    public void init() {
        List<User> users = new ArrayList<>();

        try {
            users = userService.findAll();
        } catch (ServiceException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Error while initializing : " + e.getMessage()));
        }
        this.users = users;
    }

    public List<User> getUsers() {
        init();
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
