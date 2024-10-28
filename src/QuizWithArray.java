import java.util.Objects;

import static roles.Role.ADMIN;
import static roles.Role.TEACHER;
import static staticUtils.AdminMethods.*;
import static staticUtils.DefaultSource.*;
import static staticUtils.LoginMethods.*;
import static staticUtils.TeacherMethods.*;


public class QuizWithArray {
    public static void main(String[] args) {
        createStaticUsers();
        createStaticQuestions();
        run();
    }

    private static void run() {
        if (Objects.isNull(userService.session())) {
            System.out.println("LOGIN    -> 1");
            System.out.println("REGISTER -> 2");
            System.out.println("QUIT     -> q");
            switch (readConsole("? : ")) {
                case "1" -> login();
                case "2" -> register();
                case "q" -> System.exit(0);
                default -> System.out.println("Wrong choice");
            }
        } else {
            if (Objects.nonNull(userService.session()) && userService.session().getRole().equals(ADMIN)) {
                System.out.println("USER CREATE -> 1");
                System.out.println("USER DELETE -> 2");
                System.out.println("USER UPDATE -> 3");
                System.out.println("USERS LIST  -> 4");
                System.out.println("LOGOUT      -> e");
                switch (readConsole("? : ")) {
                    case "1" -> register();
                    case "2" -> delete();
                    case "3" -> update();
                    case "4" -> showUsers();
                    case "e" -> logout();
                    default -> System.out.println("Wrong choice");
                }
            } else if (Objects.nonNull(userService.session()) && userService.session().getRole().equals(TEACHER)) {
                System.out.println("CREATE QUIZ -> 1");
                System.out.println("DELETE QUIZ -> 2");
                System.out.println("UPDATE QUIZ -> 3");
                System.out.println("LIST   QUIZ -> 4");
                System.out.println("LOGOUT      -> e");
                switch (readConsole("? : ")) {
                    case "1" -> createQuestion();
                    case "2" -> deleteQuestion();
                    case "3" -> updateQuestion();
                    case "4" -> listQuestion();
                    case "e" -> logout();
                    default -> System.out.println("Wrong choice");
                }
            } else {
                System.out.println("START  -> 1");
                System.out.println("LOGOUT -> e");
                switch (readConsole("?: ")) {
                    case "1" -> start();
                    case "e" -> logout();
                    default -> System.out.println("Wrong choice");
                }
            }
        }
        System.out.println();
        run();
    }

    private static void start() {
        userService.quiz();
    }

    private static void showSession() {
        System.out.println(userService.session());
    }

}
