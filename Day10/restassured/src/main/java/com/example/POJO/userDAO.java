package com.example.POJO;

import java.sql.*;

import com.example.DBConfig;

public class userDAO {

    // CREATE
    public void createUser(String name, String email) {
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
        try (Connection conn = DBConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.executeUpdate();
            System.out.println("User inserted successfully.");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // READ
    public void readUsers() {
        String sql = "SELECT * FROM users";
        try (Connection conn = DBConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | " + rs.getString("email"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // UPDATE
    public void updateUserEmail(int id, String newEmail) {
        String sql = "UPDATE users SET email = ? WHERE id = ?";
        try (Connection conn = DBConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newEmail);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            System.out.println("User updated.");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // DELETE
    public void deleteUser(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection conn = DBConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("User deleted.");
        } catch (SQLException e) { e.printStackTrace(); }
    }
}