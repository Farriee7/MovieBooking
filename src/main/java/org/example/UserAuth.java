package org.example;

import java.sql.*;

public class UserAuth {
    private final DatabaseOperation db = new DatabaseOperation();

    public boolean signup(String username, String password, String name, String phone, String address) {
        String sql = "INSERT INTO users (Username, Password, Name, Phone, Address) VALUES (?, ?, ?, ?, ?)";
        Object[] values = {username, password, name, phone, address};
        int rows = db.executeUpdate(sql, values);
        return rows > 0;
    }

    public boolean login(String username, String password) {
        String sql = "SELECT * FROM users WHERE Username = ? AND Password = ?";
        try (Connection conn = db.connectToDatabase();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next(); // If there's a matching row, login is successful
        } catch (SQLException e) {
            System.err.println("Login failed: " + e.getMessage());
            return false;
        }
    }
}
