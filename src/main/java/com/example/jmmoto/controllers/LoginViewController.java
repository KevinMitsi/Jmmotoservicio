package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.cuenta.Cuenta;
import com.example.jmmoto.model.persona.Cliente;
import com.example.jmmoto.model.sede.Sede;
import com.example.jmmoto.threads.EmailThread;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Properties;

public class LoginViewController {
    public PasswordField passwordField;
    public TextField usernameField;
    MainJm main;
    ModelFactoryController domain = ModelFactoryController.getInstance();
    Sede sede = domain.getSedes();
    private String codigoRecuperacion;
    private String codigoSeguridad;
    int numIntentosPermitidos=4;

    @FXML
    public void recuperarContrasena() {
        if (usernameField.getText().isBlank()){
            Alerta.saltarAlertaError("No hay ningún nombre");
        }else {
            try{
                Cuenta cuenta=sede.intentarRecuperar(usernameField.getText());
                enviarMensajeCorreo(cuenta);
                cuenta.setPassword(codigoRecuperacion);
            } catch (Exception e) {
                Alerta.saltarAlertaError(e.getMessage());
            }
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
    public void loginButtonAction() throws Exception {
        String user = usernameField.getText();
        String password = passwordField.getText();
        if (numIntentosPermitidos>0){
            if (verificarDatos(user,password)){
                Cuenta cuenta = new Cuenta(user, password);
                if (cuenta.getPassword().equals(codigoRecuperacion)){
                    Cliente cliente =sede.retornarClienteAsociado(cuenta);
                    main.abrirRecuperarContrasena(cliente);
                    codigoRecuperacion=null;
                }
                else {
                    try{
                        Cliente cliente =sede.retornarClienteAsociado(cuenta);
                        enviarMensajeCorreoSeguro(cliente.getCuenta());
                        main.abrirInicioSeguro(cliente,)
                        main.abrirPanelCliente(cliente);
                    } catch (Exception e) {
                        Alerta.saltarAlertaError(e.getMessage());
                        numIntentosPermitidos--;
                        if (numIntentosPermitidos<=2){
                            Alerta.saltarAlertaAdvertencia("Si no recuerda su contraseña recuperela\nde lo contrario la apliación se bloqueará\nNumero de intentos restantes: "+numIntentosPermitidos);
                        }
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

    private void enviarMensajeCorreoSeguro(Cuenta cuenta) {
        codigoSeguridad = String.valueOf((int) (Math.random() * 999));
        EmailThread emailThread = new EmailThread("Código de seguridad","Hola usario : "+cuenta.getUsuario()+" "+"\nHemos recibido una solitud de inicisio de sesion el: " + LocalDate.now()+"\nPara poder ingresar debes colocar el siguiente código en el campos de la aplicación: " + codigoSeguridad,cuenta.getEmail());
        emailThread.start();
        while (emailThread.isRunning()){
            Alerta.saltarAlertaInformacion("Se está enviando correo electrónico");
        }
    }


    public void setMain(MainJm mainJm) {
        this.main=mainJm;
    }

    private boolean verificarDatos(String usuario, String password) {
        return !usuario.isBlank()&&!password.isBlank();
    }
    private void enviarMensajeCorreo(Cuenta cuenta) throws Exception {
        codigoRecuperacion = String.valueOf((int) (Math.random() * 999));
        EmailThread emailThread = new EmailThread("Solicitud de cambio de contraseña","Hola usario : "+cuenta.getUsuario()+" "+"\nHemos recibido una solitud de cambio de contraseña el: " + LocalDate.now()+"\nPara cambiar tu constraseña debes colocar el siguiente código como tu clave de aplicación: " + codigoRecuperacion,cuenta.getEmail());
        emailThread.start();
        while (emailThread.isRunning()){
            Alerta.saltarAlertaInformacion("Se está enviando correo electrónico");
        }
    }
}
