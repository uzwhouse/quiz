package serviceImplements;

import models.Answer;
import models.User;
import models.UserResult;
import services.UserService;

import java.util.Objects;

import static staticUtils.DefaultSource.questionService;
import static staticUtils.DefaultSource.readConsole;

public class UserServiceImpl implements UserService {

    private User[] userList = new User[10];
    private UserResult[] userResults = new UserResult[10];
    private User session;
    private int userCount = 0;

    @Override
    public void create(User user) {
        userList[userCount++] = user;
    }

    @Override
    public void delete(String username) {
        if (Objects.nonNull(getByUsername(username))) {
            int index = getIndex(username);
            for (int i = index; i < userCount; i++) {
                userList[i] = userList[i + 1];
            }
            userCount--;
        } else System.out.println("User not found");
    }

    @Override
    public int getIndex(String username) {
        int index = -1;
        for (int i = 0; i < userCount; i++) {
            if (userList[i].getUsername().equalsIgnoreCase(username)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public User getByUsername(String username) {
        for (User user : userList) {
            if (Objects.nonNull(user) &&
                    user.getUsername().equalsIgnoreCase(username)) return user;
        }
        return null;
    }

    @Override
    public void getAll() {
        for (int i = 0; i < userCount; i++) {
            System.out.println(i + 1 + "." + userList[i]);
        }
    }

    @Override
    public void register(User user) {
        if (userCount < userList.length) {
            if (Objects.nonNull(getByUsername(user.getUsername()))) {
                System.out.println("User already exists");
                return;
            }
            create(user);
        } else System.out.println("DB is full");
    }

    @Override
    public void update(String username) {
        User user = getByUsername(username);
        if (Objects.nonNull(user)) {
            user.setUsername(readConsole("Updated username: "));
            user.setPassword(readConsole("Updated password: "));
        } else
            System.out.printf("|%s| Username not found%n", username);
    }

    @Override
    public void login(String username, String password) {
        User user = getByUsername(username);
        if (Objects.isNull(user) || !user.getPassword().equals(password)) {
            System.out.println("Wrong username or password");
            return;
        }
        session = user;
    }

    @Override
    public void logout() {
        session = null;
    }

    @Override
    public User session() {
        return session;
    }

    @Override
    public void quiz() {
        System.out.println("-------------- START TEST --------------");
        for (int i = 0; i < questionService.getCount(); i++) {
            Answer[] answers = questionService.getQuestions()[i].getAnswers();
            System.out.println(questionService.getQuestions()[i].getQuestionText());
            System.out.printf("1.%s | 2.%s | 3.%s | 4.%s%n",
                    answers[0].answer(), answers[1].answer(), answers[2].answer(), answers[3].answer());
            String choiceAnswer = readConsole("Choice true answer number: ");
            Answer answer = switch (choiceAnswer) {
                case "1" -> answers[0];
                case "2" -> answers[1];
                case "3" -> answers[2];
                case "4" -> answers[3];
                default -> answers[4];
            };
            userResults[i] = new UserResult(
                    questionService.getQuestions()[i].getQuestionText(),
                    answer.answer(),
                    answer.isCorrect()
            );
        }
        for (int i = 0; i < questionService.getCount(); i++) {
            System.out.println(userResults[i]);
        }
    }
}
