package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.persona.Cliente;
import com.example.jmmoto.model.sede.Sede;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class AmpliarRevisionViewController {
    MainJm main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    Cliente clienteLogueado;
    Sede sede = singleton.getSedes();
    public TextArea areaDescripcion;

    public void agendarButtonClick(ActionEvent event) {
    }

    public void onRegresarClick(ActionEvent event) throws IOException {
        main.abrirPanelCliente(clienteLogueado);
    }

    public void setMain(MainJm mainJm, Cliente clienteLogeado) {
        this.main=mainJm;
        this.clienteLogueado=clienteLogeado;
        areaDescripcion.setVisible(true);
        areaDescripcion.setText("Una revisión es un procedimiento necesario en tu motocicleta cada 5000 kilometros, en este servicio puedes contarnos todos los problemas que has tenido con tu vehículo. Sino hay ninguna procederemos a engresar las piezas móviles a cambiar el aceite y a verificar una lista de chequeos básicos que tu moto debería tener.");
    }
}
