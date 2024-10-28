package serviceImpl;

import dtos.Answer;
import models.Question;
import services.QuestionService;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static utils.Utils.*;

public class QuestionServiceImpl implements QuestionService {
    private LinkedList<Question> questions = new LinkedList<>();

    @Override
    public Question create(Object object) {
        Question question = (Question) object;
        questions.add(question);
        System.out.printf(GREEN + "'%s' question successfully creating\n\n" + RESET, question);
        return question;
    }

    @Override
    public Question read(String id) {
        Question question = findByStr(id);
        if (Objects.nonNull(question)) {
            System.out.println(CYAN + question + RESET);
            System.out.println();
            return question;
        }
        return notFound(id);
    }

    @Override
    public Question update(String id) {
        Question question = findByStr(id);
        if (Objects.nonNull(question)) {
            question.setQuestion(readConsole("QuestionText: "));
            question.setAnswers(new LinkedList<>(List.of(
                    new Answer(readConsole("a. "), Boolean.parseBoolean(readConsole("true or false: "))),
                    new Answer(readConsole("b. "), Boolean.parseBoolean(readConsole("true or false: "))),
                    new Answer(readConsole("d. "), Boolean.parseBoolean(readConsole("true or false: "))),
                    new Answer(readConsole("e. "), Boolean.parseBoolean(readConsole("true or false: ")))
            )));
            System.out.println(CYAN + "Question successfully updated\n" + RESET);
            return question;
        }
        return notFound(id);
    }

    @Override
    public Question delete(String id) {
        Question question = findByStr(id);
        if (Objects.nonNull(question)) {
            System.out.println(CYAN + "Question successfully deleted\n" + RESET);
            questions.remove(question);
            return question;
        }
        return notFound(id);
    }

    @Override
    public LinkedList<Question> readAll() {
        return questions;
    }

    @Override
    public Question findByStr(String id) {
        for (Question question : questions) {
            if (question.getId().equals(id)) {
                return question;
            }
        }
        return null;
    }

    @Override
    public Question notFound(String id) {
        System.out.printf(RED + "Question with id '%s' not found\n\n" + RESET, id);
        return null;
    }

    @Override
    public void createStatic() {
        questions.add(new Question("1+1 = ?",
                new LinkedList<>(List.of(
                        new Answer("3", false),
                        new Answer("5", false),
                        new Answer("2", true),
                        new Answer("9", false)
                ))
        ));

        questions.add(new Question("1+2 = ?",
                new LinkedList<>(List.of(
                        new Answer("3", true),
                        new Answer("5", false),
                        new Answer("4", false),
                        new Answer("9", false)
                ))
        ));

        questions.add(new Question("1+3 = ?",
                new LinkedList<>(List.of(
                        new Answer("3", false),
                        new Answer("5", false),
                        new Answer("4", true),
                        new Answer("9", false)
                ))
        ));

        questions.add(new Question("1+4 = ?",
                new LinkedList<>(List.of(
                        new Answer("3", false),
                        new Answer("5", true),
                        new Answer("4", false),
                        new Answer("9", false)
                ))
        ));

        questions.add(new Question("1+5 = ?",
                new LinkedList<>(List.of(
                        new Answer("3", false),
                        new Answer("5", false),
                        new Answer("4", false),
                        new Answer("6", true)
                ))
        ));
    }

}
