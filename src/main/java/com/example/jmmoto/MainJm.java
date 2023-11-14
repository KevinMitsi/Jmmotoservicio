package com.example.jmmoto;

import com.example.jmmoto.controllers.*;
import com.example.jmmoto.model.cita.Cita;
import com.example.jmmoto.model.cita.SolicitudCita;
import com.example.jmmoto.model.herramienta.Herramienta;
import com.example.jmmoto.model.persona.*;
import com.example.jmmoto.model.productos.Repuesto;
import com.example.jmmoto.model.productos.Servicio;
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
        stage.setTitle("Admin?");
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

    public void abrirServciosAdmin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("serviciosAdmin-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(MainJm.class.getResource("styles.css")).toExternalForm());
        ServiciosAdminViewController controller = fxmlLoader.getController();
        controller.setMain(this);
        stage.setTitle("Tus servicios");
        stage.setScene(scene);
        stage.show();
    }

    public void abrirEmpleadosAdmin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("empleados-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(MainJm.class.getResource("styles.css")).toExternalForm());
        EmpleadosViewController controller = fxmlLoader.getController();
        controller.setMain(this);
        stage.setTitle("Tus servicios");
        stage.setScene(scene);
        stage.show();

    }

    public void abrirClientesAdmin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("empleados-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(MainJm.class.getResource("styles.css")).toExternalForm());
        EmpleadosViewController controller = fxmlLoader.getController();
        controller.setMain(this);
        stage.setTitle("Tus servicios");
        stage.setScene(scene);
        stage.show();


    }

    public void ampliarHerramienta(Herramienta herramientaSeleccionada) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("ampliarHerramienta-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(MainJm.class.getResource("styles.css")).toExternalForm());
        AmpliarHerramientaViewComtroller controller = fxmlLoader.getController();
        controller.setMain(this, herramientaSeleccionada);
        stage.setTitle(herramientaSeleccionada.getNombre());
        stage.setScene(scene);
        stage.show();
    }

    public void abrirAmpliarRepuestoSeleccionado(Repuesto repuestoSeleccionado) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("ampliarRepuesto-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(MainJm.class.getResource("styles.css")).toExternalForm());
        AmpliarRepuestoViewController controller = fxmlLoader.getController();
        controller.setMain(this, repuestoSeleccionado);
        stage.setTitle(repuestoSeleccionado.getNombre());
        stage.setScene(scene);
        stage.show();
    }

    public void abrirAgregarServicio() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("agregarServicio-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(MainJm.class.getResource("styles.css")).toExternalForm());
        AgregarServicioViewController controller = fxmlLoader.getController();
        controller.setMain(this);
        stage.setTitle("Nuevo servicio");
        stage.setScene(scene);
        stage.show();
    }

    public void agregarProducto() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("agregarProducto-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(MainJm.class.getResource("styles.css")).toExternalForm());
        AgregarProductoViewController controller = fxmlLoader.getController();
        controller.setMain(this);
        stage.setTitle("Nuevo producto");
        stage.setScene(scene);
        stage.show();
    }

    public void agregarHerramienta() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("agregarHerramienta-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(MainJm.class.getResource("styles.css")).toExternalForm());
        AgregarHerramientaViewController controller = fxmlLoader.getController();
        controller.setMain(this);
        stage.setTitle("Nuevo producto");
        stage.setScene(scene);
        stage.show();
    }

    public void abrirCrearAnalista() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("abrirCrearAnalista-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(MainJm.class.getResource("styles.css")).toExternalForm());
        AbrirCrearAnalistaViewController controller = fxmlLoader.getController();
        controller.setMain(this);
        stage.setTitle("Nuevo Analista");
        stage.setScene(scene);
        stage.show();
    }

    public void abrirCrearAdminRedesSoc() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("creaeAdminRedesSoc-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(MainJm.class.getResource("styles.css")).toExternalForm());
        CreaeAdminRedesSocViewController controller = fxmlLoader.getController();
        controller.setMain(this);
        stage.setTitle("Nuevo Administrador de Redes Sociales");
        stage.setScene(scene);
        stage.show();
    }

    public void abrirCrearTecnicos() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("crearTecnico-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(MainJm.class.getResource("styles.css")).toExternalForm());
        CrearTecnicoViewController controller = fxmlLoader.getController();
        controller.setMain(this);
        stage.setTitle("Nuevo Tecnico");
        stage.setScene(scene);
        stage.show();
    }

    public void abrirAgregarRecepcionista() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("crearRecepcionista-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(MainJm.class.getResource("styles.css")).toExternalForm());
        CrearRecepcionistaViewController controller = fxmlLoader.getController();
        controller.setMain(this);
        stage.setTitle("Nuevo Recepcionista");
        stage.setScene(scene);
        stage.show();
    }

    public void abrirAmpliacionServicio(Cliente clienteLogeado, Servicio servicio) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("ampliarServicioView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(MainJm.class.getResource("styles.css")).toExternalForm());
        AmpliarServicioRapidoViewController controller = fxmlLoader.getController();
        controller.setMain(this,clienteLogeado,servicio);
        stage.setTitle(servicio.getNombre());
        stage.setScene(scene);
        stage.show();
    }

    public void abrirAgendarCitaCLiente(Cliente clienteLogueado, Servicio servicioSeleccionado) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("agendarClienteCita-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(MainJm.class.getResource("styles.css")).toExternalForm());
        AgendarClienteCitaViewController controller = fxmlLoader.getController();
        controller.setMain(this,clienteLogueado,servicioSeleccionado);
        stage.setTitle("Agendar cita");
        stage.setScene(scene);
        stage.show();
    }

    public void abrirCitasCliente(Cliente clienteLogeado) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("clienteCitas-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(MainJm.class.getResource("styles.css")).toExternalForm());
        ClienteCitasViewController controller = fxmlLoader.getController();
        controller.setMain(this,clienteLogeado);
        stage.setTitle("Tus citas");
        stage.setScene(scene);
        stage.show();
    }

    public void abrirMotosCliente(Cliente clienteLogeado) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("motosCliente-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(MainJm.class.getResource("styles.css")).toExternalForm());
        MotosClienteViewController controller = fxmlLoader.getController();
        controller.setMain(this,clienteLogeado);
        stage.setTitle("Tus motos");
        stage.setScene(scene);
        stage.show();
    }

    public void abrirAgregarMotoCliente(Cliente clienteLogeado, boolean panel) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("agregarMotoCliente-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(MainJm.class.getResource("styles.css")).toExternalForm());
        AgregarMotoClienteViewController controller = fxmlLoader.getController();
        controller.setMain(this,clienteLogeado,panel);
        stage.setTitle("Agregar moto");
        stage.setScene(scene);
        stage.show();
    }

    public void abrirAmpliarSolicitud(SolicitudCita solicitudSeleccionada) throws  IOException{
    }

    public void inicializarLoginRecepcionista() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("loginRView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(MainJm.class.getResource("styles.css")).toExternalForm());
        LoginRViewController controller = fxmlLoader.getController();
        controller.setMain(this);
        stage.setTitle("Bienvenido a Jmmotoservicio");
        stage.setScene(scene);
        stage.show();
    }

    public void abrirPanelRecepcionista(Recepcionista recepcionista) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("recepcionistaPanel-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(MainJm.class.getResource("styles.css")).toExternalForm());
        RecepcionistaPanelViewController controller = fxmlLoader.getController();
        controller.setMain(this,recepcionista);
        stage.setTitle("Bienvenid@ "+ recepcionista.getNombre());
        stage.setScene(scene);
        stage.show();
    }

    public void abrirCitasRecep(Recepcionista recepcionistaLoggged) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("citasRecep-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(MainJm.class.getResource("styles.css")).toExternalForm());
        CitasRecepViewController controller = fxmlLoader.getController();
        controller.setMain(this,recepcionistaLoggged);
        stage.setTitle("Citas");
        stage.setScene(scene);
        stage.show();
    }


    public void abrirAgendarCitaRecep(Recepcionista recepcionista, SolicitudCita solicitudSeleccionada) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("agendarRecep-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(MainJm.class.getResource("styles.css")).toExternalForm());
        AgendarRecepViewController controller = fxmlLoader.getController();
        controller.setMain(this,recepcionista,solicitudSeleccionada);
        stage.setTitle("Citas");
        stage.setScene(scene);
        stage.show();
    }

    public void abrirCrearFactura(Recepcionista recepcionista, Cita citaSeleccionada) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("factura-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(MainJm.class.getResource("styles.css")).toExternalForm());
        FacturaViewController controller = fxmlLoader.getController();
        controller.setMain(this,recepcionista,citaSeleccionada);
        stage.setTitle("Factura");
        stage.setScene(scene);
        stage.show();
    }

    public void expandirCita(Recepcionista recepcionista, Cita citaSeleccionada) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("expandirCita-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(MainJm.class.getResource("styles.css")).toExternalForm());
        ExpandirCitaViewController controller = fxmlLoader.getController();
        controller.setMain(this,recepcionista,citaSeleccionada);
        stage.setTitle("Citas");
        stage.setScene(scene);
        stage.show();

    }
}