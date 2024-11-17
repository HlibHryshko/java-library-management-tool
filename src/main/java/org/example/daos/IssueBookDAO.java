package org.example.daos;

import org.example.connectors.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IssueBookDAO {
    public void issueBook(int userId, int bookId) {
        String sql = "insert into IssuedBooks (user_id, book_id, issue_date) values (?, ?, ?)";
        String updateBook = "update books set available = false where id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement issueStatement = connection.prepareStatement(sql);
             PreparedStatement updateStatement = connection.prepareStatement(updateBook)) {

            issueStatement.setInt(1, userId);
            issueStatement.setInt(2, bookId);
            issueStatement.setDate(3, new java.sql.Date(System.currentTimeMillis()));
            issueStatement.executeUpdate();

            updateStatement.setInt(1, bookId);
            updateStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
