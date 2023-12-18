package com.company.Query;

import com.company.Connection.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Query6 { //обновление имя автора по id
    public static void main(String[] args) {
        Statement stmt = null;
        try{

            JDBC.connect();

            stmt = JDBC.connection.createStatement();

            Scanner sc = new Scanner(System.in);
            System.out.print("Input author id: ");
            int aId = 0;
            while(true) {
                try {
                    aId = sc.nextInt();
                    break;
                }
                catch (Exception e)
                {
                    System.err.println("You should print the integer number!");
                    sc.next();
                }
            }

            String query3_ShowAuthors = "SELECT * FROM authors";
            String query3_ChangeAuthor = "UPDATE authors SET firstName = 'Noname' WHERE authorId=" + aId;

            System.out.println("Show all authors");

            ResultSet rs = stmt.executeQuery(query3_ShowAuthors);
            while (rs.next()) {
                int id = rs.getInt("authorID");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                System.out.println(id + "\t" + firstName + "\t" + lastName);
            }

            stmt.executeUpdate(query3_ChangeAuthor);
            System.out.println("\nChanges have been saved!\n");
            rs = stmt.executeQuery(query3_ShowAuthors);
            while (rs.next()) {
                int id = rs.getInt("authorID");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
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
