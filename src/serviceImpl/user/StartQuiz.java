package serviceImpl.user;

import models.Answer;
import models.Question;
import models.Result;

import java.util.LinkedHashSet;
import java.util.LinkedList;

import static utils.Utils.*;

public class StartQuiz extends LoginService {

    @SuppressWarnings("unchecked")
    protected LinkedHashSet<Result> quizStart() {
        LinkedHashSet<Result> sessionUserResults = new LinkedHashSet<>();
        System.out.println(GREEN + "################# Starting Quiz #################" + RESET);
        for (Question question : (LinkedList<Question>) questionService.readAll()) {
            System.out.println(question.getQuestion());
            LinkedList<Answer> answers = question.getAnswers();
            System.out.printf("a.%s | b.%s | d.%s | e.%s%n",
                    answers.get(0).getAnswer(), answers.get(1).getAnswer(),
                    answers.get(2).getAnswer(), answers.get(3).getAnswer());
            Answer answer = switch (readConsole("Choice true answer number : ")) {
                case "a" -> answers.get(0);
                case "b" -> answers.get(1);
                case "d" -> answers.get(2);
                case "e" -> answers.get(3);
                default -> new Answer(null, false);
            };
            sessionUserResults.add(new Result(question.getQuestion(), answer));
        }
        return sessionUserResults;
    }
}
