package com.hunter.repositories.sqlite;

import com.hunter.models.Objeto;
import com.hunter.repositories.IDropRepository;
import com.hunter.repositories.SqliteConnectionManager;
import com.hunter.models.Drop;

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
    public List<Drop> findDropsByMonstruoId(int idMonstruo) {

        String sql = """
                    SELECT o.id, o.nombre, o.rareza, o.descripcion, d.probabilidad
                    FROM drop_monstruo d
                    JOIN objeto o ON d.id_objeto = o.id
                    WHERE d.id_monstruo = ?
                """;

        try (Connection conn = manager.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idMonstruo);
            ResultSet rs = stmt.executeQuery();

            List<Drop> lista = new ArrayList<>();

            while (rs.next()) {

                Objeto obj = new Objeto();
                obj.setId(rs.getInt("id"));
                obj.setNombre(rs.getString("nombre"));
                obj.setRareza(rs.getInt("rareza"));
                obj.setDescripcion(rs.getString("descripcion"));

                Drop drop = new Drop();
                drop.setObjeto(obj);
                drop.setProbabilidad(rs.getDouble("probabilidad"));

                lista.add(drop);
            }

            return lista;

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<Drop> findDropsByMonstruoNombre(String nombreMonstruo) {

        String sql = """
                    SELECT o.id, o.nombre, o.rareza, o.descripcion, d.probabilidad
                    FROM drop_monstruo d
                    JOIN objeto o ON d.id_objeto = o.id
                    JOIN monstruo m ON d.id_monstruo = m.id
                    WHERE LOWER(m.nombre) = LOWER(?)
                """;

        try (Connection conn = manager.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombreMonstruo);

            ResultSet rs = stmt.executeQuery();

            List<Drop> drops = new ArrayList<>();

            while (rs.next()) {

                Objeto obj = new Objeto();
                obj.setId(rs.getInt("id"));
                obj.setNombre(rs.getString("nombre"));
                obj.setRareza(rs.getInt("rareza"));
                obj.setDescripcion(rs.getString("descripcion"));

                Drop drop = new Drop();
                drop.setObjeto(obj);
                drop.setProbabilidad(rs.getDouble("probabilidad"));

                drops.add(drop);
            }

            return drops;

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}