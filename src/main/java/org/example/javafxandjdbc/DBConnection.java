package org.example.javafxandjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String url =  "jdbc:mysql://mysql-studentmanagement-student491625365.g.aivencloud.com:21039/student_db";
    private static final String user = "avnadmin";
    private static final String password = "AVNS_6_eqWYN0K8o9W5K5o4R";

    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
