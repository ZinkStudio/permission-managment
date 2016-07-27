package fr.marseille.permissionmanagement.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.DualListModel;

@ManagedBean
@SessionScoped
public class ProfileUserInclude implements Serializable {
    private static final long     serialVersionUID = 1L;
    private DualListModel<String> users            = new DualListModel<String>();

    @PostConstruct
    public void init() {
        // liste de tous les utilisateurs dans source et dans
        List<String> usersSource = new ArrayList<String>();
        List<String> usersTarget = new ArrayList<String>();

        // On utilise les methodes include/exclude
        // profileSource recupere tous les users de la table user (findAll)
        // profileTarget recupere tous les users du profil (findById)

        for (int i = 0; i < 10; i++) {
            usersSource.add("testSource" + i);

        }

        users = new DualListModel<String>(usersSource, usersTarget);

    }

    public DualListModel<String> getUsers() {
        return users;
    }

    public void setUsers(DualListModel<String> users) {
        this.users = users;
    }

}
