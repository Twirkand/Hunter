package com.hunter.controllers;

import com.hunter.models.Monstruo;
import com.hunter.navigation.Navigator;
import com.hunter.repositories.SqliteConnectionManager;
import com.hunter.repositories.sqlite.MonstruoSqliteRepository;
import com.hunter.services.impl.MonstruoService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.Desktop;
import java.net.URI;

public class BuscarPorNombreFX {

    @FXML
    private TextField nombreOId;

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

    private final MonstruoService service =
            new MonstruoService(
                    new MonstruoSqliteRepository(
                            new SqliteConnectionManager()
                    )
            );

    @FXML
    public void initialize() {

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        elemento.setCellValueFactory(new PropertyValueFactory<>("elemento"));
        primeraAparicion.setCellValueFactory(new PropertyValueFactory<>("primeraAparicion"));

        tableMonstruos.setItems(FXCollections.observableArrayList());
    }

    @FXML
    private void buscar() {

        String input = nombreOId.getText().trim();

        if (input.isEmpty()) {
            tableMonstruos.setItems(FXCollections.observableArrayList());
            return;
        }

        if (input.matches("\\d+")) {

            Monstruo m = service.obtenerPorId(Integer.parseInt(input));

            if (m != null) {
                tableMonstruos.setItems(FXCollections.observableArrayList(m));
            } else {
                tableMonstruos.setItems(FXCollections.observableArrayList());
            }

        } else {

            tableMonstruos.setItems(
                    FXCollections.observableArrayList(
                            service.obtenerPorNombre(input)
                    )
            );
        }
    }

    @FXML
    private void volver() {
        Navigator.goTo("buscar_monstruos.fxml");
    }

    @FXML
    private void abrirWeb() {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(
                        new URI("https://github.com/Twirkand")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}