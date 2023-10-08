package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginViewController {
    public PasswordField passwordField;
    public TextField usernameField;
    MainJm main;
    ModelFactoryController domain = ModelFactoryController.getInstance();


    public void registerButtonClick(ActionEvent actionEvent) {
    }

    public void loginButtonAction(ActionEvent actionEvent) {


    }

    public void setMain(MainJm mainJm) {
        this.main=mainJm;
    }
}
