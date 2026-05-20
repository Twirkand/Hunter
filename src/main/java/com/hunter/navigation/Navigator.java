package com.hunter.navigation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Navigator {

    private static Stage stage;

    private static final String CSS =
            Navigator.class.getResource("/fxml/css/styles.css").toExternalForm();

    public static void init(Stage primaryStage) {
        stage = primaryStage;
    }

    public static void goTo(String fxml) {
        try {

            FXMLLoader loader = new FXMLLoader(
                    Navigator.class.getResource("/fxml/" + fxml)
            );

            Parent root = loader.load();

            Scene scene = new Scene(root);

            scene.getStylesheets().add(CSS);

            stage.setScene(scene);

        } catch (Exception e) {
            throw new RuntimeException("Error cargando vista: " + fxml, e);
        }
    }
}