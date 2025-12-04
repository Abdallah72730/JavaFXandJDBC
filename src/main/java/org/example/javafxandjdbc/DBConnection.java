package org.example.javafxandjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static ConfigLoader config = new ConfigLoader();
    private static final String url =  "jdbc:mysql://mysql-studentmanagement-student491625365.g.aivencloud.com:21039/student_db";



    public static Connection getConnection() throws SQLException {
        String username = config.getUsername();
        String password = config.getPassword();
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
