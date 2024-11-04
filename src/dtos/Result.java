package dtos;

public record Result(String question, Answer answer) {
    @Override
    public String toString() {
        return "Question '%s', YourAnswer '%s' is '%s'%n".formatted(question, answer.answer(), answer.isCorrect());
    }
}
