import java.util.Objects;

import static pages.AdminPage.adminPage;
import static pages.LoginPage.loginPage;
import static pages.StudentPage.studentPage;
import static pages.TeacherPage.teacherPage;
import static roles.UserRole.ADMIN;
import static roles.UserRole.TEACHER;
import static utils.Utils.userService;

public class QuizWithList {

    public static void main(String[] args) {
        userService.creatStaticUsers();
        runQuiz();
    }

    private static void runQuiz() {
        if (Objects.isNull(userService.getSessionUser()))
            loginPage();
        else {
            if (Objects.equals(userService.getSessionUser().getUserRole(), ADMIN))
                adminPage();
            else if (Objects.equals(userService.getSessionUser().getUserRole(), TEACHER))
                teacherPage();
            else studentPage();
        }
        runQuiz();
    }

}