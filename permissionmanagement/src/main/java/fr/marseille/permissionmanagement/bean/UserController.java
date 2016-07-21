package fr.marseille.permissionmanagement.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "UserController")
@RequestScoped
public class UserController {

    private String message = "Welcome to the Users'page ";

    public UserController() {
        super();
    }

    public String nextPage(String page) {
        return page;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}