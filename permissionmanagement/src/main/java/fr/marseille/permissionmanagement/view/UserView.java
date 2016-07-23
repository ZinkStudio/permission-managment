package fr.marseille.permissionmanagement.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import fr.marseille.permissionmanagement.bean.UserController;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.User;

@ManagedBean(name = "dtUserView")
@ViewScoped
public class UserView implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String            linkUpdate       = "updateUser";

    private List<User>        users;

    @ManagedProperty("#{userController}")
    private UserController    controller;

    @PostConstruct
    public void init() {
        List<User> users = new ArrayList<>();
        try {
            users = controller.findAll();

        } catch (ServiceException e) {
            e.printStackTrace();
        }
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setController(UserController controller) {
        this.controller = controller;
    }

    public String getLinkUpdate() {
        return linkUpdate;
    }
}
