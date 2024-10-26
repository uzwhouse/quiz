package services;

import models.User;

import java.util.LinkedHashSet;

public interface UserService extends CRUDService, Quiz {
    User login(String username, String password);

    User register(String username, String password);

    User logout();

    User getSessionUser();

    @Override
    LinkedHashSet<User> readAll();
}
