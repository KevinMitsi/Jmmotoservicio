package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.cuenta.Cuenta;
import com.example.jmmoto.model.persona.Cliente;
import com.example.jmmoto.model.sede.Sede;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginViewController {
    public PasswordField passwordField;
    public TextField usernameField;
    MainJm main;
    ModelFactoryController domain = ModelFactoryController.getInstance();
    Sede sede = domain.getSedes();
    int numIntentosPermitidos=4;

    @FXML
    public void recuperarContrasena() {
        if (usernameField.getText().isBlank()){
            Alerta.saltarAlertaError("No hay ningún nombre");
        }else {

        }
    }
    @FXML
    public void registerButtonClick() throws IOException {
        if (usernameField!=null){
            main.abrirRegister(usernameField.getText());
        }
        else{
            main.abrirRegister(null);
        }
    }

    @FXML
    public void loginButtonAction() {
        String user = usernameField.getText();
        String password = passwordField.getText();
        if (numIntentosPermitidos>0){
            if (verificarDatos(user,password)){
                Cuenta cuenta = new Cuenta(user, password);
                try{
                    Cliente cliente =sede.retornarClienteAsociado(cuenta);
                    main.abrirPanelCliente(cliente);
                } catch (Exception e) {
                    Alerta.saltarAlertaError(e.getMessage());
                    numIntentosPermitidos--;
                    if (numIntentosPermitidos<=2){
                        Alerta.saltarAlertaAdvertencia("Si no recuerda su contraseña recuperela\nde lo contrario la apliación se bloqueará\nNumero de intentos restantes: "+numIntentosPermitidos);
                    }
                }
            }
            else {
                Alerta.saltarAlertaError("Hay campos vacíos");
            }
        }
        else{
            Alerta.saltarAlertaError("La aplicación está bloqueada");
        }
    }


    public void setMain(MainJm mainJm) {
        this.main=mainJm;
    }

    private boolean verificarDatos(String usuario, String password) {
        if (usuario.isBlank()){
            return false;
        }
        if (password.isBlank()){
            return false;
        }
        return true;
    }

}
