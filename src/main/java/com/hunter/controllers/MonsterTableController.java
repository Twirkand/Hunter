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
import java.util.stream.Collectors;

public class MonsterTableController {

    // ================= TABLE =================
    @FXML
    private TableView<Monstruo> tableMonstruos;

    @FXML
    private TableColumn<Monstruo, Integer> id;
    @FXML
    private TableColumn<Monstruo, String> nombre;
    @FXML
    private TableColumn<Monstruo, String> tipo;
    @FXML
    private TableColumn<Monstruo, String> elemento;
    @FXML
    private TableColumn<Monstruo, String> primeraAparicion;

    // ================= FILTERS =================
    @FXML
    private ComboBox<String> typeCombo;
    @FXML
    private TextField nameField;

    // ================= SERVICE =================
    private MonstruoService service;

    // ================= INIT =================
    @FXML
    public void initialize() {

        SqliteConnectionManager manager = new SqliteConnectionManager();

        this.service = new MonstruoService(
                new MonstruoSqliteRepository(manager));

        configurarTabla();
        cargarTipos();

        tableMonstruos.setItems(FXCollections.observableArrayList());
    }

    // ================= CONFIG TABLE =================
    private void configurarTabla() {

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        elemento.setCellValueFactory(new PropertyValueFactory<>("elemento"));
        primeraAparicion.setCellValueFactory(new PropertyValueFactory<>("primeraAparicion"));
    }

    // ================= LOAD ALL =================
    @FXML
    private void handleLoadAll() {
        cargarTodos();
    }

    private void cargarTodos() {
        List<Monstruo> lista = service.obtenerTodos();
        tableMonstruos.setItems(FXCollections.observableArrayList(lista));
    }

    // ================= SEARCH BY NAME =================
    @FXML
    private void handleSearchByName() {

        String input = nameField.getText().trim();

        if (input.isEmpty()) {
            cargarTodos();
            return;
        }

        tableMonstruos.setItems(
                FXCollections.observableArrayList(
                        service.obtenerPorNombre(input)));
    }

    // ================= SEARCH BY TYPE =================
    @FXML
    private void handleSearchByType() {

        String tipoValue = typeCombo.getValue();

        if (tipoValue == null || tipoValue.isEmpty()) {
            cargarTodos();
            return;
        }

        tableMonstruos.setItems(
                FXCollections.observableArrayList(
                        service.obtenerPorTipo(tipoValue)));
    }

    // ================= TIPOS DESDE BD =================
    private void cargarTipos() {

        List<Monstruo> todos = service.obtenerTodos();

        List<String> tipos = todos.stream()
                .map(Monstruo::getTipo)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        typeCombo.setItems(FXCollections.observableArrayList(tipos));
    }
}