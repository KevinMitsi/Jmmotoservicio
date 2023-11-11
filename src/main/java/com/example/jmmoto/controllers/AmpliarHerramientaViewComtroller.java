package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.herramienta.Herramienta;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class AmpliarHerramientaViewComtroller {
    public Label lblNombreHerramienta;
    public Label lblNumeroSerie;
    public Label lblTipo;
    public Label lblMarca;
    public Label lblEstado;
    public Label lblDisponible;
    public Button btnVolver;
    MainJm main;
    Herramienta herramientaSeleccionada;
    public void setMain(MainJm main, Herramienta herramientaSeleccionada){
        this.main=main;
        this.herramientaSeleccionada = herramientaSeleccionada;
        fillLabels();
    }

    private void fillLabels() {
        lblDisponible.setText(String.valueOf(herramientaSeleccionada.isDisponibilidad()));
        lblEstado.setText(herramientaSeleccionada.getEstado());
        lblMarca.setText(herramientaSeleccionada.getMarca());
        lblNumeroSerie.setText(herramientaSeleccionada.getNumeroSerie());
        lblTipo.setText(herramientaSeleccionada.getTipo());
        lblNombreHerramienta.setText(herramientaSeleccionada.getNombre());
    }

    public void onVolverButtonClick(ActionEvent actionEvent) throws IOException {
        main.abrirInventarioAdmin();
    }
}
