package com.hunter.controllers;

import com.hunter.models.Monstruo;
import com.hunter.navigation.Navigator;
import com.hunter.repositories.SqliteConnectionManager;
import com.hunter.repositories.sqlite.MonstruoSqliteRepository;
import com.hunter.services.impl.MonstruoService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.Desktop;
import java.net.URI;
import java.util.List;

public class ListarMonstruosFX {

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

        cargarDatos();
    }

    private void cargarDatos() {
        List<Monstruo> lista = service.obtenerTodos();
        tableMonstruos.setItems(FXCollections.observableArrayList(lista));
    }

    @FXML
    private void volver() {
        Navigator.goTo("main.fxml");
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