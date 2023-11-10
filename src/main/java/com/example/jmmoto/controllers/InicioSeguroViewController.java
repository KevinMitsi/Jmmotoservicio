package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.persona.Cliente;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class InicioSeguroViewController {
    public TextField tfCode;
    public Button btnCancelar;
    public Button btnIniciar;
    MainJm main;
    Cliente clienteLogeado;
    String codigo;


    public void setMain(MainJm mainJm, Cliente cliente, String codigoSeguridad) {
        main = mainJm;
        clienteLogeado = cliente;
        codigo=codigoSeguridad;
    }

    public void onCancelarButtonClick(ActionEvent event) throws IOException {
        main.inicializarLogin();
    }

    public void onIniciarButtonClick(ActionEvent event) throws IOException {
        if (tfCode.getText().equals(codigo)){
            main.abrirPanelCliente(clienteLogeado);
        }
        else{
            Alerta.saltarAlertaError("Codigo incorrecto");
        }
    }
}
