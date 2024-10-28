package staticUtils;

import static staticUtils.DefaultSource.readConsole;
import static staticUtils.DefaultSource.userService;

public class AdminMethods {
    public static void update() {
        showUsers();
        userService.update(readConsole("Choice username: "));
    }

    public static void delete() {
        showUsers();
        userService.delete(readConsole("Deleted username: "));
    }

    public static void showUsers() {
        userService.getAll();
    }
}
