package fr.marseille.permissionmanagement.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.User;
import fr.marseille.permissionmanagement.service.UserService;
import fr.marseille.permissionmanagement.util.JPAUtil;

@ManagedBean
@ApplicationScoped
public class UserDeleteView {
    private UserService userService = new UserService();

    private User        user;

    public void delete(User user) {
        try {
            JPAUtil.beginTransaction();
            JPAUtil.getEntityManager().merge(user);
            JPAUtil.commitTransaction();
            userService.delete(user.getId());
        } catch (ServiceException e) {
            JPAUtil.closeAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error : " + e.getMessage()));
        }

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User deleted"));
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
