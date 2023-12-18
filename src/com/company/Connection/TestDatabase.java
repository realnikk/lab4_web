package com.company.Connection;

import java.sql.SQLException;

public class TestDatabase {

    public static void main(String[] argv) {

        System.out.println("-------- MySQL JDBC Connection Testing ------------");
        try {
            JDBC.connect();
        } catch (SQLException e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
            return;
        }

        JDBC.close();
    }
}
