package fit;

import java.util.HashMap;
import java.util.Map;

public class UserManagementSource {
    private Map<String, User> users = new HashMap<>(); // HashMap to store users with email as the key

    // Method to add a new user
    public String addUser(String username, String city, String email, String password, String role) {
        if (users.containsKey(email.toLowerCase())) {
            return "User already exists.";
        }
        User newUser = new User(username, city, email.toLowerCase(), password, role);
        users.put(email.toLowerCase(), newUser);
        return "User " + username + " added successfully.";
    }

    // Method to update a user's role
    public String updateUserRole(String email, String newRole) {
        User user = users.get(email.toLowerCase());
        if (user == null) {
            return "User does not exist.";
        }
        user.setRole(newRole);
        return "User " + user.getUsername() + "'s role updated to " + newRole + ".";
    }

    // Method to disable a user's account
    public String disableUser(String email) {
        User user = users.get(email.toLowerCase());
        if (user == null) {
            return "User does not exist.";
        }
        user.setActive(false);
        return "User " + user.getUsername() + "'s account has been disabled.";
    }

    // Method to approve an instructor's registration
    public String approveInstructorRegistration(String email) {
        User user = users.get(email.toLowerCase());
        if (user == null) {
            return "User does not exist.";
        }
        if (!"Instructor".equalsIgnoreCase(user.getRole())) {
            return "User is not an Instructor.";
        }
        user.setActive(true);
        return "Instructor " + user.getUsername() + " has been approved.";
    }

    // Method to check if a user exists
    public boolean doesUserExist(String email) {
        return users.containsKey(email.toLowerCase());
    }

    // Debugging method to print all users
    public void printAllUsers() {
        users.values().forEach(System.out::println);
    }
}
