package fr.marseille.permissionmanagement.view;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import fr.marseille.permissionmanagement.bean.PermissionController;

@ManagedBean
@ViewScoped
public class IndexView implements Serializable {

    private static final long             serialVersionUID  = 1L;
    private FacesContext                  facesContext      = FacesContext.getCurrentInstance();
    private ConfigurableNavigationHandler navigationHandler = (ConfigurableNavigationHandler) facesContext
            .getApplication().getNavigationHandler();

    @ManagedProperty("#{permissionController}")
    private PermissionController          controller;

    @PostConstruct
    public void init() {
    }

    public void redirectIndex(ComponentSystemEvent event) {
        navigationHandler.performNavigation("userReadAll.jsf?index=0&jftfdi=&jffi=userReadAll");
    }

    public void setController(PermissionController permissionController) {
        this.controller = permissionController;
    }
}
