package utils;

import serviceImpl.QuestionServiceImpl;
import serviceImpl.UserServiceImpl;
import services.QuestionService;
import services.UserService;

import java.util.Scanner;

public class Utils {

    public static final String RESET = "\u001b[0m";
    public static final String BLACK = "\u001b[30m";
    public static final String RED = "\u001b[31m";
    public static final String GREEN = "\u001b[32m";
    public static final String YELLOW = "\u001b[33m";
    public static final String BLUE = "\u001b[34m";
    public static final String PURPLE = "\u001b[35m";
    public static final String CYAN = "\u001b[36m";
    public static final String WHITE = "\u001b[37m";

    public static Scanner scanner = new Scanner(System.in);

    public static UserService userService = new UserServiceImpl();
    public static QuestionService questionService = new QuestionServiceImpl();

    public static String readConsole(String hint) {
        System.out.print(hint);
        return scanner.nextLine();
    }


}
