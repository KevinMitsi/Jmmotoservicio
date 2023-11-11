package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.herramienta.Herramienta;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AgregarHerramientaViewController {
    public Hyperlink hlVolver;
    public TextField tfNombre;
    public TextField tfNumeroSerie;
    public TextField tfTipo;
    public TextField tfMarca;
    public DatePicker dpAdquisicion;
    public Button btnAgregar;
    MainJm main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();

    public void setMain(MainJm mainJm) {
        this.main = mainJm;
    }

    public void onVolverLinkClick(ActionEvent event) {
    }

    public void onAgregarButtonClick(ActionEvent event) throws IOException {
        if(verificarCampos()){
            singleton.getSedes().getInventario().getHerramientas().add(new Herramienta(tfNumeroSerie.getText(), tfNombre.getText(),tfTipo.getText(),tfMarca.getText(),"NUEVO",String.valueOf(dpAdquisicion.getValue()),true));
            Alerta.saltarAlertaInformacion("Se ha agregado correctamente esta herramienta a su inventario");
            main.abrirInventarioAdmin();
        }
        else{
            Alerta.saltarAlertaError("Hay campos vacíos o mal llenados");
        }
    }

    private boolean verificarCampos() {
        return !tfNombre.getText().isBlank()&&!tfMarca.getText().isBlank()&&!tfNumeroSerie.getText().isBlank()&&!tfTipo.getText().isBlank()&&(dpAdquisicion!=null);
    }
}
