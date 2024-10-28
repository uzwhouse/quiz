package staticUtils;

import base.Base;
import models.Answer;
import models.Question;
import models.User;
import serviceImplements.QuestionServiceImpl;
import serviceImplements.UserServiceImpl;
import services.QuestionService;
import services.UserService;

import java.util.Scanner;

import static roles.Role.*;

public class DefaultSource {
    public static Scanner scanner = new Scanner(System.in);
    public static UserService userService = new UserServiceImpl();
    public static Base userService1 = new UserServiceImpl();
    public static QuestionService questionService = new QuestionServiceImpl();

    public static void createStaticUsers() {
        User admin = new User("a", "a", ADMIN);
        User student = new User("s", "s", STUDENT);
        User teacher = new User("t", "t", TEACHER);
        userService.create(admin);
        userService.create(student);
        userService.create(teacher);
    }

    public static void createStaticQuestions() {
        Question question1 = new Question("1+1 = ?", new Answer[]{
                new Answer("3", false),
                new Answer("5", false),
                new Answer("2", true),
                new Answer("9", false)
        });
        Question question2 = new Question("1+2 = ?", new Answer[]{
                new Answer("3", true),
                new Answer("5", false),
                new Answer("4", false),
                new Answer("9", false)
        });
        Question question3 = new Question("1+3 = ?", new Answer[]{
                new Answer("3", false),
                new Answer("5", false),
                new Answer("4", true),
                new Answer("9", false)
        });
        Question question4 = new Question("1+4 = ?", new Answer[]{
                new Answer("3", false),
                new Answer("5", true),
                new Answer("4", false),
                new Answer("9", false)
        });
        Question question5 = new Question("1+5 = ?", new Answer[]{
                new Answer("3", false),
                new Answer("5", false),
                new Answer("4", false),
                new Answer("6", true)
        });
        questionService.createByObject(question1);
        questionService.createByObject(question2);
        questionService.createByObject(question3);
        questionService.createByObject(question4);
        questionService.createByObject(question5);
    }

    public static String readConsole(String hint) {
        System.out.print(hint);
        return scanner.nextLine();
    }

}
