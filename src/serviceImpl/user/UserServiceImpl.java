package serviceImpl.user;

import models.User;
import roles.UserRole;
import services.UserService;

import java.util.LinkedHashSet;
import java.util.Objects;

import static roles.UserRole.*;
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
        User user = findByUsername(username);
        if (Objects.nonNull(user)) {
            user.setUsername(readConsole("username : "));
            user.setPassword(readConsole("password : "));
            user.setUserRole(UserRole.valueOf(readConsole("User Role : ")));
            System.out.printf(CYAN + "'%s' user successfully updated\n\n" + RESET, user);
            return user;
        }
        return notFound(username);
    }

    @Override
    public User delete(String username) {
        User user = findByUsername(username);
        if (Objects.nonNull(user)) {
            System.out.printf(RED + "'%s' '%s'" + RESET + CYAN + "\nUser successfully deleted\n\n" + RESET,
                    user.getUsername(), user.getPassword());
            users.remove(user);
            return user;
        }
        return notFound(username);
    }

    @Override
    public LinkedHashSet<User> readAll() {
        return users;
    }

    @Override
    public void startQuiz() {
        session.setResults(StartQuiz.startQuiz());
        System.out.printf(GREEN + "'%s's result%n" + RESET, session.getUsername());
        System.out.println(CYAN + session.getResults() + RESET);
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

    {
        users.add(new User("a", "a", ADMIN));
        users.add(new User("t", "t", TEACHER));
        users.add(new User("s", "s", STUDENT));
    }

}
