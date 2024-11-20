package models;

import roles.UserRole;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Objects;

public class User extends BaseGeneric implements Serializable {
    private String username;
    private String password;
    private UserRole userRole = UserRole.STUDENT;
    private LinkedList<Result> results;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, UserRole userRole) {
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "User={id='%s',%n username='%s', password='%s', userRole='%s%n '%s''}"
                .formatted(id, username, password, userRole.toString(), results);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof User user)) return false;
        return username.equals(user.username);

/*        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return this.username.equalsIgnoreCase(user.username);*/

/*        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof User u)) return false;

        return u.username.equals(this.username);*/
    }

    public LinkedList<Result> getResults() {
        return results;
    }

    public void setResults(LinkedList<Result> results) {
        this.results = results;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}


