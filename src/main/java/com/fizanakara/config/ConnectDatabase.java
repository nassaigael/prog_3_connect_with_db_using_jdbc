package com.fizanakara.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    private static final String url = "jdbc:postgresql://localhost:5432/name_of_database";
    private static final String user = "database_username";
    private static final String password = "database_password";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database successfully 😁");
        } catch (SQLException e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
        }
        return connection;
    }
}
