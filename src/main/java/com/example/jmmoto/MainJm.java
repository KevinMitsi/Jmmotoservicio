package com.example.jmmoto;

import com.example.jmmoto.controllers.*;

import com.example.jmmoto.model.persona.Cliente;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainJm extends Application {
    ModelFactoryController domain = ModelFactoryController.getInstance();
    private Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage=stage;
        if (domain.isNew()){
            abrirCrearPrimerPropietario();
        }
        else{
            inicializarLogin();
        }

    }

    public void inicializarLogin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("loginView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(MainJm.class.getResource("styles.css")).toExternalForm());
        LoginViewController controller = fxmlLoader.getController();
        controller.setMain(this);
        stage.setTitle("Bienvenido a Jmmotoservicio");
        stage.setScene(scene);
        stage.show();
    }

    public void abrirCrearPrimerPropietario() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("primerPropietarioView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(MainJm.class.getResource("styles.css")).toExternalForm());
        PrimerPropietarioViewController controller = fxmlLoader.getController();
        controller.setMain(this);
        stage.setTitle("Primera vez");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void abrirRegister(String posibleUser) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("registerView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(MainJm.class.getResource("styles.css")).toExternalForm());
        RegisterViewController controller = fxmlLoader.getController();
        controller.setMain(this, posibleUser);
        stage.setTitle("Registro");
        stage.setScene(scene);
        stage.show();
    }

    public void abrirPanelCliente(Cliente cliente) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("panelUsuarioView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(MainJm.class.getResource("styles.css")).toExternalForm());
        PanelUsuarioViewController controller = fxmlLoader.getController();
        controller.setMain(this,cliente);
        stage.setTitle("Panel cliente");
        stage.setScene(scene);
        stage.show();
    }

    public void abrirRecuperarContrasena(Cliente cliente) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("recuperarContrasenaView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(MainJm.class.getResource("styles.css")).toExternalForm());
        RecuperarContrasenaViewController controller = fxmlLoader.getController();
        controller.setMain(this,cliente);
        stage.setTitle("Recuperar Contraseña");
        stage.setScene(scene);
        stage.show();
    }

    public void abrirAmpliacionServicio(Cliente clienteLogeado, String seleccion) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("ampliarServicioView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(MainJm.class.getResource("styles.css")).toExternalForm());
        AmpliarServicioViewController controller = fxmlLoader.getController();
        controller.setMain(this,clienteLogeado,seleccion);
        stage.setTitle("AMPLIACIÓN DE PRODUCTO");
        stage.setScene(scene);
        stage.show();
    }
}