package models;

import dtos.Answer;

import java.util.LinkedList;

public class Question extends BaseGeneric {
    private String question;
    private LinkedList<Answer> answers;

    public Question() {
    }

    public Question(String question, LinkedList<Answer> answers) {
        this.question = question;
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public LinkedList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(LinkedList<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Question{id='%s',%n question='%s',%n'%s'}"
                .formatted(id, question, answers);
    }

}
