package com.hunter.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BuscarMonstruosFX {

    private Stage stage() {
        return (Stage) javafx.stage.Stage.getWindows().filtered(w -> w.isShowing()).get(0);
    }

    @FXML
    private void irBuscarPorTipo() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/buscar_por_tipos.fxml"));
        Scene scene = new Scene(loader.load());
        stage().setScene(scene);
    }

    @FXML
    private void irBuscarPorNombre() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/buscar_por_nombre.fxml"));
        Scene scene = new Scene(loader.load());
        stage().setScene(scene);
    }

    @FXML
    private void volver() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main.fxml"));
        Scene scene = new Scene(loader.load());
        stage().setScene(scene);
    }
}