package fr.marseille.permissionmanagement.bean;

import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import fr.marseille.permissionmanagement.model.User;
import fr.marseille.permissionmanagement.service.UserService;

@ManagedBean(name = "userController")
@ApplicationScoped
public class UserController {

    private UserService userService = new UserService();

    public List<User> createUsers() {
        return userService.createUsers();
    }

}