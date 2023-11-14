package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.Factorys.FactoryCuenta;
import com.example.jmmoto.model.cuenta.Cuenta;
import com.example.jmmoto.model.persona.Recepcionista;
import com.example.jmmoto.model.persona.Tecnico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class CrearTecnicoViewController {

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
    public DatePicker dpFechaContratacion;
    public TextField tfExperienciaLaboral;
    public Button btnAgregar;
    public Hyperlink hlVolver;
    public TextField tfPassword;
    public TextField tfUsuario;
    public ComboBox<String> cbRol;
    MainJm mainJm;
    ModelFactoryController singleton = ModelFactoryController.getInstance();

    public void setMain(MainJm mainJm) {
        this.mainJm = mainJm;
    }

    public void onAgregarButtonCLick() {
        if (verificarCampos()){
            if (!verificarUsuario(tfUsuario.getText())){
                try{
                    Cuenta cuenta= FactoryCuenta.createCuenta(tfUsuario.getText(),tfPassword.getText());
                    cuenta.setUrlFoto("/com/example/jmmoto/user.png");
                    cuenta.setEmail(tfEmail.getText());
                    Tecnico tecnico = new Tecnico(tfNombre.getText(),tfApellido.getText(),tfCedula.getText(),String.valueOf(dpFechaNacimiento),cbGenero.getValue(),tfTel.getText(),tfEmail.getText(),cbEstado.getValue(),String.valueOf(dpFechaContratacion.getValue()),tfExperienciaLaboral.getText(),tfHorario.getText(),Double.parseDouble(tfSalario.getText()), cuenta);
                    singleton.getSedes().agregarTecnico(tecnico);
                    Alerta.saltarAlertaInformacion("Se ha agregado correctamente");
                    singleton.guardarResourceXML();
                    mainJm.abrirEmpleadosAdmin();
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

    private boolean verificarUsuario(String text) {
        return singleton.getSedes().existUsuario(text);
    }

    public void onVolverButtonCLick() throws IOException {
        mainJm.abrirEmpleadosAdmin();
    }
    @FXML
    void initialize(){
        cbEstado.getItems().addAll("Solter@","Casad@","Viud@","Union Libre");
        cbGenero.getItems().addAll("Masculino","Femenino","No especificar");
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
        return !tfNombre.getText().isBlank() &&
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
                dpFechaContratacion.getValue() != null;
    }
}
