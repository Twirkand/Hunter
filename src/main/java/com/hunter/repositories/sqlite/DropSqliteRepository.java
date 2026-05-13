package com.hunter.repositories.sqlite;

import com.hunter.models.Objeto;
import com.hunter.repositories.IDropRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DropSqliteRepository implements IDropRepository {

    private final SqliteConnectionManager manager;

    public DropSqliteRepository() {
        this(new SqliteConnectionManager());
    }

    public DropSqliteRepository(SqliteConnectionManager manager) {
        this.manager = manager;
    }

    @Override
    public List<Objeto> findDropsByMonstruo(int idMonstruo) {

        try (Connection connection = manager.getConnection();
             PreparedStatement stmt = connection.prepareStatement(
                     "SELECT o.id, o.nombre, o.rareza, o.descripcion " +
                     "FROM drop_monstruo d " +
                     "JOIN objeto o ON d.id_objeto = o.id " +
                     "WHERE d.id_monstruo=?")) {

            stmt.setInt(1, idMonstruo);
            ResultSet rs = stmt.executeQuery();

            List<Objeto> lista = new ArrayList<>();

            while (rs.next()) {
                lista.add(new Objeto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("rareza"),
                        rs.getString("descripcion")
                ));
            }

            return lista;

        } catch (Exception e) {
            return null;
        }
    }
}