package staticUtils;

import models.Answer;
import models.Question;

import static staticUtils.DefaultSource.questionService;
import static staticUtils.DefaultSource.readConsole;

public class TeacherMethods {
    public static void listQuestion() {
        questionService.getAll();
    }

    public static void updateQuestion() {
        listQuestion();
        questionService.update(readConsole("Updated id: "));
    }

    public static void deleteQuestion() {
        listQuestion();
        questionService.delete(readConsole("Deleted Id: "));
    }

    public static void createQuestion() {
        Question question = new Question(readConsole("QuestionText-> "), new Answer[]{
                new Answer(readConsole("1. "), Boolean.parseBoolean(readConsole("true or false: "))),
                new Answer(readConsole("2. "), Boolean.parseBoolean(readConsole("true or false: "))),
                new Answer(readConsole("3. "), Boolean.parseBoolean(readConsole("true or false: "))),
                new Answer(readConsole("4. "), Boolean.parseBoolean(readConsole("true or false: ")))
        });
        questionService.create(question);
    }

}
