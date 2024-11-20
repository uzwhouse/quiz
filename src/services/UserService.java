package services;

import models.User;

import java.util.logging.Logger;

public interface UserService extends CRUDService, Quiz {

    User login(String username, String password);

    User register(String username, String password);

    void logout();

    User getSessionUser();

    void updateForTeacher(String username);
}
