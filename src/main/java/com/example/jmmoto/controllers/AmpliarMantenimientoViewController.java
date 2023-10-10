package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.persona.Cliente;
import com.example.jmmoto.model.sede.Sede;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class AmpliarMantenimientoViewController {
    public Label titleLabel;
    public Label descriptionLabel;
    public Button scheduleButton;
    public TextArea areaDescripcion;
    MainJm main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    Cliente clienteLogueado;
    Sede sede = singleton.getSedes();
    public void setMain(MainJm mainJm, Cliente clienteLogeado) {
        this.main=mainJm;
        this.clienteLogueado=clienteLogeado;
        areaDescripcion.setVisible(true);
        areaDescripcion.setText("Un mantenimiento es un tipo de revisión muy específica la cual debe hacer cada 10.000 km. En este servicio podrá contarnos las novedades que tiene con su vehículo y nosotros los solucionaremos, además se le realizará una lista de chequeos muy completa: " +
                "\n*Revisión de tornillería en general" +
                "\n*Revisión del tren delantero y trasero" +
                "\n*Cambio de filtros y revisión del sistema de frenos" +
                "\n*reglaje del carburador o limpieza de inyectores");

    }

    @FXML
    public void agendarButtonClick() {

    }

    @FXML
    public void onRegresarClick() throws IOException {
        main.abrirPanelCliente(clienteLogueado);
    }
}
