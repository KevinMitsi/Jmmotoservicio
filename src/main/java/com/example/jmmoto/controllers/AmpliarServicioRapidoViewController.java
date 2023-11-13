package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.persona.Cliente;
import com.example.jmmoto.model.productos.Servicio;
import com.example.jmmoto.model.sede.Sede;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

import java.io.IOException;

public class AmpliarServicioRapidoViewController {
    public Label lblTituloServ;
    public Text txtDescrpcion;
     MainJm main;
    Cliente clienteLogueado;
    Servicio servicioSeleccionado;

    @FXML
    public void agendarButtonClick() throws IOException {
        main.abrirAgendarCitaCLiente(clienteLogueado, servicioSeleccionado);
    }
    @FXML
    public void onRegresarClick() throws IOException {
        main.abrirPanelCliente(clienteLogueado);
    }

    public void setMain(MainJm main, Cliente clieneLogeado, Servicio servicioSeleccionado){
        this.main=main;
        this.clienteLogueado=clieneLogeado;
        this.servicioSeleccionado=servicioSeleccionado;
        lblTituloServ.setText(servicioSeleccionado.getNombre());
        txtDescrpcion.setText(servicioSeleccionado.getEspecificaciones());
    }
}
