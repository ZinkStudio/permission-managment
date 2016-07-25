package fr.marseille.permissionmanagement.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import fr.marseille.permissionmanagement.bean.UserController;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.User;

@ManagedBean(name = "userView")
@SessionScoped
public class UserView implements Serializable {

    /**
     * 
     */
    private static final long             serialVersionUID  = 1L;

    private String                        linkUpdate        = "updateUser";
    private FacesContext                  facesContext      = FacesContext.getCurrentInstance();
    private ConfigurableNavigationHandler navigationHandler = (ConfigurableNavigationHandler) facesContext
            .getApplication().getNavigationHandler();

    private List<User>                    users;

    @ManagedProperty("#{userController}")
    private UserController                controller;

    // @PostConstruct (appel une seule fois la methode)
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
        init();
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setController(UserController controller) {
        this.controller = controller;
    }

    public String getLinkUpdate() {
        return linkUpdate;
    }

    public void redirectCreate(ComponentSystemEvent event) {
        navigationHandler.performNavigation("userCreate.jsf?index=0&jftfdi=&jffi=userCreate");
    }
}
