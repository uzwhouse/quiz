package services;

import models.User;

import java.util.LinkedHashSet;

public interface UserService extends CRUDService, Quiz {
    @Override
    LinkedHashSet<User> readAll();

    User login(String username, String password);

    User register(String username, String password);

    void logout();

    User getSessionUser();
}
