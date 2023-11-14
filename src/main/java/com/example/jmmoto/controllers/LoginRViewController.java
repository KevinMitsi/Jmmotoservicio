package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.cuenta.Cuenta;
import com.example.jmmoto.model.persona.Cliente;
import com.example.jmmoto.model.persona.Recepcionista;
import com.example.jmmoto.model.sede.Sede;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginRViewController {
    public PasswordField passwordField;
    public TextField usernameField;
    MainJm main;
    ModelFactoryController domain = ModelFactoryController.getInstance();
    Sede sede = domain.getSedes();
    int numIntentosPermitidos =4;


    public void setMain(MainJm mainJm) {
        main = mainJm;
    }
    @FXML
    public void loginButtonAction(){
        String user = usernameField.getText();
        String password = passwordField.getText();
        if (numIntentosPermitidos>0){
                if (verificarDatos(user,password)){
                    Cuenta cuenta = new Cuenta(user, password);
                    try{
                        Recepcionista recepcionista =sede.retornarRecepcionista(cuenta);
                        main.abrirPanelRecepcionista(recepcionista);
                    } catch (Exception e) {
                        Alerta.saltarAlertaError(e.getMessage());
                        numIntentosPermitidos--;
                        if (numIntentosPermitidos<=2){
                            Alerta.saltarAlertaAdvertencia("Si no recuerda su contraseña comuniquese con el administrador\nde lo contrario la apliación se bloqueará\nNumero de intentos restantes: "+numIntentosPermitidos);
                        }
                    }
                }
                else{
                    Alerta.saltarAlertaError("Usuario no registrado");
                }
        }
        else{
            Alerta.saltarAlertaError("La aplicación está bloqueada");
        }
    }
    private boolean verificarDatos(String usuario, String password) {
        return !usuario.isBlank()&&!password.isBlank();
    }

    public void onClienteClick() throws IOException {
        main.inicializarLogin();
    }
}
