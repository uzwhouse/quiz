package models;

import java.io.Serializable;

public class Result implements Serializable {
    private String question;
    private Answer answer;

    public Result() {
    }

    public Result(String question, Answer answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
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
        return "Question '%s', YourAnswer '%s' is '%s'%n".formatted(question, answer.getAnswer(), answer.getIsCorrect());
    }
}
