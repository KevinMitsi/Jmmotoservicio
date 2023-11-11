package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.productos.Repuesto;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.io.IOException;

public class AmpliarRepuestoViewController {
    MainJm main;
    Repuesto repuestoSeleccionado;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    public Label lblNombreRepuesto;
    public Label lblNumeroSAV;
    public Label lblCategoria;
    public Label lblMarca;
    public Label lblVenta;
    public Button btnVolver;
    public Label lblCompra;
    public Text txtDescripcion;
    public Label lblDisponibilidad;

    public void onVolverButtonClick(ActionEvent actionEvent) throws IOException {
        main.abrirInventarioAdmin();
    }
    public void setMain(MainJm main, Repuesto repuestoSeleccionado){
        this.main = main;
        this.repuestoSeleccionado = repuestoSeleccionado;
        fillLabels();
    }

    private void fillLabels() {
        lblNombreRepuesto.setText(repuestoSeleccionado.getNombre());
        lblNumeroSAV.setText(repuestoSeleccionado.getCodigoSav());
        lblCategoria.setText(repuestoSeleccionado.getCategoria());
        lblMarca.setText(repuestoSeleccionado.getMarca());
        lblVenta.setText(String.valueOf(repuestoSeleccionado.getPrecioVenta()));
        lblCompra.setText(String.valueOf(repuestoSeleccionado.getPrecioCompra()));
        lblDisponibilidad.setText(singleton.getSedes().calcularDisponibilidad(repuestoSeleccionado));
        txtDescripcion.setText(repuestoSeleccionado.getDescripcion());
    }
}
