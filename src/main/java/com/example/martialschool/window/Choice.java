package com.example.martialschool.window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.martialschool.additionalMethods.SceneLoader;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class Choice {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button groups_button;

    @FXML
    private Button students_button;

    @FXML
    private Button trainer_button;

    @FXML
    void initialize() {

       // SceneLoader SceneLoader;
        //trainer_button.setOnAction(event -> {SceneLoader.loadNewScene("", trainer_button.getScene());});

        //students_button.setOnAction(event -> {SceneLoader.loadNewScene("AdminStudent.fxml", students_button.getScene());});

       // groups_button.setOnAction(event -> {SceneLoader.loadNewScene("Admin2.fxml", groups_button.getScene());});

        //students_button.setOnAction(event -> {

        //});

    }

}
