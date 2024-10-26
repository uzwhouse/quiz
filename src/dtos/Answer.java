package dtos;

public record Answer(String answer, Boolean isCorrect) {
    @Override
    public String answer() {
        return answer;
    }

    @Override
    public Boolean isCorrect() {
        return isCorrect;
    }

    @Override
    public String toString() {
        return "Answer[answer='%s', isCorrect='%s']"
                .formatted(answer, isCorrect);
    }

}
