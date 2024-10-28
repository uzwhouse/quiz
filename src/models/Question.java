package models;

import interfaces.Quiz;

import java.util.Arrays;
import java.util.UUID;

public class Question extends Generic implements Quiz {
    private String questionText;
    private Answer[] answers = new Answer[4];

    public Question() {
    }

    public Question(String questionText, Answer[] answers) {
        this.questionText = questionText;
        this.answers = answers;
        this.id = String.valueOf(UUID.randomUUID());
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public Answer[] getAnswers() {
        return answers;
    }

    public void setAnswers(Answer[] answers) {
        this.answers = answers;
    }

    public String getQuestionId() {
        return id;
    }


    @Override
    public String toString() {
        return "Question{" +
                "questionText='" + questionText + '\'' +
                ", answers=" + Arrays.toString(answers) +
                ", id='" + id + '\'' +
                '}';
    }

    @Override
    public void show() {

    }
}
