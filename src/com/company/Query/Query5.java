package com.company.Query;

import com.company.Connection.JDBC;

import java.sql.SQLException;
import java.sql.Statement;

public class Query5 {

    public static void main(String[] args) { //добавление нового автора
        Statement stmt = null;
        try {
            JDBC.connect();
            stmt = JDBC.connection.createStatement();
            String authorName = "Nikita";
            String authorLastName = "Peskov";
            String query5NewAuthor = "INSERT INTO Authors (firstName, lastName)"+ "VALUES('" +  authorName+ "','" + authorLastName + "')";
            try {
                stmt.executeUpdate(query5NewAuthor);
                System.out.println("New author has been added!");
            } catch (SQLException e) {
                System.out.println("Execute Update Failed!");
                e.printStackTrace();
                return;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
