package com.hunter.repositories.sqlite;

import com.hunter.models.Monstruo;
import com.hunter.repositories.ConnectionManager;
import com.hunter.repositories.interfaces.IMonstruoRepository;
import com.hunter.factories.MonstruoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MonstruoSqliteRepository implements IMonstruoRepository {

    private final ConnectionManager manager;

    public MonstruoSqliteRepository(ConnectionManager manager) {
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
                        rs.getString("primera_aparicion"),
                        0));
            }

            return lista;

        } catch (Exception e) {
            return null;
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
        rs.getString("primera_aparicion"),
        0
);

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean save(Monstruo m) {

        String sql = "INSERT INTO monstruo(nombre, tipo, elemento, vida, primera_aparicion) VALUES (?,?,?,?,?)";

        try (Connection conn = manager.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, m.getNombre());
            stmt.setString(2, m.getTipo());
            stmt.setString(3, m.getElemento());
            stmt.setInt(4, m.getVida());
            stmt.setString(5, m.getPrimeraAparicion());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
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
}