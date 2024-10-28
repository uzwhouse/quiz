package models;

public class UserResult {
    private String questionText;
    private String answer;
    private boolean isCorrect;

    public UserResult() {
    }

    public UserResult(String questionText, String answer, boolean isCorrect) {
        this.questionText = questionText;
        this.answer = answer;
        this.isCorrect = isCorrect;
    }

    @Override
    public String toString() {
        return "UserResult{" +
                "questionText='" + questionText + '\'' +
                ", answer='" + answer + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
