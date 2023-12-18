package com.company.Query;

import com.company.Connection.JDBC;

import java.sql.SQLException;
import java.sql.Statement;

public class Query7 { // добавление publisher, title, authorISBN
    public static void main(String[] args){
        Statement stmt = null;
        try {
            JDBC.connect();

            stmt = JDBC.connection.createStatement();

            String publisherName = "NEW PUBLISHER_22";
            String isbn = "0107444278";
            String title = "Rich dad, poor dad";
            String editionNumber = "66";
            String year = "2000";
            String price = "5.7";
            String firstname = "5.7";
            String lastname = "5.7";
            String query7NewPublisher = "INSERT INTO Publishers (publisherName)" + "VALUES ('" + publisherName + "')";
            String query7NewTitle = "INSERT INTO Titles (isbn, title, editionNumber, year, price, publisherID)" + "VALUES ('" + isbn + "','"+ title + "','" + editionNumber+ "','" + year + "','" + price + "', (SELECT publisherID FROM publishers where publisherName = '" + publisherName + "'))";
            String query7NewAuthorISBN = "INSERT INTO authorISBN (isbn, authorID)" + "VALUES ('" + isbn + "', (SELECT authorID FROM authors where firstName = '" + firstname + "' AND lastName = '" + lastname + "'))";

            try {
                stmt.executeUpdate(query7NewPublisher);
                stmt.executeUpdate(query7NewTitle);
                stmt.executeUpdate(query7NewAuthorISBN);
                System.out.println("New publisher, title, authorISBN have been added!");
            } catch (SQLException e) {
                System.out.println("Execute Update Failed!");
                e.printStackTrace();

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
