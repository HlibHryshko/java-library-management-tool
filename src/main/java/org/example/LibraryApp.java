package org.example;

import org.example.daos.BookDAO;
import org.example.daos.IssueBookDAO;
import org.example.daos.UserDAO;

import java.util.Scanner;

public class LibraryApp {
    private static final UserDAO userDAO = new UserDAO();
    private static final BookDAO bookDAO = new BookDAO();
    private static final IssueBookDAO issueBookDAO = new IssueBookDAO();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add User");
            System.out.println("2. Add Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter user name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter user email: ");
                    String email = scanner.nextLine();
                    userDAO.addUser(name, email);
                    break;

                case 2:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    bookDAO.addBook(title, author);
                    break;

                case 3:
                    System.out.print("Enter user ID: ");
                    int userId = scanner.nextInt();
                    System.out.print("Enter book ID: ");
                    int bookId = scanner.nextInt();
                    issueBookDAO.issueBook(userId, bookId);
                    break;

                case 4:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Try again!");
            }
        }
    }
}