package com.hunter.controllers;

import com.hunter.models.Monstruo;
import com.hunter.repositories.SqliteConnectionManager;
import com.hunter.repositories.sqlite.MonstruoSqliteRepository;
import com.hunter.services.impl.MonstruoService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import java.io.InputStream;

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
    @FXML
    private ImageView monsterImage;
    @FXML
    private Button githubButton;
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
        githubButton.setOnAction(e -> abrirGitHub());
        tableMonstruos.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldVal, newVal) -> {
                    if (newVal != null) {
                        mostrarImagen(newVal);
                    }
                });
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

    private void abrirGitHub() {
        try {
            String url = "https://github.com/Twirkand";

            String os = System.getProperty("os.name").toLowerCase();

            ProcessBuilder pb;

            if (os.contains("linux")) {
                pb = new ProcessBuilder("xdg-open", url);
            } else if (os.contains("win")) {
                pb = new ProcessBuilder("cmd", "/c", "start", url);
            } else if (os.contains("mac")) {
                pb = new ProcessBuilder("open", url);
            } else {
                throw new UnsupportedOperationException("SO no soportado");
            }

            pb.start();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private String buildImagePath(Monstruo m) {
        String name = m.getNombre()
                .toLowerCase()
                .trim()
                .replaceAll("\\s+", "_")
                .replace("é", "e")
                .replace("í", "i")
                .replace("ó", "o")
                .replace("á", "a")
                .replace("ú", "u");

        return "/img/monsters/" + name + ".png";
    }

    private void mostrarImagen(Monstruo m) {

        String path = buildImagePath(m);

        InputStream stream = getClass().getResourceAsStream(path);

        if (stream == null) {
            System.out.println("No se encontró: " + path);
            stream = getClass().getResourceAsStream("/img/monsters/default.png");
        }

        if (stream == null) {
            System.out.println("TAMPOCO existe default.png");
            return;
        }

        monsterImage.setImage(new Image(stream));
    }
    
}