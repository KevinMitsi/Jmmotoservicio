package com.example.jmmoto;

import com.example.jmmoto.controllers.*;
import com.example.jmmoto.model.Factorys.FactoryPersona;
import com.example.jmmoto.model.Factorys.FactorySede;
import com.example.jmmoto.model.Factorys.InventarioCreator;
import com.example.jmmoto.model.Taller;
import com.example.jmmoto.model.persona.Cliente;
import com.example.jmmoto.model.persona.Propietario;
import com.example.jmmoto.model.sede.Sede;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

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
        scene.getStylesheets().add(MainJm.class.getResource("styles.css").toExternalForm());
        LoginViewController controller = fxmlLoader.getController();
        controller.setMain(this);
        stage.setTitle("Bienvenido a Jmmotoservicio");
        stage.setScene(scene);
        stage.show();
    }
    public static void abrirCrearSede() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("primeraSedeView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(MainJm.class.getResource("styles.css").toExternalForm());
    }
    public void abrirCrearPrimerPropietario() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("primerPropietarioView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(MainJm.class.getResource("styles.css").toExternalForm());
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
        scene.getStylesheets().add(MainJm.class.getResource("styles.css").toExternalForm());
        RegisterViewController controller = fxmlLoader.getController();
        controller.setMain(this, posibleUser);
        stage.setTitle("Registro");
        stage.setScene(scene);
        stage.show();
    }

    public void abrirPanelCliente(Cliente cliente) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("panelUsuarioView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(MainJm.class.getResource("styles.css").toExternalForm());
        PanelUsuarioViewController controller = fxmlLoader.getController();
        controller.setMain(this,cliente);
        stage.setTitle("Registro");
        stage.setScene(scene);
        stage.show();
    }
}