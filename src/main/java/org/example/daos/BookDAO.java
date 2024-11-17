package org.example.daos;

import org.example.connectors.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BookDAO {
    public void addBook(String title, String author) {
        String sql = "insert into books (title, author) values(?,?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, author);
            preparedStatement.executeUpdate();
            System.out.println("Book added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
