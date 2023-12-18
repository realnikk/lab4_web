package com.company.Query;

import com.company.Connection.JDBC;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Query4 {
    public static void main(String[] args) { //выборка книг одного издателя с введённым id, отсортированная по названию
        Statement stmt = null;
        try{

            JDBC.connect();

            stmt = JDBC.connection.createStatement();

            Scanner sc = new Scanner(System.in);
            System.out.print("Input publisher id: ");
            int publId = 0;
            while(true) {
                try {
                    publId = sc.nextInt();
                    break;
                }
                catch (Exception e)
                {
                    System.err.println("You should print the integer number!");
                    sc.next();
                }
            }

            String query3_ShowTitles = "SELECT * FROM titles WHERE publisherId = " + publId + " ORDER BY title";

            System.out.println("Show all titles of publisher with id: " + publId);

            ResultSet rs = stmt.executeQuery(query3_ShowTitles);
            int count = 0;

            while (rs.next()) {
                String isbn = rs.getString("isbn");
                String title = rs.getString("title");
                int editionNumber = rs.getInt("editionNumber");
                String year = rs.getString("year");
                int id = rs.getInt("publisherID");
                BigDecimal price = rs.getBigDecimal("price");
                System.out.println(id + "\t" + isbn + "\t" +"'" +title+"'" + "\t" + editionNumber + "\t" + year + "\t" + price + "$.");
                count++;
            }

            if(count==0) System.out.println("No one title!");


        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();

        } finally {
            //finally block used to close resources
            JDBC.close();
        }
    }


}
