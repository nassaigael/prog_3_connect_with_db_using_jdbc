package com.hei.school.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    private static final String url = "jdbc:postgresql://localhost:5432/";
    private static final String user = "postgres";
    private static final String password = "PassNassaIWord";

    public static Connection getConnection() throws  SQLException {
        Connection conn = null;
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database successfully 😁");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            System.out.println("Connection closed successfully");
        }
        return conn;
    }

    public static void main(String[] args) throws SQLException {
        getConnection();
    }
}
