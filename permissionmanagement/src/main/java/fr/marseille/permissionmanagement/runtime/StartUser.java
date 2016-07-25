package fr.marseille.permissionmanagement.runtime;

import java.util.Random;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.User;
import fr.marseille.permissionmanagement.service.UserService;

public class StartUser {
    protected static String[]    names       = { "Shelton", "Walker", "Doyle", "Holland", "Williams", "Moss", "Wolfe" };
    protected static String[]    firstNames  = { "Maureen", "Bernice", "Julius", "Julie", "Nellie", "Jimmy", "Doreen" };
    protected static String[]    comments    = { "My password is ferrari1", "My phone number is (264)-772-9707",
            "My birthday is 9/7/1971", "My email address is maurice.bennett55@example.com",
            "My address is 3483 third st", };
    protected static UserService userService = new UserService();

    public static void main(String[] args) throws ServiceException {

        insertUsers();
        // JPAUtil.closeAll();

    }

    protected static void insertUsers() throws ServiceException {
        Random rng = new Random();
        for (String name : names) {
            for (String firstname : firstNames) {
                userService.save(new User(null, name, firstname, comments[rng.nextInt(comments.length)]));
            }
        }

    }
}
