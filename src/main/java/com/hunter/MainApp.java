package com.hunter;

import com.hunter.navigation.Navigator;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {

        // 🔥 Inicializa navegación
        Navigator.init(stage);

        // 🔥 Pantalla principal de tu nueva app (LISTADO MONSTRUOS)
        Navigator.goTo("main.fxml");

        // ================= CONFIG VENTANA =================
        stage.setTitle("Hunter - Monstruos");
        stage.setResizable(true); // 🔥 importante para tu CSS responsive

        // opcional pero recomendable
        stage.setMinWidth(800);
        stage.setMinHeight(500);

        stage.centerOnScreen();
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}