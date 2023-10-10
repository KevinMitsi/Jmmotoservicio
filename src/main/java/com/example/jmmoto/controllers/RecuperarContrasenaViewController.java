package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.persona.Cliente;
import com.example.jmmoto.model.sede.Sede;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RecuperarContrasenaViewController {
    MainJm main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    Sede sede = singleton.getSedes();
    Cliente clienterecuperar;
    public TextField tfPassword;
    public Hyperlink hlRegresar;
    public Label lblText;
    @FXML
    public void onRegresarLink(ActionEvent actionEvent) throws IOException {
        main.inicializarLogin();
    }
    @FXML
    public void onCambiarButtonClick(ActionEvent actionEvent) {
      try{
          verificarContrasena(tfPassword.getText());
          clienterecuperar.getCuenta().setPassword(tfPassword.getText());
          singleton.guardarResourceXML();
          singleton.guardarResourceBinario();
          main.inicializarLogin();
      } catch (Exception e) {
          Alerta.saltarAlertaError(e.getMessage());
      }
    }
    @FXML
    public void setMain(MainJm mainJm, Cliente cliente) {
        this.main=mainJm;
        this.clienterecuperar=cliente;
        lblText.setText("No te preocupes "+ cliente.getNombre()+" Podemos reestablecer tu contraseña ahora mismo");
    }
    private void verificarContrasena(String password) throws Exception {
        boolean hasSpecialChar = false;
        boolean hasDigit = false;
        boolean hasUpperCase = false;

        // Verifica si la contraseña contiene al menos un carácter especial, un número y una letra mayúscula
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUpperCase = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(ch)) {
                hasSpecialChar = true;
            }
        }

        // Lanza una excepción si no cumple con los requisitos
        if (!hasSpecialChar || !hasDigit || !hasUpperCase) {
            throw new Exception("La contraseña debe contener al menos un carácter especial, un número y una letra mayúscula.");
        }
    }
}
