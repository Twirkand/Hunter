package com.hunter.controllers;

import com.hunter.models.Monstruo;
import com.hunter.repositories.SqliteConnectionManager;
import com.hunter.repositories.sqlite.MonstruoSqliteRepository;
import com.hunter.services.impl.MonstruoService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.List;

public class ListarMonstruosFX {

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

        cargarDatos();

        System.out.println("DEBUG monstruos: " + service.obtenerTodos().size());
    }

    private void cargarDatos() {
        List<Monstruo> lista = service.obtenerTodos();
        tableMonstruos.setItems(FXCollections.observableArrayList(lista));
    }

    @FXML
    private void volver() throws Exception {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/main.fxml")
        );

        Stage stage = (Stage) tableMonstruos.getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
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