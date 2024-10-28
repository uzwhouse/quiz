package staticUtils;

import models.User;

import static staticUtils.DefaultSource.readConsole;
import static staticUtils.DefaultSource.userService;

public class LoginMethods {
    public static void logout() {
        userService.logout();
    }

    public static void register() {
        User user = new User(readConsole("username: ")
                .toUpperCase(), readConsole("password: "));

        userService.register(user);
    }

    public static void login() {
        userService.login(readConsole("username: "), readConsole("password: "));
    }
}
