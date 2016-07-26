package fr.marseille.permissionmanagement.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.DualListModel;

@ManagedBean
public class UserProfilesView implements Serializable {
    /**
    * 
    */
    private static final long     serialVersionUID = 1L;
    private DualListModel<String> profiles         = new DualListModel<String>();

    @PostConstruct
    public void init() {
        // liste de tous les proofils dans source et dans
        List<String> profilesSource = new ArrayList<String>();
        List<String> profilesTarget = new ArrayList<String>();

        // On utilise les methodes affect/unaffect
        // profileSource recupere tous les profils de la table profile (findAll)
        // profileTarget recupere tous les profils de l'utilisateur (findById)

        for (int i = 0; i < 10; i++) {
            profilesSource.add("testSource" + i);

        }

        profiles = new DualListModel<String>(profilesSource, profilesTarget);

    }

    public DualListModel<String> getProfiles() {
        // if (profiles.getSource().isEmpty() || profiles.getTarget().isEmpty()) {
        // init();
        // }
        return profiles;
    }

    public void setProfiles(DualListModel<String> profiles) {
        this.profiles = profiles;
    }
}
