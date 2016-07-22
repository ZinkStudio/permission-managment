package fr.marseille.permissionmanagement.runtime;

import java.util.ArrayList;
import java.util.List;
import fr.marseille.permissionmanagement.exception.DAOException;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Profile;
import fr.marseille.permissionmanagement.model.User;
import fr.marseille.permissionmanagement.service.ProfileService;
import fr.marseille.permissionmanagement.service.UserService;
import fr.marseille.permissionmanagement.util.JPAUtil;

public class StartProfile {
    private static ProfileService profileService = new ProfileService();
    private static UserService    userService    = new UserService();

    public static void main(String[] args) throws ServiceException, DAOException {

        // JPAUtil.getEntityManager().getTransaction().begin();
        //
        // JPAUtil.getEntityManager().getTransaction().commit();
        affectUser();
        JPAUtil.closeAll();

    }

    private static void affectUser() throws ServiceException, DAOException {
        User user = userService.find(1);
        Profile profile = profileService.find(1);

        profile.getUsers().add(user);

        profileService.update(profile);

    }

    private static void createUserAndProfile() {
        ProfileService profil = new ProfileService();
        UserService use = new UserService();
        User user = new User();
        user.setName("louiza");
        user.setFirstName("zerrad");
        user.setComment("J'aime les chips :) ");

        Profile profile = new Profile();
        profile.setName("Admin5");
        profile.setDescription("Administrateur de l'application5");
        profile.setPermissions(null);

        try {
            profil.save(profile);
        } catch (DAOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        List<User> users = new ArrayList<>();
        users.add(user);
        // profil.setUsers(users);

        List<Profile> profiles = new ArrayList<>();
        profiles.add(profile);
        user.setProfiles(profiles);
        try {
            use.save(user);
        } catch (ServiceException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            List<User> findAll = use.findAll();
        } catch (ServiceException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
