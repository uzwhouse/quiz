package services;

import models.Question;

import java.util.LinkedList;

public interface QuestionService extends CRUDService {

    @Override
    LinkedList<Question> readAll();
}
