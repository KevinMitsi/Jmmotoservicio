package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.persona.Cliente;
import com.example.jmmoto.model.sede.Sede;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class AmpliarServicioRapidoViewController {
    public TextArea areaDescripcion;
    MainJm main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    Cliente clienteLogueado;
    Sede sede = singleton.getSedes();

    @FXML
    public void agendarButtonClick() {
    }
    @FXML
    public void onRegresarClick() throws IOException {
        main.abrirPanelCliente(clienteLogueado);
    }

    public void setMain(MainJm main, Cliente clieneLogeado){
        this.main=main;
        this.clienteLogueado=clieneLogeado;
        areaDescripcion.setVisible(true);
        areaDescripcion.setText("En este servicio entran todas las clases de procedimientos los cuales no son muy complejos y normalmente demoran poco algunos ejmeplos son: " +
                "\nCambio de pastillas.\nCambio de aceite.\nAjuste de una pieza. \n...");
    }
}
