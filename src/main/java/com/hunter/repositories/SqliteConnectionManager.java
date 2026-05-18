package com.hunter.repositories;

import java.io.InputStream;
import java.nio.file.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqliteConnectionManager {

    private static final String APP_FOLDER = System.getProperty("user.home") + "/.hunter";

    private static final String DB_PATH = APP_FOLDER + "/monsters.db";

    private static final String URL = "jdbc:sqlite:" + DB_PATH;

    public SqliteConnectionManager() {
        loadDriver();
        initDatabase();
    }

    private void loadDriver() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("No se encontró el driver SQLite", e);
        }
    }

    private void initDatabase() {
        try {
            Files.createDirectories(Paths.get(APP_FOLDER));

            Path dbPath = Paths.get(DB_PATH);

            if (!Files.exists(dbPath)) {

                InputStream in = getClass()
                        .getResourceAsStream("/database/monsters.db");

                if (in == null) {
                    throw new RuntimeException(
                            "No se encontró /database/monsters.db en resources");
                }

                Files.copy(in, dbPath, StandardCopyOption.REPLACE_EXISTING);
            }

        } catch (Exception e) {
            throw new RuntimeException("Error inicializando base de datos", e);
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}