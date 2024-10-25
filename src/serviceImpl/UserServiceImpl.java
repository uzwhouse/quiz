package serviceImpl;

import models.User;
import services.Quiz;
import services.UserService;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Objects;

import static utils.Utils.*;

public class UserServiceImpl implements UserService, Quiz {

    //    User unique for username
    private LinkedHashSet<User> users = new LinkedHashSet<>();
    private User session;

    @Override
    public User login(String username, String password) {
        User user = findByUsername(username);
        if (Objects.nonNull(user) &&
                Objects.equals(username, user.getUsername()) &&
                Objects.equals(password, user.getPassword())) {
            System.out.printf(GREEN + "'%s' user successfully login" + RESET, user);
            return user;
        }
        System.out.printf(RED + "Wrong login or password" + RESET);
        return null;
    }

    @Override
    public User register(String username, String password) {
        return (User) create(new User(username, password));
    }

    @Override
    public User logout() {
        return null;
    }

    @Override
    public Object create(Object user) {
        if (Objects.nonNull(findByUsername(
                ((User) user).getUsername()))) {
            System.out.println(RED + "User already exists" + RESET);
            return users;
        } else {
            System.out.println(GREEN + "Creating new user" + RESET);
            System.out.println(user);
            return users.add((User) user);
        }

//        return Objects.nonNull(findByUsername((User) user)) ? users : users.add((User) user);
    }

    @Override
    public Object read(String id) {
        return null;
    }

    @Override
    public Object update(String id) {
        return null;
    }

    @Override
    public Object delete(String id) {
        return null;
    }

    @Override
    public LinkedList<Object> readAll() {
        return null;
    }

    @Override
    public void startQuiz() {

    }

    @Override
    public User getSessionUser() {
        return null;
    }

    private User findByUsername(String username) {
        for (User user : users)
            if (user.getUsername().equalsIgnoreCase(username)) return user;
        System.out.println("User not found");
        return null;
    }
}
