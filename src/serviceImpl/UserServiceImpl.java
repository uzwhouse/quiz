package serviceImpl;

import dtos.Answer;
import dtos.Result;
import models.Question;
import models.User;
import roles.UserRole;
import services.UserService;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Objects;

import static roles.UserRole.*;
import static utils.Utils.*;

public class UserServiceImpl implements UserService {

    /**
     * User -> unique for username
     *
     * @override clone
     * @override hashCode
     */
    private LinkedHashSet<User> users = new LinkedHashSet<>();
    private User session;
    private LinkedList<Result> sessionUserResult = new LinkedList<>();

    @Override
    public User login(String username, String password) {
        User user = findByStr(username);
        if (Objects.nonNull(user)) {
            if (username.equals(user.getUsername()) &&
                    password.equals(user.getPassword())) {
                session = user;
                System.out.printf(GREEN + "'%s' '%s' successfully login\n\n" + RESET,
                        session.getUsername(), session.getUserRole());
                return session;
            } else {
                System.out.println(RED + "Wrong username or password\n" + RESET);
                return null;
            }
        }
        return notFound(username);
    }

    @Override
    public User notFound(String username) {
        System.out.printf(RED + "'%s' username not found\n\n" + RESET, username);
        return null;
    }

    @Override
    public User register(String username, String password) {
        return create(new User(username, password));
    }

    @Override
    public User logout() {
        System.out.printf(GREEN + "'%s' '%s' successfully logged out\n\n" + RESET,
                session.getUsername(), session.getUserRole());
        return session = null;
    }

    @Override
    public User create(Object object) {
        User user = (User) object;
        if (Objects.isNull(findByStr(user.getUsername()))) {
            users.add(user);
            System.out.printf(GREEN + "'%s' '%s' successfully creating\n\n" + RESET,
                    user.getUsername(), user.getUserRole());
            return user;
        } else {
            System.out.printf(PURPLE + "'%s' '%s' already exists\n\n" + RESET,
                    user.getUsername(), user.getUserRole());
            return null;
        }

//        return Objects.isNull(user) ? user : null;
    }

    @Override
    public User read(String username) {
        User user = findByStr(username);
        if (Objects.nonNull(user)) {
            System.out.println(CYAN + user + RESET);
            System.out.println();
            return user;
        }
        return notFound(username);
    }

    @Override
    public User update(String username) {
        User user = findByStr(username);
        if (Objects.nonNull(user)) {
            user.setUsername(readConsole("username : "));
            user.setPassword(readConsole("password : "));
            user.setUserRole(UserRole.valueOf(readConsole("User Role : ")));
            System.out.printf(CYAN + "'%s' user successfully updated\n\n" + RESET, user);
            return user;
        }
        return notFound(username);
    }

    @Override
    public User delete(String username) {
        User user = findByStr(username);
        if (Objects.nonNull(user)) {
            System.out.printf(CYAN + "'%s' user successfully deleted\n\n" + RESET, user);
            users.remove(user);
            return user;
        }
        return notFound(username);
    }

    @Override
    public LinkedHashSet<User> readAll() {
        return users;
    }

    @Override
    public void startQuiz() {
        System.out.println(GREEN + "################# Starting Quiz #################" + RESET);
        for (Question question : questionService.readAll()) {
            System.out.println(question.getQuestion());
            LinkedList<Answer> answers = question.getAnswers();
            System.out.printf("a.%s | b.%s | d.%s | e.%s%n",
                    answers.get(0).answer(), answers.get(1).answer(),
                    answers.get(2).answer(), answers.get(3).answer());
            Answer answer = switch (readConsole("Choice true answer number : ")) {
                case "a" -> answers.get(0);
                case "b" -> answers.get(1);
                case "d" -> answers.get(2);
                case "e" -> answers.get(3);
                default -> new Answer(null, false);
            };
            sessionUserResult.add(new Result(question.getQuestion(), answer));
        }
        session.setResults(sessionUserResult);
        System.out.printf(CYAN + "'%s's result%n" + RESET, session.getUsername());
        for (User user : users) {
            System.out.println(user.getResults());
        }
        logout();
    }

    @Override
    public User getSessionUser() {
        return session;
    }

    @Override
    public User findByStr(String username) {
        for (User user : users)
            if (user.getUsername().equalsIgnoreCase(username)) return user;
        return null;
    }

    @Override
    public void createStatic() {
        users.add(new User("a", "a", ADMIN));
        users.add(new User("t", "t", TEACHER));
        users.add(new User("s", "s", STUDENT));
    }

}
