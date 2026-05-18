package com.hunter;

import com.hunter.navigation.Navigator;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {

        // 🔥 Inicializa el Navigator con el Stage principal
        Navigator.init(stage);

        // 🔥 Primera pantalla de la app
        Navigator.goTo("main.fxml");

        stage.setTitle("Project Hunter");
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}