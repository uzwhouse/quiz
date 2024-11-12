package serviceImpl.user;

import models.User;
import services.UserService;

import java.util.LinkedHashSet;
import java.util.Objects;

import static roles.UserRole.*;
import static serviceImpl.user.UserFileOperation.*;
import static utils.Utils.*;

public class UserServiceImpl extends LoginService implements UserService {

    /**
     * User -> unique for username
     *
     * @override clone
     * @override hashCode
     */

    @Override
    public User create(Object object) {
        return registerUser((User) object);
    }

    @Override
    public User read(String username) {
        User user = findByUsername(username);
        if (Objects.nonNull(user)) {
            System.out.println(CYAN + user + RESET);
            System.out.println();
            return user;
        }
        return notFound(username);
    }

    @Override
    public User update(String username) {
        LinkedHashSet<User> localUsers = readAllUsersFromFile();
        User user = findByUsername(username);
        if (Objects.nonNull(user)) {
            for (User u : localUsers) {
                if (u.getUsername().equals(username)) {
                    u.setUsername(readConsole("username : ").toUpperCase());
                    u.setPassword(readConsole("password : "));
                    u.setUserRole(getUserRole(readConsole("User Role : ")));
                }
            }

            System.out.printf(CYAN + "'%s' user successfully updated\n\n" + RESET, user);
            writeUsersListToFile(localUsers);
            return user;
        }
        return notFound(username);
    }



    @Override
    public User delete(String username) {
        LinkedHashSet<User> localUsers = readAllUsersFromFile();
        User user = findByUsername(username);
        if (Objects.nonNull(user)) {
            localUsers.remove(user);
            writeUsersListToFile(localUsers);
            System.out.printf(RED + "'%s' '%s'" + RESET + CYAN + "\nUser successfully deleted\n\n" + RESET,
                    user.getUsername(), user.getPassword());
            return user;
        }
        return notFound(username);
    }

    @Override
    public LinkedHashSet<User> readAll() {
        return readAllUsersFromFile();
    }

    @Override
    public void startQuiz() {
        StartQuiz startQuiz = new StartQuiz();
        LinkedHashSet<User> localUsers = readAllUsersFromFile();
        for (User u : localUsers) {
            if (u.getUsername().equals(session.getUsername())) {
                u.setResults(startQuiz.quizStart());
                System.out.printf(GREEN + "'%s's result%n" + RESET, session.getUsername());
                System.out.println(CYAN + u.getResults() + RESET);
            }
        }
        writeUsersListToFile(localUsers);
        logoutUser();
    }

    @Override
    public User login(String username, String password) {
        return loginUser(username, password);
    }

    @Override
    public User register(String username, String password) {
        return registerUser(new User(username, password));
    }

    @Override
    public void logout() {
        logoutUser();
    }

    @Override
    public User getSessionUser() {
        return sessionUser();
    }

 /*   @Override
    public User updateForTeacher(String username) {
        LinkedHashSet<User> localUsers = readAllUsersFromFile();
        User user = findByUsername(username);
        int pr = Integer.parseInt(readConsole("%: "));

        for (User u : localUsers) {
            if (u.getUsername().equals(username)) {
                for (int i = 0; i < pr; i++) {
                    for (Result result : u.getResults()) {
                        result.setAnswer();
                    }
                }
            }
        }

        return null;
    }*/

    {
        writeUserToFile(new User("aa", "a", ADMIN));
        appendUserToFile(new User("tt", "t", TEACHER));
        appendUserToFile(new User("ss", "s", STUDENT));
    }

}
