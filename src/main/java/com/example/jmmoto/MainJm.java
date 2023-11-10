package com.example.jmmoto;

import com.example.jmmoto.controllers.*;

import com.example.jmmoto.model.herramienta.Herramienta;
import com.example.jmmoto.model.persona.Cliente;
import com.example.jmmoto.model.productos.Repuesto;
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

    public void abrirAmpliacionServicioMantenimiento(Cliente clienteLogeado) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("ampliarMantenimientoView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(MainJm.class.getResource("styles.css")).toExternalForm());
        AmpliarMantenimientoViewController controller = fxmlLoader.getController();
        controller.setMain(this,clienteLogeado);
        stage.setTitle("AMPLIACIÓN DE PRODUCTO");
        stage.setScene(scene);
        stage.show();
    }

    public void abrirAmpliacionServicioRevision(Cliente clienteLogeado) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("ampliarRevisionView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(MainJm.class.getResource("styles.css")).toExternalForm());
        AmpliarRevisionViewController controller = fxmlLoader.getController();
        controller.setMain(this,clienteLogeado);
        stage.setTitle("AMPLIACIÓN DE PRODUCTO");
        stage.setScene(scene);
        stage.show();
    }

    public void abrirAmpliacionServicioPeritaje(Cliente clienteLogeado) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("ampliarPeritajeView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(MainJm.class.getResource("styles.css")).toExternalForm());
        AmpliarPeritajeViewController controller = fxmlLoader.getController();
        controller.setMain(this,clienteLogeado);
        stage.setTitle("AMPLIACIÓN DE PRODUCTO");
        stage.setScene(scene);
        stage.show();
    }

    public void abrirAmpliacionServicioRapido(Cliente clienteLogeado) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("ampliarServicioRapidoView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(MainJm.class.getResource("styles.css")).toExternalForm());
        AmpliarServicioRapidoViewController controller = fxmlLoader.getController();
        controller.setMain(this,clienteLogeado);
        stage.setTitle("AMPLIACIÓN DE PRODUCTO");
        stage.setScene(scene);
        stage.show();
    }

    public void abrirInicioSeguro(Cliente cliente, String codigoSeguridad) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("inicioSeguro-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(MainJm.class.getResource("styles.css")).toExternalForm());
        InicioSeguroViewController controller = fxmlLoader.getController();
        controller.setMain(this,cliente,codigoSeguridad);
        stage.setTitle("Inicio Seguro");
        stage.setScene(scene);
        stage.show();
    }

    public void abrirIntentoAdmin(String productKey) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("intentoAdmin-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(MainJm.class.getResource("styles.css")).toExternalForm());
        IntentoAdminViewController controller = fxmlLoader.getController();
        controller.setMain(this, productKey);
        stage.setTitle("Admin");
        stage.setScene(scene);
        stage.show();
    }

    public void abrirPanelAdmin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("adminPanel-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(MainJm.class.getResource("styles.css")).toExternalForm());
        AdminPanelViewController controller = fxmlLoader.getController();
        controller.setMain(this);
        stage.setTitle("Admin");
        stage.setScene(scene);
        stage.show();
    }

    public void abrirInventarioAdmin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("inventarioAdmin-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(MainJm.class.getResource("styles.css")).toExternalForm());
        InventarioAdminViewController controller = fxmlLoader.getController();
        controller.setMain(this);
        stage.setTitle("Tu inventario");
        stage.setScene(scene);
        stage.show();
    }

    public void abrirServciosAdmin() {
    }

    public void abrirEmpleadosAdmin() {
    }

    public void abrirClientesAdmin() {
    }

    public void ampliarHerramienta(Herramienta herramientaSeleccionada) {
    }

    public void abrirAmpliarRepuestoSeleccionado(Repuesto repuestoSeleccionado) {
    }
}