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
        return "answer='%s', isCorrect='%s'%n".formatted(answer, isCorrect);
    }

}
