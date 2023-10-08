package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PrimerPropietarioViewController {
    ModelFactoryController domain = ModelFactoryController.getInstance();
    MainJm main;
    public TextField tfNombre;
    public TextField tfApellido;
    public TextField tfCedula;
    public TextField tfTelefono;
    public TextField tfEmail;
    public DatePicker dpFecha;
    public ComboBox<String> cbGenero;
    public ComboBox<String> cbEstadoCivil;
    public TextField tfUsuario;
    public PasswordField pfPassword;
    public TextField tfRutaArchivo;


    public void handleFileSelect(ActionEvent actionEvent) {
    }

    public void enviarButtonClick(ActionEvent actionEvent) {
    }

    @FXML
    void initialize(){
    }

    public void setMain(MainJm mainJm) {
        this.main=mainJm;
        domain.setNew(false);
    }
    public void realizarAccionesAntesDeCerrar() {
        // Coloca aquí el código que deseas ejecutar antes de que la aplicación se cierre
        System.out.println("Realizando acciones antes de cerrar la aplicación...");
    }

    // Este método se invoca cuando se cierra la ventana principal
    public void ventanaPrincipalCerrada() {
        Platform.runLater(() -> {
            realizarAccionesAntesDeCerrar();
        });
    }
}
