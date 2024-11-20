import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import static pages.AdminPage.adminPage;
import static pages.LoginPage.loginPage;
import static pages.StudentPage.studentPage;
import static pages.TeacherPage.teacherPage;
import static roles.UserRole.ADMIN;
import static roles.UserRole.TEACHER;
import static utils.Utils.userService;

public class QuizWithLog {

    static {
        String sourceLogConf = "java.util.logging.config.file";
        String changedLogConf = QuizWithLog.class.getClassLoader().getResource("logging.properties").getPath();
        System.setProperty(sourceLogConf, changedLogConf);
    }

    public static void main(String[] args) {
//        System.out.println(Level.OFF.intValue());
//        System.out.println(Level.SEVERE.intValue());
//        System.out.println(Level.WARNING.intValue());
//        System.out.println(Level.INFO.intValue());
//        System.out.println(Level.CONFIG.intValue());
//        System.out.println(Level.FINE.intValue());
//        System.out.println(Level.FINER.intValue());
//        System.out.println(Level.FINEST.intValue());
//        System.out.println(Level.ALL.intValue());


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