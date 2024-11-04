package serviceImpl.user;

import dtos.Answer;
import dtos.Result;
import models.Question;

import java.util.LinkedList;

import static utils.Utils.*;

public class StartQuiz extends LoginService {

    protected static LinkedList<Result> startQuiz() {
        LinkedList<Result> sessionUserResults = new LinkedList<>();
        System.out.println(GREEN + "################# Starting Quiz #################" + RESET);
        for (Question question : questionService.readAll()) {
            System.out.println(question.getQuestion());
            LinkedList<Answer> answers = question.getAnswers();
            System.out.printf("a.%s | b.%s | d.%s | e.%s%n",
                    answers.get(0).answer(), answers.get(1).answer(),
                    answers.get(2).answer(), answers.get(3).answer());
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
