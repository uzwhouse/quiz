package serviceImpl.question;

import models.Answer;
import models.Question;
import services.QuestionService;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static serviceImpl.question.QuestionFileOperation.*;
import static utils.Utils.*;

public class QuestionServiceImpl implements QuestionService {

    @Override
    public Question create(Object object) {
        LinkedList<Question> createQuestions = readAllQuestionsFromFile();
        Question question = (Question) object;
        createQuestions.add(question);
        writeQuestionsListToFile(createQuestions);
        System.out.printf(GREEN + "'%s' question successfully creating\n\n" + RESET, question);
        return question;
    }

    @Override
    public Question read(String id) {
        Question question = findById(id);
        if (Objects.nonNull(question)) {
            System.out.println(CYAN + question + RESET);
            System.out.println();
            return question;
        }
        return notFound(id);
    }

    @Override
    public Question update(String id) {
        LinkedList<Question> updateQuestions = readAllQuestionsFromFile();
        Question question = findById(id);
        if (Objects.nonNull(question)) {
            for (Question q : updateQuestions) {
                if (q.getId().equals(id)) {
                    q.setQuestion(readConsole("QuestionText: "));
                    q.setAnswers(new LinkedList<>(List.of(
                            new Answer(readConsole("a. "), Boolean.parseBoolean(readConsole("true or false: "))),
                            new Answer(readConsole("b. "), Boolean.parseBoolean(readConsole("true or false: "))),
                            new Answer(readConsole("d. "), Boolean.parseBoolean(readConsole("true or false: "))),
                            new Answer(readConsole("e. "), Boolean.parseBoolean(readConsole("true or false: ")))
                    )));
                }
            }
            System.out.println(CYAN + "Question successfully updated\n" + RESET);
            writeQuestionsListToFile(updateQuestions);
            return question;
        }
        return notFound(id);
    }

    @Override
    public Question delete(String id) {
        LinkedList<Question> deleteQuestions = readAllQuestionsFromFile();
        Question question = findById(id);
        if (Objects.nonNull(question)) {
            deleteQuestions.remove(question);
            System.out.println(CYAN + "Question successfully deleted\n" + RESET);
            writeQuestionsListToFile(deleteQuestions);
            return question;
        }
        return notFound(id);
    }

    @Override
    public LinkedList<Question> readAll() {
        return readAllQuestionsFromFile();
    }

    public Question findById(String id) {
        LinkedList<Question> findQuestions = readAllQuestionsFromFile();
        for (Question question : findQuestions) {
            if (question.getId().equals(id)) {
                return question;
            }
        }
        return null;
    }

    public Question notFound(String id) {
        System.out.printf(RED + "Question with id '%s' not found\n\n" + RESET, id);
        return null;
    }

    {
        writeQuestionToFile(new Question("1+1 = ?",
                new LinkedList<>(List.of(
                        new Answer("3", false),
                        new Answer("5", false),
                        new Answer("2", true),
                        new Answer("9", false)
                ))
        ));

        appendQuestionToFile(new Question("1+2 = ?",
                new LinkedList<>(List.of(
                        new Answer("3", true),
                        new Answer("5", false),
                        new Answer("4", false),
                        new Answer("9", false)
                ))
        ));

        appendQuestionToFile(new Question("1+3 = ?",
                new LinkedList<>(List.of(
                        new Answer("3", false),
                        new Answer("5", false),
                        new Answer("4", true),
                        new Answer("9", false)
                ))
        ));

        appendQuestionToFile(new Question("1+4 = ?",
                new LinkedList<>(List.of(
                        new Answer("3", false),
                        new Answer("5", true),
                        new Answer("4", false),
                        new Answer("9", false)
                ))
        ));

        appendQuestionToFile(new Question("1+5 = ?",
                new LinkedList<>(List.of(
                        new Answer("3", false),
                        new Answer("5", false),
                        new Answer("4", false),
                        new Answer("6", true)
                ))
        ));
    }

}
