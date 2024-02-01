package com.example.martialschool.additionalMethods;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneLoader {
    public static void loadNewScene(String fxml, Scene currentScene) {
        try {
            Parent root = FXMLLoader.load(SceneLoader.class.getResource(fxml));

            Stage stage = (Stage) currentScene.getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
