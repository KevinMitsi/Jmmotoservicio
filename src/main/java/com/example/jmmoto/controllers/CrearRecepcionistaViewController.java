package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.Factorys.FactoryCuenta;
import com.example.jmmoto.model.cuenta.Cuenta;
import com.example.jmmoto.model.persona.Recepcionista;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class CrearRecepcionistaViewController {
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
    public TextField tfExperienciaLaboral;
    public Button btnAgregar;
    public Hyperlink hlVolver;
    public ComboBox<String> cbEducacion;
    public TextField tfPassword;
    public TextField tfUsuario;
    MainJm main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();

    public void setMain(MainJm mainJm) {
        this.main = mainJm;
    }

    public void onAgregarButtonCLick() {
        if (verificarCampos()){
            if (!verificarUsuario(tfUsuario.getText())){
                try{
                    Cuenta cuenta= FactoryCuenta.createCuenta(tfUsuario.getText(),tfPassword.getText());
                    cuenta.setUrlFoto("/com/example/jmmoto/user.png");
                    cuenta.setEmail(tfEmail.getText());
                    Recepcionista recepcionista = new Recepcionista(tfNombre.getText(),tfApellido.getText(),tfCedula.getText(),String.valueOf(dpFechaNacimiento),cbGenero.getValue(),tfTel.getText(),tfEmail.getText(),cbEstado.getValue(),cbEducacion.getValue(),tfExperienciaLaboral.getText(),Double.parseDouble(tfSalario.getText()),tfHorario.getText(), cuenta);
                    singleton.getSedes().agregarRecepcionista(recepcionista);
                    Alerta.saltarAlertaInformacion("Se ha agregado correctamente");
                    singleton.guardarResourceXML();
                    main.abrirEmpleadosAdmin();
                } catch (Exception e) {
                    Alerta.saltarAlertaError(e.getMessage());
                }
            }
            else{
                Alerta.saltarAlertaError("Este usuario ya existe");
            }
        }
        else{
            Alerta.saltarAlertaError("Hay campos vacíos, mal llenados");
        }
    }

    public void onVolverButtonCLick() throws IOException {
        main.abrirEmpleadosAdmin();
    }

    private boolean isNumber(String text) {
        try{
            Double.parseDouble(text);
        }catch (NumberFormatException e){
            return  false;
        }
        return true;
    }

    private boolean verificarCampos(){
        return
                !tfNombre.getText().isBlank() &&
                !tfApellido.getText().isBlank() &&
                !tfTel.getText().isBlank() &&
                !tfCedula.getText().isBlank() &&
                !tfHorario.getText().isBlank() &&
                !tfSalario.getText().isBlank() &&
                isNumber(tfSalario.getText()) &&
                !tfEmail.getText().isBlank() &&
                !tfUsuario.getText().isBlank() &&
                !tfPassword.getText().isBlank() &&
                !tfExperienciaLaboral.getText().isBlank() &&
                cbGenero.getValue() != null &&
                cbEstado.getValue() != null &&
                dpFechaNacimiento.getValue() != null &&
                cbEducacion.getValue() != null;
    }

    private boolean verificarUsuario(String text) {
        return singleton.getSedes().existUsuario(text);
    }

    @FXML
    void initialize(){
        cbEstado.getItems().addAll("Solter@","Casad@","Viud@","Union Libre");
        cbGenero.getItems().addAll("Masculino","Femenino","No especificar");
        cbEducacion.getItems().addAll("Primaria","basica","media","Pre-grado","Pos-grado");
    }
}
