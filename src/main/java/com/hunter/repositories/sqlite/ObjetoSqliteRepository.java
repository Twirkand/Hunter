package com.hunter.repositories.sqlite;

import com.hunter.models.Objeto;
import com.hunter.repositories.IObjetoRepository;
import com.hunter.repositories.SqliteConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ObjetoSqliteRepository implements IObjetoRepository {

    private final SqliteConnectionManager manager;

    public ObjetoSqliteRepository() {
        this(new SqliteConnectionManager());
    }

    public ObjetoSqliteRepository(SqliteConnectionManager manager) {
        this.manager = manager;
    }

    @Override
    public List<Objeto> findAll() {
        try (Connection connection = manager.getConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT * FROM objeto")) {

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

    @Override
    public Objeto findById(int id) {
        try (Connection connection = manager.getConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT * FROM objeto WHERE id=?")) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (!rs.next()) return null;

            return new Objeto(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("rareza"),
                    rs.getString("descripcion")
            );

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean save(Objeto objeto) {
        try (Connection connection = manager.getConnection();
             PreparedStatement stmt = connection.prepareStatement(
                     "INSERT INTO objeto(nombre, rareza, descripcion) VALUES (?,?,?)")) {

            stmt.setString(1, objeto.getNombre());
            stmt.setInt(2, objeto.getRareza());
            stmt.setString(3, objeto.getDescripcion());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(Objeto objeto) {
        try (Connection connection = manager.getConnection();
             PreparedStatement stmt = connection.prepareStatement(
                     "UPDATE objeto SET nombre=?, rareza=?, descripcion=? WHERE id=?")) {

            stmt.setString(1, objeto.getNombre());
            stmt.setInt(2, objeto.getRareza());
            stmt.setString(3, objeto.getDescripcion());
            stmt.setInt(4, objeto.getId());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try (Connection connection = manager.getConnection();
             PreparedStatement stmt = connection.prepareStatement(
                     "DELETE FROM objeto WHERE id=?")) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            return false;
        }
    }
}