package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.Factorys.FactoryCuenta;
import com.example.jmmoto.model.cuenta.Cuenta;
import com.example.jmmoto.model.persona.Analista;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class AbrirCrearAnalistaViewController {
    public TextField tfNombre;
    public TextField tfApellido;
    public TextField tfTel;
    public TextField tfCedula;
    public TextField tfHorario;
    public TextField tfSalario;
    public TextField tfEmail;
    public DatePicker dpFechaNacimiento;
    public ComboBox<String> cbGenero;
    public ComboBox<String> cbEstado;
    public TextField tfUsuario;
    public TextField tfPassword;
    public Button btnAgregar;
    public Hyperlink hlVolver;
    MainJm mainJm;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    public void setMain(MainJm mainJm) {
        this.mainJm = mainJm;
    }

    public void onAgregarButtonCLick() {
        if (verificarCampos()){
            try{
                Cuenta cuenta = FactoryCuenta.createCuenta(tfUsuario.getText(),tfPassword.getText());
                Analista analista = new Analista(tfNombre.getText(),tfApellido.getText(),tfCedula.getText(),String.valueOf(dpFechaNacimiento.getValue()),cbGenero.getValue(),tfTel.getText(),tfEmail.getText(),cbEstado.getValue(),Double.parseDouble(tfSalario.getText()),tfHorario.getText(),"ninguna",cuenta);
                singleton.getSedes().agregarAnalista(analista);
                Alerta.saltarAlertaError("Se ha agregado correctamente");
                singleton.guardarResourceXML();
                mainJm.abrirEmpleadosAdmin();
            } catch (Exception e) {
                Alerta.saltarAlertaError(e.getMessage());
            }
        }
        else{
            Alerta.saltarAlertaError("Hay campos vacíos o mal llenados");
        }
    }

    private boolean verificarCampos() {
        return !tfNombre.getText().isBlank()&&!tfApellido.getText().isBlank()
                &&!tfTel.getText().isBlank()&&!tfCedula.getText().isBlank()
                &&!tfHorario.getText().isBlank()&&!tfEmail.getText().isBlank()
                &&(!tfSalario.getText().isBlank()&&isNumber(tfSalario.getText()))
                &&!tfUsuario.getText().isBlank()&&!tfPassword.getText().isBlank()
                &&(cbGenero.getValue()!=null)&&(cbEstado.getValue()!=null)
                &&(dpFechaNacimiento.getValue()!=null);
    }

    private boolean isNumber(String text) {
        try{
            Double.parseDouble(text);
        }catch (NumberFormatException e){
            return  false;
        }
        return true;
    }

    public void onVolverButtonCLick() throws IOException {
        mainJm.abrirEmpleadosAdmin();
    }
    @FXML
    void initialize(){
        cbEstado.getItems().addAll("Solter@","Casad@","Viud@","Union Libre");
        cbGenero.getItems().addAll("Masculino","Femenino","No especificar");
    }
}
