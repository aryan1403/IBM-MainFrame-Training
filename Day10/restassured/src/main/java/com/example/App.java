package com.example;

import com.example.POJO.userDAO;


public class App 
{
    public static void main( String[] args )
    {
        userDAO userOps = new userDAO();

        userOps.createUser("John Doe", "john@example.com");
        System.out.println("Current Users:");
        userOps.readUsers();

        userOps.updateUserEmail(1, "newjohn@example.com");
        userOps.readUsers();
    }
}
