package serviceImpl.user;

import models.User;

import java.io.*;
import java.util.LinkedHashSet;

public class UserFileOperation {
    protected static final String USERS_FILE_PATH = "resources/users.txt";

    protected static void writeUserToFile(User user) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(USERS_FILE_PATH))) {
            objectOutputStream.writeObject(user);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage() + "writeUserToFile");
        }
    }

    protected static void writeUsersListToFile(LinkedHashSet<User> users) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(USERS_FILE_PATH))) {
            for (User user : users) {
                objectOutputStream.writeObject(user);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage() + "writeUserToFile");
        }
    }

    protected static void appendUserToFile(User user) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(USERS_FILE_PATH, true)) {
            @Override
            protected void writeStreamHeader() throws IOException {

            }
        }) {
            objectOutputStream.writeObject(user);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage() + "appendUserToFile");
        }
    }

    protected static LinkedHashSet<User> readAllUsersFromFile() {
        LinkedHashSet<User> localUsers = new LinkedHashSet<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(USERS_FILE_PATH))) {
            while (true) {
                try {
                    localUsers.add((User) objectInputStream.readObject());
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage() + "readAllUsersFromFile");
        }
        return localUsers;
    }

}
