package serviceImplements;

import models.Answer;
import models.Question;
import services.QuestionService;

import static staticUtils.DefaultSource.readConsole;

public class QuestionServiceImpl implements QuestionService {
    private Question[] questionList = new Question[10];
    private int questionCount = 0;

    @Override
    public int getCount() {
        return questionCount;
    }

    @Override
    public Question[] getQuestions() {
        return questionList;
    }

    @Override
    public void create(Question question) {
        if (questionCount < questionList.length) {
            createByObject(question);
        } else {
            System.out.println("QuestionList is full");
        }
    }

    @Override
    public void createByObject(Question question) {
        questionList[questionCount++] = question;
    }

    @Override
    public void delete(String questionId) {
        int index = getIndex(questionId);
        if (index < 0) {
            System.out.println("Question not found");
        } else {
            for (int i = index; i < questionCount; i++) {
                questionList[i] = questionList[i + 1];
            }
            questionCount--;
        }
    }

    @Override
    public void update(String questionId) {
        int index = getIndex(questionId);
        if (index < 0) System.out.println("Question not found");
        else {
            questionList[index].setQuestionText(readConsole("QuestionText: "));
            questionList[index].setAnswers(new Answer[]{
                    new Answer(readConsole("1. "), Boolean.parseBoolean(readConsole("true or false: "))),
                    new Answer(readConsole("2. "), Boolean.parseBoolean(readConsole("true or false: "))),
                    new Answer(readConsole("3. "), Boolean.parseBoolean(readConsole("true or false: "))),
                    new Answer(readConsole("4. "), Boolean.parseBoolean(readConsole("true or false: ")))
            });
        }
    }

    @Override
    public void getAll() {
        for (int i = 0; i < questionCount; i++) {
            System.out.println(i + 1 + "." + questionList[i]);
        }
    }

    @Override
    public Question getQuestionById(String questionId) {
        Question question = new Question();
        for (int i = 0; i < questionCount; i++) {
            if (questionList[i].getQuestionId().equals(questionId)) {
                question = questionList[i];
                break;
            }
        }
        return question;
    }

    @Override
    public int getIndex(String questionId) {
        int index = -1;
        for (int i = 0; i < questionCount; i++) {
            if (questionList[i].getQuestionId().equals(questionId)) {
                index = i;
                break;
            }
        }
        return index;
    }

}
