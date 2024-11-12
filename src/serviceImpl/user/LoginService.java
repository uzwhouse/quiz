package serviceImpl.user;

import models.Result;
import models.User;

import java.util.LinkedHashSet;
import java.util.Objects;

import static roles.UserRole.getUserRole;
import static serviceImpl.user.UserFileOperation.*;
import static utils.Utils.*;

public class LoginService {

    protected static User session;

    protected User loginUser(String username, String password) {
        User user = findByUsername(username);
        if (Objects.nonNull(user)) {
            if (username.equalsIgnoreCase(user.getUsername()) &&
                    password.equals(user.getPassword())) {
                session = user;
                System.out.printf(GREEN + "'%s' '%s' successfully login\n\n" + RESET,
                        session.getUsername(), session.getUserRole());
                return session;
            } else {
                System.out.println(RED + "Wrong username or password\n" + RESET);
                return null;
            }
        }
        return notFound(username);
    }

    protected User registerUser(User user) {
        if (Objects.isNull(findByUsername(user.getUsername()))) {
            appendUserToFile(user);
            System.out.printf(GREEN + "'%s' '%s' successfully creating\n\n" + RESET,
                    user.getUsername(), user.getUserRole());
            return user;
        } else {
            System.out.printf(PURPLE + "'%s' '%s' already exists\n\n" + RESET,
                    user.getUsername(), user.getUserRole());
            return null;
        }

//        return Objects.isNull(user) ? user : null;
    }

    protected void logoutUser() {
        System.out.printf(GREEN + "'%s' '%s' successfully logged out\n\n" + RESET,
                session.getUsername(), session.getUserRole());
        session = null;
    }

    protected User notFound(String username) {
        System.out.printf(RED + "'%s' username not found\n\n" + RESET, username);
        return null;
    }

    protected User sessionUser() {
        return session;
    }

    protected User findByUsername(String username) {
        LinkedHashSet<User> localUsers = readAllUsersFromFile();
        for (User user : localUsers)
            if (username.equalsIgnoreCase(user.getUsername())) return user;
        return null;
    }


}
