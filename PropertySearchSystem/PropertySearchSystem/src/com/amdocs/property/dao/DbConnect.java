package com.amdocs.property.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
    public static void main(String[] args) {
        // JDBC URL, username, and password of Oracle database
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl"; // Replace with your Oracle database URL
        String username = "SYSTEM";
        String password = "Amdocs123";

        try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Create a connection to the database
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            if (connection != null) {
                System.out.println("Connected to Oracle SQL Developer!");
                // You can perform database operations here

                // Don't forget to close the connection when you're done
                connection.close();
            } else {
                System.out.println("Failed to connect to Oracle SQL Developer!");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection to Oracle SQL Developer failed.");
            e.printStackTrace();
        }
    }
}

