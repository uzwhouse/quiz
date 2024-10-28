package models;

import roles.Role;

import java.util.UUID;

public class User extends Generic {
    private String username;
    private String password;
    private Role role = Role.STUDENT;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.id = String.valueOf(UUID.randomUUID());
    }

    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.id = String.valueOf(UUID.randomUUID());
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
