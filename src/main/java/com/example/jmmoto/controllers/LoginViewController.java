package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.cuenta.Cuenta;
import com.example.jmmoto.model.persona.Cliente;
import com.example.jmmoto.model.sede.Sede;
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
            }catch (NullPointerException e){
                Alerta.saltarAlertaError(e.getMessage());
            } catch (Exception e) {
                throw new RuntimeException(e);
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
                    main.abrirRecuperarContrasena(main,cliente);
                }
                else {
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
    private void enviarMensajeCorreo(Cuenta cuenta) throws Exception {
        // Configuración del servidor de correo electrónico
        String correoEmisor = "kegarrapala.2003@gmail.com"; // Dirección de correo del emisor
        String contrasena = "vjlxcltitkrpobbh"; // Contraseña del correo del emisor
        String correoReceptor = cuenta.getEmail(); // Dirección de correo del receptor
        codigoRecuperacion = String.valueOf((int) (Math.random() * 999));

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Autenticación del emisor
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(correoEmisor, contrasena);
            }
        });

        try {
            // Crear un objeto de mensaje MimeMessage
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoEmisor));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correoReceptor));
            message.setSubject("Solicitud de cambio de contraseña"); // Asunto del correo
            message.setText("Hola usario : "+cuenta.getUsuario()+" "+"\nHemos recibido una solitud de cambio de contraseña el: " + LocalDate.now()+"\nPara cambiar tu constraseña debes colocar el siguiente código como tu clave de aplicación: " + codigoRecuperacion); // Cuerpo del correo

            // Enviar el mensaje
            Transport.send(message);

            // Mensaje enviado con éxito
            Alerta.saltarAlertaConfirmacion("Correo enviado con éxito.");
        } catch (MessagingException e) {
            // Error al enviar el correo
            throw new Exception("Error al enviar el correo: " + e.getMessage());
        }
    }
}
