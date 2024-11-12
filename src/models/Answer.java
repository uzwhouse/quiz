package models;

import java.io.Serializable;

public class Answer implements Serializable {
    private String answer;
    private boolean isCorrect;

    public Answer() {
    }

    public Answer(String answer, Boolean isCorrect) {
        this.answer = answer;
        this.isCorrect = isCorrect;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(boolean correct) {
        isCorrect = correct;
    }

    @Override
    public String toString() {
        return "answer='%s', isCorrect='%s'%n".formatted(answer, isCorrect);
    }

}
