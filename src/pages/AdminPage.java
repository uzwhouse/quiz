package pages;

import models.User;

import static utils.Utils.*;

public class AdminPage {
    public static void adminPage() {
        showAdminPage();
        switch (readConsole(BLUE + "Choice: " + RESET)) {
            case "1" -> create();
            case "2" -> read();
            case "3" -> update();
            case "4" -> delete();
            case "5" -> readAll();
            case "e" -> logout();
            default -> System.out.println(RED + "Wrong choice !!!\n" + RESET);
        }
    }

    private static void logout() {
        userService.logout();
    }

    private static void readAll() {
        userService.readAll();
    }

    private static void delete() {
        userService.delete(readConsole("Username: "));
    }

    private static void update() {
        userService.update(readConsole("Username: "));
    }

    private static void read() {
        userService.read(readConsole("Username: "));
    }

    private static void create() {
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
