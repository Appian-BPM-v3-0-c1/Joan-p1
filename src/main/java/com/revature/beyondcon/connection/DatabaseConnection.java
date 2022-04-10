package com.revature.beyondcon.connection;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    // Instantiating Connection object.
    private static Connection con = null;

    // Instantiating Properties object to retrieve properties variables.
    private static final Properties prop = new Properties();

    static {
        try {
            // Importing the jbdc jar file to the jvm.
            Class.forName("org.postgresql.Driver");

            // Using properties object to load url, username, and password.
            prop.load(new FileReader("\\Users\\jack\\OneDrive - Revature LLC\\Project 1\\src\\main\\resources\\db.properties"));

            // Actually getting this connection.
            con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));

            // Throw connection if connection was not successful.
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    // Getter for connection.
    public static Connection getCon() {
        return con;
    }
}