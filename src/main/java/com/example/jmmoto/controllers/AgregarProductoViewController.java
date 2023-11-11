package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.productos.Repuesto;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.IOException;

public class AgregarProductoViewController {
    public TextField tfNombre;
    public TextField tfCodeSAV;
    public TextField tfCategoria;
    public TextField tfMarca;
    public TextField tfPrecioCompra;
    public TextField tfPrecioVenta;
    public TextArea taDescripcion;
    public DatePicker dpFecha;
    public Hyperlink hlVolver;
    public Button btnAgregar;
    MainJm main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();

    public void setMain(MainJm mainJm) {
        this.main = mainJm;
    }

    public void onVolverButtonClick(ActionEvent actionEvent) throws IOException {
        main.abrirInventarioAdmin();
    }

    public void onAgregarButtonCLick(ActionEvent actionEvent) throws IOException {
        if (verificarCampos()){
            Repuesto repuesto = new Repuesto(tfNombre.getText(),tfCodeSAV.getText(),tfCategoria.getText(),taDescripcion.getText(),tfMarca.getText(),Double.parseDouble(tfPrecioCompra.getText()),Double.parseDouble(tfPrecioVenta.getText()),String.valueOf(dpFecha.getValue()));
            singleton.getSedes().getInventario().getProductos().add(repuesto);
            Alerta.saltarAlertaInformacion("Se ha agregado correctamente este repuesto a su inventario");
            main.abrirInventarioAdmin();
        }
        else{
            Alerta.saltarAlertaError("Hay campos vacíos a mal llenados");
        }
    }

    private boolean verificarCampos() {
        return !tfNombre.getText().isBlank() && !tfCategoria.getText().isBlank() && !tfMarca.getText().isBlank() && !tfCodeSAV.getText().isBlank() && (!tfPrecioCompra.getText().isBlank()&&verificarNumero(tfPrecioCompra.getText())) && (!tfPrecioVenta.getText().isBlank()&&verificarNumero(tfPrecioVenta.getText())) && !taDescripcion.getText().isBlank()&&(dpFecha.getValue()!=null);
    }

    private boolean verificarNumero(String text) {
        try{
            Double.parseDouble(text);
        }catch (NumberFormatException e){
            return false;
        }
        return  true;
    }
}
