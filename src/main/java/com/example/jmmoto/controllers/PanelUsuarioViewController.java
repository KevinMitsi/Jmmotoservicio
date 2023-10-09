package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.persona.Cliente;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.IOException;

public class PanelUsuarioViewController {
    public ScrollPane scrollPane;
    public ImageView imgPerfil;
    MainJm main;
    Cliente clienteLogeado;
    @FXML
    private Pane contentPane;

    @FXML
    private void initialize() {

    }

    @FXML
    public void onProfileImgClick(MouseEvent mouseEvent) throws IOException {
        main.inicializarLogin();
    }
    @FXML
    private void onServiciosButtonClick() {
        // Limpiar el contentPane antes de agregar nuevos elementos
        contentPane.getChildren().clear();
        // Ejemplo de cómo crear una publicación personalizada
        String imagenPath1 = "/com/example/jmmoto/kilometraje.png";
        String titulo1 = "Revisión de Kilometraje";
        String descripcion1 = "Descripción personalizada 1";
        VBox publicationPane1 = crearPublicacion(imagenPath1, titulo1, descripcion1);
        contentPane.getChildren().add(publicationPane1);
        String imagenPath2 = "/com/example/jmmoto/mantnimiento.png";
        String titulo2 = "Mantenimiento";
        String descripcion2 = "Descripción personalizada 1";
        VBox publicationPane2 = crearPublicacion(imagenPath2, titulo2, descripcion2);
        contentPane.getChildren().add(publicationPane2);
        String imagenPath3 = "/com/example/jmmoto/peritaje.png";
        String titulo3 = "Peritaje";
        String descripcion3 = "Descripción personalizada 1";
        VBox publicationPane3 = crearPublicacion(imagenPath3, titulo3, descripcion3);
        contentPane.getChildren().add(publicationPane3);
        String imagenPath4 = "/com/example/jmmoto/serviciosRapidos.png";
        String titulo4 = "Revisión de Kilometraje";
        String descripcion4 = "Descripción personalizada 1";
        VBox publicationPane4 = crearPublicacion(imagenPath4, titulo4, descripcion4);
        contentPane.getChildren().add(publicationPane4);

        // Configurar el contenido del ScrollPane
        scrollPane.setMaxSize(400, 400);
        scrollPane.setContent(contentPane);
    }

    private VBox crearPublicacion(String imagenPath, String titulo, String descripcion) {
        // Crear elementos de la publicación
        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream(imagenPath)));
        imageView.setFitHeight(100);  // Establecer la altura deseada
        imageView.setPreserveRatio(true);  // Mantener la proporción de la imagen
        Label titleLabel = new Label(titulo);
        titleLabel.getStyleClass().add("rounded-textfield"); // Aplicar estilo al título

        Label descriptionLabel = new Label(descripcion);
        descriptionLabel.getStyleClass().add("rounded-textfield"); // Aplicar estilo a la descripción

        Button assignButton = new Button("Asignar cita");
        assignButton.getStyleClass().add("login-button"); // Aplicar estilo al botón

        // Crear el panel de la publicación
        VBox publicationPane = new VBox(imageView, titleLabel, descriptionLabel, assignButton);
        publicationPane.getStyleClass().add("publication-pane");
        // Crear el panel de la publicación

        return publicationPane;
    }


    @FXML
    private void onRepuestosButtonClick() {
        // Limpiar el contentPane antes de agregar el mensaje de Repuestos
        contentPane.getChildren().clear();

        // Mostrar el mensaje de Repuestos
        Pane repuestosPane = new Pane();
        Label messageLabel = new Label("Pronto");
        repuestosPane.getChildren().add(messageLabel);
        repuestosPane.getStyleClass().add("repuestos-pane");

        // Agregar el mensaje de Repuestos al contentPane
        contentPane.getChildren().add(repuestosPane);
    }

    // Métodos para manejar otros eventos y funcionalidades, si es necesario

    public void setMain(MainJm mainJm, Cliente cliente) {
        main=mainJm;
        clienteLogeado=cliente;
        ponerImg(clienteLogeado);
    }

    private void ponerImg(Cliente clienteLogeado) {
        String urlFoto = clienteLogeado.getCuenta().getUrlFoto();
        System.out.println("URL de la imagen: " + urlFoto); // Agrega esta línea para depuración

        if (urlFoto != null) {
            File file = new File(urlFoto);
            if (file.exists()) {
                Image image = new Image(file.toURI().toString());
                this.imgPerfil.setImage(image);
            } else {
                System.err.println("El archivo de imagen no existe en la ubicación especificada.");
                // Cargar una imagen predeterminada en su lugar
                this.imgPerfil.setImage(new Image(getClass().getResourceAsStream("/com/example/jmmoto/user.png")));
            }
        } else {
            System.err.println("La URL de la imagen es nula.");
            // Cargar una imagen predeterminada en su lugar
            this.imgPerfil.setImage(new Image(getClass().getResourceAsStream("/com/example/jmmoto/user.png")));
        }
    }


}
