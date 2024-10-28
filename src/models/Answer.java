package models;

import interfaces.Quiz;

public record Answer(String answer, boolean isCorrect) implements Quiz {
    @Override
    public void show() {

    }

    @Override
    public String answer() {
        return answer;
    }

    @Override
    public boolean isCorrect() {
        return isCorrect;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answer='" + answer + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }
}
