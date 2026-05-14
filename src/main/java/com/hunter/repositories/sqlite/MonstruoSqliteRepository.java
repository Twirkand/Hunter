package com.hunter.repositories.sqlite;

import com.hunter.models.Monstruo;
import com.hunter.repositories.SqliteConnectionManager;
import com.hunter.repositories.IMonstruoRepository;
import com.hunter.factories.MonstruoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MonstruoSqliteRepository implements IMonstruoRepository {

    private final SqliteConnectionManager manager;

    public MonstruoSqliteRepository(SqliteConnectionManager manager) {
        this.manager = manager;
    }

    @Override
    public List<Monstruo> findAll() {

        String sql = "SELECT * FROM monstruo";

        try (Connection conn = manager.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();

            List<Monstruo> lista = new ArrayList<>();

            while (rs.next()) {
                lista.add(MonstruoFactory.crear(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("tipo"),
                        rs.getString("elemento"),
                        rs.getInt("vida"),
                        rs.getString("primera_aparicion")));
            }

            return lista;

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Monstruo findById(int id) {

        String sql = "SELECT * FROM monstruo WHERE id=?";

        try (Connection conn = manager.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (!rs.next())
                return null;

            return MonstruoFactory.crear(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("tipo"),
                    rs.getString("elemento"),
                    rs.getInt("vida"),
                    rs.getString("primera_aparicion")

            );

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean save(Monstruo m) {

        String sql = "INSERT INTO monstruo(nombre, tipo, elemento, vida, primera_aparicion) VALUES (?,?,?,?,?)";

        try (Connection conn = manager.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, m.getNombre());
            stmt.setString(2, m.getTipo());
            stmt.setString(3, m.getElemento());
            stmt.setInt(4, m.getVida());
            stmt.setString(5, m.getPrimeraAparicion());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);

            insertarTipo(conn, m.getTipo(), id);

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Monstruo m) {

        String sql = "UPDATE monstruo SET nombre=?, tipo=?, elemento=?, vida=?, primera_aparicion=? WHERE id=?";

        try (Connection conn = manager.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, m.getNombre());
            stmt.setString(2, m.getTipo());
            stmt.setString(3, m.getElemento());
            stmt.setInt(4, m.getVida());
            stmt.setString(5, m.getPrimeraAparicion());
            stmt.setInt(6, m.getId());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(int id) {

        String sql = "DELETE FROM monstruo WHERE id=?";

        try (Connection conn = manager.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Monstruo findByNombre(String nombre) {

        String sql = "SELECT * FROM monstruo WHERE LOWER(nombre) = LOWER(?)";

        try (Connection conn = manager.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombre);

            ResultSet rs = stmt.executeQuery();

            if (!rs.next())
                return null;

            return MonstruoFactory.crear(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("tipo"),
                    rs.getString("elemento"),
                    rs.getInt("vida"),
                    rs.getString("primera_aparicion"));

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void insertarTipo(Connection conn, String tipo, int id) throws SQLException {

        switch (tipo) {

            case "Wyvern Volador":
                try (PreparedStatement ps = conn.prepareStatement(
                        "INSERT INTO wyvern_volador (id, variantes) VALUES (?, 0)")) {
                    ps.setInt(1, id);
                    ps.executeUpdate();
                }
                break;

            case "Leviatan":
                try (PreparedStatement ps = conn.prepareStatement(
                        "INSERT INTO leviatan (id, variantes) VALUES (?, 0)")) {
                    ps.setInt(1, id);
                    ps.executeUpdate();
                }
                break;

            case "Dragon Anciano":
                try (PreparedStatement ps = conn.prepareStatement(
                        "INSERT INTO dragon_anciano (id, variantes) VALUES (?, 0)")) {
                    ps.setInt(1, id);
                    ps.executeUpdate();
                }
                break;
        }
    }

    @Override
    public List<Monstruo> findByTipo(String tipo) {

        String sql = "SELECT * FROM monstruo WHERE LOWER(tipo) = LOWER(?)";

        try (Connection conn = manager.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tipo);

            ResultSet rs = stmt.executeQuery();

            List<Monstruo> lista = new ArrayList<>();

            while (rs.next()) {
                lista.add(MonstruoFactory.crear(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("tipo"),
                        rs.getString("elemento"),
                        rs.getInt("vida"),
                        rs.getString("primera_aparicion")));
            }

            return lista;

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}