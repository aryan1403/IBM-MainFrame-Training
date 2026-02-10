package com.mycompany.app;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
    Login login = new Login();


    // Example of a simple test method using @Test annotation
    @Test
    public void testLogin() {
        String expected = "Welcome, user!";
        String actual = login.login("user", "password");

        // Assert the result of the login method
        Assert.assertEquals(actual, expected, "Login failed!");
    }

    // Simulated login method for demonstration
    
}