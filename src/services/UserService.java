package services;

import base.Base;
import models.User;

public interface UserService extends Base {

    void create(User user);

    void delete(String username);

    void update(String username);

    User getByUsername(String username);

    void getAll();

    int getIndex(String username);

    void register(User user);

    void login(String username, String password);

    User session();

    void logout();

    void quiz();

}
