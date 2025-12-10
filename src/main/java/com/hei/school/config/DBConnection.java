package com.hei.school.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private final String JDBC_URL = "jdbc:postgresql://localhost:5432/product_management_db";
    private final String USERNAME = "postgres";
    private final String PASSWORD = "PassNassaIWord";

    public Connection getDBConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }
}
