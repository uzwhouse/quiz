package pages;

public class TeacherPage {

    public static void teacherPage(){
        showTeacherPage();
    }

    public static void showTeacherPage(){
        System.out.println("1 -> CREATE QUIZ");
        System.out.println("2 -> DELETE QUIZ");
        System.out.println("3 -> UPDATE QUIZ");
        System.out.println("4 -> LIST QUIZ");
        System.out.println("e -> LOGOUT");
    }
}
