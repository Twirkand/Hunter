package com.hunter.controllers;

import com.hunter.models.Monstruo;
import com.hunter.repositories.SqliteConnectionManager;
import com.hunter.repositories.sqlite.MonstruoSqliteRepository;
import com.hunter.services.impl.MonstruoService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class BuscarPorNombreFX {

    @FXML private TextField nombreOId;

    @FXML private TableView<Monstruo> tableMonstruos;

    @FXML private TableColumn<Monstruo, Integer> id;
    @FXML private TableColumn<Monstruo, String> nombre;
    @FXML private TableColumn<Monstruo, String> tipo;
    @FXML private TableColumn<Monstruo, String> elemento;
    @FXML private TableColumn<Monstruo, String> primeraAparicion;

    private MonstruoService service;

    @FXML
    public void initialize() {

        SqliteConnectionManager manager = new SqliteConnectionManager();
        this.service = new MonstruoService(new MonstruoSqliteRepository(manager));

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        elemento.setCellValueFactory(new PropertyValueFactory<>("elemento"));
        primeraAparicion.setCellValueFactory(new PropertyValueFactory<>("primeraAparicion"));
    }

    @FXML
    private void buscar() {

        String input = nombreOId.getText().trim();

        if (input.isEmpty()) return;

        Monstruo m;

        if (input.matches("\\d+")) {
            m = service.obtenerPorId(Integer.parseInt(input));
        } else {
            m = service.obtenerPorNombre(input);
        }

        if (m != null) {
            tableMonstruos.setItems(FXCollections.observableArrayList(m));
        } else {
            tableMonstruos.setItems(FXCollections.observableArrayList());
        }
    }
}