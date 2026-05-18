package com.hunter.controllers;

import com.hunter.navigation.Navigator;
import java.awt.Desktop;
import java.net.URI;
import javafx.fxml.FXML;

public class MainFX {

    @FXML
    private void irVerMonstruos() {
        Navigator.goTo("listar_monstruos.fxml");
    }

    @FXML
    private void irBuscarMonstruos() {
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