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

    private List<User>        users;

    @ManagedProperty("#{userController}")
    private UserController    controller;

    @PostConstruct
    public void init() throws ServiceException {
        // users = controller.createUsers();
        List<User> users = new ArrayList<User>();
        User user = new User();
        user.setId(2);
        user.setName("Martin");
        user.setFirstName("Lucie");
        user.setComment("test de commentaires");

        try {
            controller.save(user);
            users.add(user);
            users = controller.findAll();
        } catch (ServiceException e) {
            users.add(user);
            e.printStackTrace();
        } finally {
            users.add(user);
        }
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setController(UserController controller) {
        this.controller = controller;
    }
}
