package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;

import java.io.IOException;

public class AdminPanelViewController {
    MainJm main;
    public Button btnInventario;
    public Button btnServicios;
    public Button btnEmpleados;
    public Button btnClientes;
    public Hyperlink hlSalir;

    public void onInventarioButtonCLick() throws IOException {
        main.abrirInventarioAdmin();
    }

    public void onServiciosButtonCLick() throws IOException{
        main.abrirServciosAdmin();
    }

    public void onEmpleadosButtonCLick() throws IOException{
        main.abrirEmpleadosAdmin();
    }

    public void onClientesButtonCLick() throws IOException{
        main.abrirClientesAdmin();
    }

    public void onSalirLinkClick() throws IOException {
        main.inicializarLogin();
    }

    public void setMain(MainJm mainJm) {
        this.main = mainJm;
    }
}
