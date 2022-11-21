package com.liceu.geom.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlDatabase {
    static Connection connection;

    static Connection getConnection() {
        if (connection != null) return connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://mysql:3306/MazeGame", "root", "root");
            return connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
