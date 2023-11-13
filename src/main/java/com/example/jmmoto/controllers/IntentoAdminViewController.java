package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class IntentoAdminViewController {
    public TextField tfCode;
    public Button btnCancelar;
    public Button btnIniciar;
    MainJm main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    private String keyProduct;

    public void setMain(MainJm mainJm, String key) {
        this.main = mainJm;
        this.keyProduct = key;
    }

    public void onCancelarButtonClick(ActionEvent event) throws IOException {
        main.inicializarLogin();
    }

    public void onIniciarButtonClick(ActionEvent event) throws IOException {
        if (tfCode.getText().equals(keyProduct)){
            main.abrirPanelAdmin();
        }
        else{
            Alerta.saltarAlertaError("Llave de producto incorrecta, cerrando");
            main.inicializarLogin();
        }
    }
}
