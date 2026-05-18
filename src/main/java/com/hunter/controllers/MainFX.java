package com.hunter.controllers;

import java.awt.Desktop;
import java.net.URI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainFX {

    private Stage getStage() {
        return (Stage) javafx.stage.Stage.getWindows()
                .filtered(w -> w.isShowing())
                .get(0);
    }

    @FXML
    private void irVerMonstruos() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/listar_monstruos.fxml"));
        Scene scene = new Scene(loader.load());
        getStage().setScene(scene);
    }

    @FXML
    private void irBuscarMonstruos() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/buscar_monstruos.fxml"));
        Scene scene = new Scene(loader.load());
        getStage().setScene(scene);
    }

    @FXML
    private void abrirWeb() {
        try {
            Desktop desktop = Desktop.getDesktop();
            if (Desktop.isDesktopSupported()) {
                desktop.browse(new URI("https://github.com/Twirkand"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}