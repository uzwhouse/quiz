package pages;

import dtos.Answer;
import models.Question;

import java.util.LinkedList;
import java.util.List;

import static pages.StudentPage.logout;
import static utils.Utils.*;

public class TeacherPage {

    public static void teacherPage() {
        showTeacherPage();
        switch (readConsole(BLUE + "Choice: " + RESET)) {
            case "1" -> createQuestion();
            case "2" -> readQuestion();
            case "3" -> updateQuestion();
            case "4" -> deleteQuestion();
            case "5" -> readAllQuestion();
            case "e" -> logout();
            default -> System.out.println(RED + "Wrong choice !!!\n" + RESET);
        }
    }

    private static void readAllQuestion() {
        questionService.readAll().forEach(System.out::println);
        System.out.println();
    }

    private static void deleteQuestion() {
        readAllQuestion();
        questionService.delete(readConsole("Question id: "));
    }

    private static void updateQuestion() {
        readAllQuestion();
        questionService.update(readConsole("Question id: "));
    }

    private static void readQuestion() {
        questionService.read(readConsole("Question id: "));
    }

    private static void createQuestion() {
        questionService.create(new Question(readConsole("Question text: "), new LinkedList<>(List.of(
                new Answer(readConsole("a. "), Boolean.parseBoolean(readConsole("true or false: "))),
                new Answer(readConsole("b. "), Boolean.parseBoolean(readConsole("true or false: "))),
                new Answer(readConsole("d. "), Boolean.parseBoolean(readConsole("true or false: "))),
                new Answer(readConsole("e. "), Boolean.parseBoolean(readConsole("true or false: ")))
        ))
        ));
    }

    public static void showTeacherPage() {
        System.out.println("1 -> QUESTION CREATE");
        System.out.println("2 -> QUESTION READ");
        System.out.println("3 -> QUESTION UPDATE");
        System.out.println("4 -> QUESTION DELETE");
        System.out.println("5 -> QUESTIONS LIST");
        System.out.println("e -> LOGOUT");
    }
}
