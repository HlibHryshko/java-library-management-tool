package org.example.daos;

import org.example.connectors.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDAO {
    public void addUser(String name, String email) {
        String sql = "insert into users (name, email) values (?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.executeUpdate();
            System.out.println("user added successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
