package com.hunter.controllers;

import com.hunter.models.Monstruo;
import com.hunter.repositories.SqliteConnectionManager;
import com.hunter.repositories.sqlite.MonstruoSqliteRepository;
import com.hunter.services.impl.MonstruoService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.List;

public class BuscarPorTipoFX {

    @FXML private ComboBox<String> comboTipos;
    @FXML private TableView<Monstruo> tableMonstruos;

    @FXML private TableColumn<Monstruo, Integer> id;
    @FXML private TableColumn<Monstruo, String> nombre;
    @FXML private TableColumn<Monstruo, String> tipo;
    @FXML private TableColumn<Monstruo, String> elemento;
    @FXML private TableColumn<Monstruo, String> primeraAparicion;

    private MonstruoService service;

    @FXML
    public void initialize() {

        service = new MonstruoService(
                new MonstruoSqliteRepository(new SqliteConnectionManager())
        );

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        elemento.setCellValueFactory(new PropertyValueFactory<>("elemento"));
        primeraAparicion.setCellValueFactory(new PropertyValueFactory<>("primeraAparicion"));

        List<String> tipos = service.obtenerTodos()
                .stream()
                .map(Monstruo::getTipo)
                .distinct()
                .sorted()
                .toList();

        comboTipos.setItems(FXCollections.observableArrayList(tipos));
    }

    @FXML
    private void buscar() {

        String tipo = comboTipos.getValue();

        if (tipo == null || tipo.isBlank()) return;

        tableMonstruos.setItems(
                FXCollections.observableArrayList(
                        service.obtenerPorTipo(tipo)
                )
        );
    }

    @FXML
    private void volver() throws Exception {
        Stage stage = (Stage) tableMonstruos.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/buscar_monstruos.fxml"));
        Scene scene = new Scene(loader.load());

        stage.setScene(scene);
    }
    @FXML
    private void abrirWeb() {
        try {
            java.awt.Desktop.getDesktop().browse(
                    new java.net.URI("https://github.com/Twirkand")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}