package com.example.jmmoto.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class HelloController {
    public TextField usernameField;
    public PasswordField passwordField;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void loginButtonAction(ActionEvent actionEvent) {
    }

    public void registerButtonClick(ActionEvent actionEvent) {
    }
}