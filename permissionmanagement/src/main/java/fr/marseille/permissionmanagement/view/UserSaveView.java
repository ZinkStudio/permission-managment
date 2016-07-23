package fr.marseille.permissionmanagement.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class UserSaveView {

    // attributs
    private String name;
    private String firstName;
    private String comment;

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public UserSaveView() {
        super();
    }

    public void save() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Saved"));
    }
}
