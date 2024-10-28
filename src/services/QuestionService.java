package services;

import models.Question;

public interface QuestionService {
    void create(Question question);

    void createByObject(Question question);

    void delete(String questionId);

    void update(String questionId);

    void getAll();

    Question getQuestionById(String questionId);

    int getIndex(String questionId);

    int getCount();

    Question[] getQuestions();
}
