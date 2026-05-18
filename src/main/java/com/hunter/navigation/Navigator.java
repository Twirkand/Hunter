package com.hunter.navigation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Navigator {

    private static Stage stage;

    public static void init(Stage primaryStage) {
        stage = primaryStage;
    }

    public static void goTo(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Navigator.class.getResource("/fxml/" + fxml)
            );

            Scene scene = new Scene(loader.load());
            stage.setScene(scene);

        } catch (Exception e) {
            throw new RuntimeException("Error cargando vista: " + fxml, e);
        }
    }
}