package dtos;

public record Result(String question, Answer answer) {
    @Override
    public String toString() {
        return "'%s' '%s'%n".formatted(question, answer.isCorrect());
    }
}
