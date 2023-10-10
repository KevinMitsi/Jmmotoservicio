package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.persona.Cliente;
import com.example.jmmoto.model.sede.Sede;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AmpliarServicioViewController {
    public Label titleLabel;
    public Label descriptionLabel;
    public Button backButton;
    public Button scheduleButton;
    MainJm main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    Cliente clienteLogueado;
    String seleccion;
    Sede sede = singleton.getSedes();
    public void setMain(MainJm mainJm, Cliente clienteLogeado, String seleccion) {
        this.main=mainJm;
        this.clienteLogueado=clienteLogeado;
        this.seleccion=seleccion;

    }

    public void volverButtonClick(ActionEvent event) {
    }

    public void agendarButtonClick(ActionEvent event) {
    }
}
