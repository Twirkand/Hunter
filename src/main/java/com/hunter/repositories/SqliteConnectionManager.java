package com.hunter.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqliteConnectionManager {

    private final String url;

    public SqliteConnectionManager() {
        this.url = "jdbc:sqlite:database/monsters.db";
        loadDriver();
    }

    public SqliteConnectionManager(String url) {
        this.url = url;
        loadDriver();
    }

    private void loadDriver() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("No se encontró el driver SQLite", e);
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }
}