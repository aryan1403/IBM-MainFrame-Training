package com.mycompany.app;

public class Login {
    public String login(String username, String password) {
        // This is a simple mock of a login functionality
        if ("user".equals(username) && "password".equals(password)) {
            return "Welcome, user!";
        }
        return "Invalid credentials";
    }
}
