package roles;

public enum UserRole {
    ADMIN, TEACHER, STUDENT;

    public static UserRole getUserRole(String role) {
        for (UserRole userRole : values()) {
            if (userRole.toString().equalsIgnoreCase(role)) {
                return userRole;
            }
        }
        return STUDENT;
    }
}
