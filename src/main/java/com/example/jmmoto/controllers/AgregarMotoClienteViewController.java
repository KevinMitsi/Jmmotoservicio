package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.moto.Moto;
import com.example.jmmoto.model.persona.Cliente;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AgregarMotoClienteViewController {
    MainJm main;
    Cliente cliente;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    boolean panel;
    public TextField tfMarca;
    public TextField tfPlaca;
    public TextField tfKilometraje;
    public TextField tfModelo;
    public TextField tfCilindraje;
    public ComboBox<String> cbOpciones;
    public Button btnAgregar;
    public Hyperlink hlVolver;

    public void onAgregarButtonCLick() {
        if (verificarCampos()){
            try {
                Moto moto = new Moto(tfPlaca.getText(), tfModelo.getText(), tfMarca.getText(), null, null, null, cbOpciones.getValue(), tfCilindraje.getText(), null, null, tfKilometraje.getText(), null, false, null);
                cliente.agregarMoto(moto);
                singleton.guardarResourceXML();
                if (panel){
                    main.abrirPanelCliente(cliente);
                }
                else{
                    main.abrirMotosCliente(cliente);
                }
            }catch (Exception e){
                Alerta.saltarAlertaError(e.getMessage());
            }
        }
        else{
            Alerta.saltarAlertaError("Hay campos vacíos o números mal llenados");
        }
    }

    private boolean verificarCampos() {
        return !tfMarca.getText().isBlank()
                && !tfPlaca.getText().isBlank()
                && (!tfKilometraje.getText().isBlank() && isNumber(tfKilometraje.getText()))
                && !tfModelo.getText().isBlank()
                && !tfCilindraje.getText().isBlank()
                && (cbOpciones.getValue() != null);
    }
    private boolean isNumber(String text) {
        try{
            Double.parseDouble(text);
        }catch (NumberFormatException e){
            Alerta.saltarAlertaError("No ha ingresado un numero en el campo de precio");
            return false;
        }
        return true;
    }

    public void onVolverButtonCLick() throws IOException {
        if (panel){
            main.abrirPanelCliente(cliente);
        }
        else{
            main.abrirMotosCliente(cliente);
        }
    }

    public void setMain(MainJm main,Cliente cliente, boolean panel){
        this.main = main;
        this.cliente = cliente;
        this.panel = panel;
    }

    @FXML
    void initialize(){
        cbOpciones.getItems().add("2 TIEMPOS");
        cbOpciones.getItems().add("4 TIEMPOS");
    }
}
