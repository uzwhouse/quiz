package serviceImpl.user;

import models.Answer;
import models.Question;
import models.Result;
import models.User;
import services.UserService;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.logging.Logger;

import static roles.UserRole.*;
import static serviceImpl.question.QuestionServiceImpl.getTrueAnswer;
import static serviceImpl.user.UserFileOperation.*;
import static utils.Utils.*;

public class UserServiceImpl extends LoginService implements UserService {
    public static Logger loggerForUser = Logger.getLogger("QuizUserLogger");


    /**
     * User -> unique for username
     *
     * @override clone
     * @override hashCode
     */

    @Override
    public User create(Object object) {
        return registerUser((User) object);
    }

    @Override
    public User read(String username) {
        User user = findByUsername(username);
        if (Objects.nonNull(user)) {
            System.out.println(CYAN + user + RESET);
            System.out.println();
            return user;
        }
        return notFound(username);
    }

    @Override
    public User update(String username) {
        LinkedHashSet<User> localUsers = readAllUsersFromFile();
        User user = findByUsername(username);
        if (Objects.nonNull(user)) {
            for (User u : localUsers) {
                if (u.getUsername().equals(username)) {
                    u.setUsername(readConsole("username : ").toUpperCase());
                    u.setPassword(readConsole("password : "));
                    u.setUserRole(getUserRole(readConsole("User Role : ")));
                }
            }

            System.out.printf(CYAN + "'%s' user successfully updated\n\n" + RESET, user);
            loggerForUser.config("'%s' user successfully updated".formatted(user.getUsername()));
            writeUsersListToFile(localUsers);
            return user;
        }
        return notFound(username);
    }

    @Override
    public void updateForTeacher(String username) {
        LinkedHashSet<User> localUsers = readAllUsersFromFile();
        int grade = Integer.parseInt(readConsole("Enter grade number: "));

        for (User u : localUsers) {
            if (u.getUsername().equalsIgnoreCase(username)) {
                LinkedList<Result> results = u.getResults();
                for (int i = 0; i < grade; i++) {
                    Question question = results.get(i).getQuestion();
                    Answer trueAnswer = getTrueAnswer(question);
                    results.get(i).setAnswer(trueAnswer);
                }
                Collections.shuffle(results);
            }
        }
        writeUsersListToFile(localUsers);
        readAllUsersFromFile().forEach(System.out::println);
    }

    @Override
    public User delete(String username) {
        LinkedHashSet<User> localUsers = readAllUsersFromFile();
        User user = findByUsername(username);
        if (Objects.nonNull(user)) {
            localUsers.remove(user);
            writeUsersListToFile(localUsers);
            System.out.printf(RED + "'%s' '%s' User successfully deleted\n\n" + RESET,
                    user.getUsername(), user.getPassword());
            loggerForUser.config("'%s' user successfully deleted".formatted(user.getUsername()));
            return user;
        }
        return notFound(username);
    }

    @Override
    public LinkedHashSet<User> readAll() {
        return readAllUsersFromFile();
    }

    @Override
    public void startQuiz() {
        loggerForUser.config("'%s' user Starting Quiz".formatted(session.getUsername()));
        StartQuiz startQuiz = new StartQuiz();
        LinkedHashSet<User> localUsers = readAllUsersFromFile();
        for (User u : localUsers) {
            if (u.getUsername().equals(session.getUsername())) {
                u.setResults(startQuiz.quizStart());
                System.out.printf(GREEN + "'%s's result\n\n" + RESET, session.getUsername());
                System.out.println(CYAN + u.getResults() + RESET);
            }
        }
        loggerForUser.config("'%s' user finished quiz".formatted(session.getUsername()));
        writeUsersListToFile(localUsers);
        logout();
    }

    @Override
    public User login(String username, String password) {
        return loginUser(username, password);
    }

    @Override
    public User register(String username, String password) {
        return registerUser(new User(username, password));
    }

    @Override
    public void logout() {
        System.out.printf(GREEN + "'%s' '%s' successfully logged out\n\n" + RESET, session.getUsername(), session.getUserRole());
        loggerForUser.config("'%s' '%s' successfully logged out".formatted(session.getUsername(), session.getUserRole()));
        session = null;
    }

    @Override
    public User getSessionUser() {
        return sessionUser();
    }

    static {
        writeUserToFile(new User("aa", "a", ADMIN));
        appendUserToFile(new User("tt", "t", TEACHER));
        appendUserToFile(new User("ss", "s", STUDENT));
    }

}
