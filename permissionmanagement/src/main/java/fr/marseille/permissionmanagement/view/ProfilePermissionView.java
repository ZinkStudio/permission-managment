package fr.marseille.permissionmanagement.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import org.primefaces.model.DualListModel;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Permission;
import fr.marseille.permissionmanagement.service.PermissionService;

@ManagedBean

public class ProfilePermissionView implements Serializable {
    private DualListModel<String> permissionNames   = new DualListModel<String>();
    private PermissionService     permissionService = new PermissionService();

    @ManagedProperty("#{dtProfileView}")
    private ProfileView           profileView;

    @PostConstruct
    public void init() {
        List<String> permissionSource = new ArrayList<String>();
        List<String> permissionsTarget = new ArrayList<String>();
        List<Permission> allPermissions = new ArrayList<Permission>();

        try {
            allPermissions = permissionService.findAll();

        } catch (ServiceException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Error while Getting Permission: " + e.getMessage()));
        }

        for (Permission permission : allPermissions) {
            if (profileView.getProfile().getPermissions().contains(permission)) {
                permissionsTarget.add(permission.getEntry());
            } else {
                permissionSource.add(permission.getEntry());
            }
        }

        permissionNames = new DualListModel<String>(permissionSource, permissionsTarget);
    }

    public DualListModel<String> getPermissionNames() {
        return permissionNames;
    }

    public void setPermissionNames(DualListModel<String> permissionNames) {
        this.permissionNames = permissionNames;
    }

    public PermissionService getPermissionService() {
        return permissionService;
    }

    public void setPermissionService(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    public ProfileView getProfileView() {
        return profileView;
    }

    public void setProfileView(ProfileView profileView) {
        this.profileView = profileView;
    }

}
