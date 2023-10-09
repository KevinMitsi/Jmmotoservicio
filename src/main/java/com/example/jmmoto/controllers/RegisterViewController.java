package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.Factorys.FactoryCuenta;
import com.example.jmmoto.model.Factorys.FactoryPersona;
import com.example.jmmoto.model.cuenta.Cuenta;
import com.example.jmmoto.model.persona.Cliente;
import com.example.jmmoto.model.sede.Sede;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.Properties;


public class RegisterViewController {
    MainJm main;
    ModelFactoryController domai = ModelFactoryController.getInstance();
    Sede sede = domai.getSedes();
    String posibleUSer;
    public TextField tfNombre;
    public TextField tfApellido;
    public TextField tfCedula;
    public TextField tfTelefono;
    public TextField tfEmail;
    public TextField tfDireccion;
    public DatePicker dpFecha;
    public ComboBox<String> cbGenero;
    public ComboBox<String> cbEstadoCivil;
    public TextField tfUsuario;
    public PasswordField pfPassword;
    public TextField tfRutaArchivo;

    public void handleFileSelect(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos de imagen", "*.jpg", "*.jpeg", "*.png", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            try {
                // Ruta destino en el paquete profilePhotos
                String destino = "src/main/java/com/example/jmmoto/profilePhotos/" + selectedFile.getName();

                // Copiar el archivo seleccionado al paquete profilePhotos
                Files.copy(selectedFile.toPath(), Paths.get(destino), StandardCopyOption.REPLACE_EXISTING);

                // Actualizar el campo tfRutaArchivo con la ruta del archivo
                tfRutaArchivo.setText(destino);
            } catch (IOException e) {
                Alerta.saltarAlertaError("Error al copiar la imagen: " + e.getMessage());
            }
        }
    }

    public void enviarButtonClick(ActionEvent actionEvent) throws Exception {
        try{
            verificarCampos();
            enviarMensajeCorreo();
            Cuenta cuenta= FactoryCuenta.createCuenta(tfUsuario.getText(),pfPassword.getText());
            cuenta.setUrlFoto(tfRutaArchivo.getText());
            cuenta.setEmail(tfEmail.getText());
            Cliente cliente= FactoryPersona.createCliente(tfNombre.getText(),tfApellido.getText(),tfCedula.getText(),String.valueOf(dpFecha.getValue()),cbGenero.getValue(),tfTelefono.getText(),tfEmail.getText(),cbEstadoCivil.getValue(),tfDireccion.getText(),cuenta);
            sede.agregarCiente(cliente);
            domai.guardarResourceXML();
            domai.guardarResourceBinario();
            main.inicializarLogin();

        } catch (Exception e) {
            Alerta.saltarAlertaError(e.getMessage());
        }
    }

    private void enviarMensajeCorreo() throws Exception {
        // Configuración del servidor de correo electrónico
        String correoEmisor = "kegarrapala.2003@gmail.com"; // Dirección de correo del emisor
        String contrasena = "vjlxcltitkrpobbh"; // Contraseña del correo del emisor
        String correoReceptor = tfEmail.getText(); // Dirección de correo del receptor

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
            message.setSubject("Beinvenido/a a Jmmotoservicios"); // Asunto del correo
            message.setText("Bienvenido a nuesra aplicación: "+tfNombre.getText()+" "+tfApellido.getText()+"\nes un placer para nosotros comentarte que te has registrado en nuestra apliación el: " + LocalDate.now()); // Cuerpo del correo

            // Enviar el mensaje
            Transport.send(message);

            // Mensaje enviado con éxito
            Alerta.saltarAlertaConfirmacion("Correo enviado con éxito.");
        } catch (MessagingException e) {
            // Error al enviar el correo
            throw new Exception("Error al enviar el correo: " + e.getMessage());
        }
    }

    private void verificarCampos() throws Exception {
        if (tfNombre.getText().isBlank()){
            throw new Exception("El nombre no puede ser vacío");
        }
        if (tfApellido.getText().isBlank()){
            throw new Exception("El apellido no puede ser vacío");
        }
        if (tfCedula.getText().isBlank()){
            throw new Exception("La cedula no puede ser vacío");
        }
        if (tfEmail.getText().isBlank()){
            throw new Exception("El email no puede ser vacío");
        }
        if (tfRutaArchivo.getText().isBlank()){
            throw new Exception("La foto no puede ser vacío");
        }
        if (tfUsuario.getText().isBlank()){
            throw new Exception("El usuario no puede ser vacío");
        }
        if (dpFecha.getValue()==null){
            throw new Exception("La fecha no puede ser vacía");
        }
        if (cbGenero.getValue()==null){
            throw new Exception("El genero no puede ser null");
        }
        if (cbEstadoCivil.getValue()==null){
            throw new Exception("Seleccione un estado civil");
        }
        verificarContrasena(pfPassword.getText());
        verificarUsuario(tfUsuario.getText());
    }

    private void verificarUsuario(String text) throws Exception {
        if (sede.existUsuario(text)){
            throw new Exception("Usuario ya registrado");
        }
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

    public void setMain(MainJm mainJm, String posibleUser) {
        this.main=mainJm;
        this.posibleUSer=posibleUser;
        tfUsuario.setText(posibleUser);
    }
    @FXML
    void initialize(){
        cbEstadoCivil.getItems().add("Soltero/a");
        cbEstadoCivil.getItems().add("Casado/a");
        cbEstadoCivil.getItems().add("Viudo/a");
        cbEstadoCivil.getItems().add("Union libre");
        cbGenero.getItems().add("Masculino");
        cbGenero.getItems().add("Femenino");
        cbGenero.getItems().add("Prefiero no especificarlo");
    }
}
