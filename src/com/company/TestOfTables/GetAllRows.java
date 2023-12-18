package com.company.TestOfTables;

import com.company.Connection.JDBC;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

public class GetAllRows {

    public static void main(String[] args) {
        Statement stmt = null;
        try {

            JDBC.connect();
            stmt = JDBC.connection.createStatement();

            String exampleQuery1 = "SELECT * FROM Authors";
            System.out.println("Authors:");
            ResultSet rs1 = stmt.executeQuery(exampleQuery1);
            while (rs1.next()) {
                int id = rs1.getInt("authorID");
                String firstName = rs1.getString("firstName");
                String lastName = rs1.getString("lastName");
                System.out.println(id + "\t" + firstName + "\t" + lastName);
            }


            String exampleQuery2 = "SELECT * FROM Publishers";
            System.out.println("Publishers:");
            ResultSet rs2 = stmt.executeQuery(exampleQuery2);
            while (rs2.next()) {

                int id = rs2.getInt("publisherID");
                String publisherName = rs2.getString("publisherName");
                System.out.println(id + "\t" + publisherName);
            }


            String exampleQuery3 = "SELECT * FROM Titles";
            System.out.println("Titles:");
            ResultSet rs3 = stmt.executeQuery(exampleQuery3);
            while (rs3.next()) {
                String isbn = rs3.getString("isbn");
                String title = rs3.getString("title");
                int editionNumber = rs3.getInt("editionNumber");
                String year = rs3.getString("year");
                int id = rs3.getInt("publisherID");
                BigDecimal price = rs3.getBigDecimal("price");
                System.out.println(id + "\t" + isbn + "\t" + title + "\t" + editionNumber + "\t" + year + "\t" + price);
            }

            String exampleQuery4 = "SELECT * FROM authorISBN";
            System.out.println("authorISBN:");
            ResultSet rs4 = stmt.executeQuery(exampleQuery4);
            while (rs4.next()) {
                int id = rs4.getInt("authorID");
                String isbn = rs4.getString("isbn");
                System.out.println(id + "\t" + isbn);
            }

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } finally {
            // Finally block, used to close resources
            JDBC.close();
        }

    }
}


