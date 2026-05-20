package com.hunter.controllers.old;

import com.hunter.navigation.Navigator;
import java.awt.Desktop;
import java.net.URI;
import javafx.fxml.FXML;

public class BuscarMonstruosFX {

    @FXML
    private void irBuscarPorTipo() {
        Navigator.goTo("buscar_por_tipos.fxml");
    }

    @FXML
    private void irBuscarPorNombre() {
        Navigator.goTo("buscar_por_nombre.fxml");
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