package fr.marseille.permissionmanagement.runtime;

import fr.marseille.permissionmanagement.model.User;
import fr.marseille.permissionmanagement.service.UserService;
import fr.marseille.permissionmanagement.util.JPAUtil;

public class StartUser {
    private static UserService userService = new UserService();

    public static void main(String[] args) {

        insertUsers();
        JPAUtil.closeAll();

    }

    private static void insertUsers() {
        String name = "Martin";
        String firstName = "Julie";
        String comment = "super comment";

        for (int i = 0; i < 30; i++) {
            User user = new User();
            user.setName(name + i);
            user.setFirstName(firstName + i);
            user.setComment(comment + i);
            JPAUtil.getEntityManager().getTransaction().begin();
            JPAUtil.getEntityManager().persist(user);
            JPAUtil.getEntityManager().getTransaction().commit();

        }

    }
}
