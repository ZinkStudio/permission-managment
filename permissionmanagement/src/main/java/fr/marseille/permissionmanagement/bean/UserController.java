package fr.marseille.permissionmanagement.bean;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.User;
import fr.marseille.permissionmanagement.service.UserService;

@ManagedBean(name = "userController")
@SessionScoped
public class UserController implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private UserService       userService      = new UserService();

    public List<User> createUsers() {
        return userService.createUsers();
    }

    public List<User> findAll() throws ServiceException {
        return userService.findAll();
    }

    public User save(User user) throws ServiceException {
        return userService.save(user);
    }

    public void delete(User user) throws ServiceException {
        userService.delete(user.getId());
    }

}