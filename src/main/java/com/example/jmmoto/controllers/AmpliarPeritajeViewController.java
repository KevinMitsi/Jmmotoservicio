package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.persona.Cliente;
import com.example.jmmoto.model.sede.Sede;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class AmpliarPeritajeViewController {
    MainJm main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    Cliente clienteLogueado;
    Sede sede = singleton.getSedes();
    public TextArea areaDescripcion;

    public void agendarButtonClick() {
    }

    public void onRegresarClick() throws IOException {
        main.abrirPanelCliente(clienteLogueado);
    }

    public void setMain(MainJm mainJm, Cliente clienteLogeado) {
        this.main=mainJm;
        this.clienteLogueado=clienteLogeado;
        areaDescripcion.setVisible(true);
        areaDescripcion.setText("El peritaje es una revisión que te ayuda a saber el valor de compra o de venta de la moto que lleves a Peritar " +
                "además puedes pedir un peritaje para hacer una cuenta de cobro a una aseguradora o a una persona por daños al vehículo");
    }
}
