package pages;

import static utils.Utils.*;

public class StudentPage {
    public static void studentPage() {
        showStudentPage();
        switch (readConsole(BLUE + "Choice: " + RESET)) {
            case "1" -> start();
            case "e" -> logout();
            default -> System.out.println(RED + "Wrong choice !!!\n" + RESET);
        }
    }

    private static void logout() {
        userService.logout();
    }

    private static void start() {
        userService.startQuiz();
    }

    public static void showStudentPage() {
        System.out.println("1 -> START");
        System.out.println("e -> LOGOUT");
    }
}
