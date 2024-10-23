package serviceImpl;

import models.User;
import services.Quiz;
import services.UserService;

import java.util.LinkedHashSet;
import java.util.LinkedList;

public class UserServiceImpl implements UserService, Quiz {

//    User -> username bo'yicha unique'
    private LinkedHashSet<User> users = new LinkedHashSet<>();
//    private User session;

    @Override
    public User login(String username, String password) {
        return null;
    }

    @Override
    public User register(String username, String password) {
        return null;
    }

    @Override
    public User logout() {
        return null;
    }

    @Override
    public Object create(Object object) {
        return null;
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
}
