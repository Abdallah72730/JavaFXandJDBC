package org.example.javafxandjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static ConfigLoader config = new ConfigLoader();
    private static final String url =  "jdbc:mysql://localHost:3306/DBConnectivity";
    private static final String user = "root";
    private static final String password123 = config.getPassword();



    public static Connection getConnection() throws SQLException {
        String username = user;
        String password = password123;
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
