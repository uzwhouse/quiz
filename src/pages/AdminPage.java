package pages;

import models.User;

import static pages.StudentPage.logout;
import static utils.Utils.*;

public class AdminPage {
    public static void adminPage() {
        showAdminPage();
        switch (readConsole(BLUE + "Choice: " + RESET)) {
            case "1" -> createUser();
            case "2" -> readUser();
            case "3" -> updateUser();
            case "4" -> deleteUser();
            case "5" -> readAllUser();
            case "e" -> logout();
            default -> System.out.println(RED + "Wrong choice !!!\n" + RESET);
        }
    }

    private static void readAllUser() {
        userService.readAll().forEach(System.out::println);
        System.out.println();
    }

    private static void deleteUser() {
        userService.delete(readConsole("Username: "));
    }

    private static void updateUser() {
        userService.update(readConsole("Username: "));
    }

    private static void readUser() {
        userService.read(readConsole("Username: "));
    }

    private static void createUser() {
        userService.create(new User(
                readConsole("Username: "),
                readConsole("Password: ")));
    }

    public static void showAdminPage() {
        System.out.println("1 -> USER CREATE");
        System.out.println("2 -> USER READ");
        System.out.println("3 -> USER UPDATE");
        System.out.println("4 -> USER DELETE");
        System.out.println("5 -> USERS LIST");
        System.out.println("e -> LOGOUT");
    }

}
