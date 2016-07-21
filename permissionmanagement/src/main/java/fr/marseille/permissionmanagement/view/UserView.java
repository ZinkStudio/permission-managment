package fr.marseille.permissionmanagement.view;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import fr.marseille.permissionmanagement.bean.UserController;
import fr.marseille.permissionmanagement.model.User;

@ManagedBean(name = "dtUserView")
@ViewScoped
public class UserView implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private List<User>        users;

    @ManagedProperty("#{userController}")
    private UserController    controller;

    @PostConstruct
    public void init() {
        users = controller.createUsers();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setController(UserController controller) {
        this.controller = controller;
    }
}
