package com.company.Query;

import com.company.Connection.JDBC;
import com.company.TestOfTables.InsertTestData;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query2 { // выборка по авторам, осортировав их по фамилии и имени

    public static void main(String[] args) {
        Statement stmt = null;
        try{

            JDBC.connect();

            stmt = JDBC.connection.createStatement();

            String query2Author = "SELECT * FROM authors ORDER BY firstName, lastName";

            System.out.println("Show all authors");

            ResultSet rs1 = stmt.executeQuery(query2Author);

            while (rs1.next()) {
                int id = rs1.getInt("authorID");
                String firstName = rs1.getString("firstName");
                String lastName = rs1.getString("lastName");
                System.out.println(id + "\t" + firstName + "\t" + lastName);
            }

        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } finally {
            //finally block used to close resources
            JDBC.close();
        }
    }
}
