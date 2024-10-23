package services;

import models.User;

public interface UserService extends CRUDService {
    User login(String username, String password);

    User register(String username, String password);

    User logout();
//    User getSessionUser();
}
