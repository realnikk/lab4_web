package com.company.Query;

import com.company.Connection.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query3 { // выборка издателей и изменение имени одного из них
    public static void main(String[] args) {
        Statement stmt = null;
        try{

            JDBC.connect();

            stmt = JDBC.connection.createStatement();

            String query3_ShowPublishers = "SELECT * FROM publishers";

            String query3_ChangePublisher = "UPDATE publishers SET publisherName = \"NEW PUBLISHER\" WHERE publisherId=5";

            System.out.println("Show all publishers");

            ResultSet rs = stmt.executeQuery(query3_ShowPublishers);
            while (rs.next()) {
                int id = rs.getInt("publisherID");
                String name = rs.getString("publisherName");
                System.out.println(id + "\t" + name);
            }

            stmt.executeUpdate(query3_ChangePublisher);
            System.out.println("\nChanges have been saved!\n");
            rs = stmt.executeQuery(query3_ShowPublishers);
            while (rs.next()) {
                int id = rs.getInt("publisherID");
                String name = rs.getString("publisherName");
                System.out.println(id + "\t" + name);
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
