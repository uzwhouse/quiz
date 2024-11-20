package models;

import java.io.Serializable;

public class Result implements Serializable {
    private Question question;
    private Answer answer;

    public Result() {
    }

    public Result(Question question, Answer answer) {
        this.question = question;
        this.answer = answer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Question '%s', YourAnswer '%s' is '%s'%n".formatted(question.getQuestion(), answer.getAnswer(), answer.getIsCorrect());
    }
}
