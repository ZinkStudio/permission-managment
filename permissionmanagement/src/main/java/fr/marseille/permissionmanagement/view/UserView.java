package fr.marseille.permissionmanagement.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import fr.marseille.permissionmanagement.bean.UserController;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.User;

@ManagedBean(name = "userView")
@SessionScoped
public class UserView implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private List<User>        users;

    @ManagedProperty("#{userController}")
    private UserController    controller;

    // @PostConstruct (appel une seule fois la methode)
    public void init() {
        List<User> users = new ArrayList<>();
        try {
            users = controller.findAll();

        } catch (ServiceException e) {
            // e.printStackTrace(); METTRE LOGGER

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

    public void setController(UserController controller) {
        this.controller = controller;
    }
}
