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
import fr.marseille.permissionmanagement.model.Profile;
import fr.marseille.permissionmanagement.service.ProfileService;

@ManagedBean
public class UserProfilesView implements Serializable {
    /**
    * 
    */
    private static final long     serialVersionUID = 1L;

    private DualListModel<String> profileNames     = new DualListModel<String>();

    private ProfileService        profileService   = new ProfileService();

    @ManagedProperty("#{userView}")
    private UserView              userView;

    @PostConstruct
    public void init() {
        List<String> profilesSource = new ArrayList<String>();
        List<String> profilesTarget = new ArrayList<String>();

        // for (int i = 0; i < 10; i++) {
        // profilesSource.add("testSource" + i);
        //
        // }

        profilesSource.add("");
        List<Profile> allProfiles = new ArrayList<Profile>();
        List<Profile> almostAllProfiles = new ArrayList<Profile>();

        try {
            allProfiles = profileService.findAll();
            almostAllProfiles.addAll(allProfiles);
        } catch (ServiceException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Error while Getting Profiles: " + e.getMessage()));
        }

        for (Profile profile : allProfiles) {
            if (userView.getUser().getProfiles().contains(profile)) {
                almostAllProfiles.remove(profile);
            }
        }

        for (Profile profile : userView.getUser().getProfiles()) {
            profilesTarget.add(profile.getName());
        }

        for (Profile profile : almostAllProfiles) {
            profilesSource.add(profile.getName());
        }
        // for (Profile item : myProfiles) {
        // profilesSource.add(item.getName().toString());
        // }

        // List<Profile> userProfiles = user.getProfiles();
        // for (Profile element : userProfiles) {
        // profilesTarget.add(element.getName().toString());
        // }

        profileNames = new DualListModel<String>(profilesSource, profilesTarget);
    }

    public DualListModel<String> getProfiles() {
        return profileNames;
    }

    public void setProfiles(DualListModel<String> profilesView) {
        this.profileNames = profilesView;
    }

    public UserView getUserView() {
        return userView;
    }

    public void setUserView(UserView userView) {
        this.userView = userView;
    }

}
