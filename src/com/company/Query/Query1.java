package com.company.Query;

import com.company.Connection.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query1 {  // добавление нового publisher
    public static void main(String[] args) {
        Statement stmt = null;
        try {
            JDBC.connect();

            stmt = JDBC.connection.createStatement();

            String publisherName = "Big Patric";
            String query1NewPublisher = "INSERT INTO Publishers (publisherName)" + "VALUES ('" + publisherName + "')";
            try {
                stmt.executeUpdate(query1NewPublisher);
                System.out.println("New publisher has been added!");
            } catch (SQLException e) {
                System.out.println("Execute Update Failed!");
                e.printStackTrace();

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
