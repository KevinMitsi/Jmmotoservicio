package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;

import java.io.IOException;

public class AdminPanelViewController {
    MainJm main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    public Button btnInventario;
    public Button btnServicios;
    public Button btnEmpleados;
    public Button btnClientes;
    public Hyperlink hlSalir;

    public void onInventarioButtonCLick(ActionEvent event) throws IOException {
        main.abrirInventarioAdmin();
    }

    public void onServiciosButtonCLick(ActionEvent event) throws IOException{
        main.abrirServciosAdmin();
    }

    public void onEmpleadosButtonCLick(ActionEvent event) throws IOException{
        main.abrirEmpleadosAdmin();
    }

    public void onClientesButtonCLick(ActionEvent event) throws IOException{
        main.abrirClientesAdmin();
    }

    public void onSalirLinkClick(ActionEvent event) throws IOException {
        main.inicializarLogin();
    }

    public void setMain(MainJm mainJm) {
        this.main = mainJm;
    }
}
