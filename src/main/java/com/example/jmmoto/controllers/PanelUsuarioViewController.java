package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.persona.Cliente;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class PanelUsuarioViewController {
    MainJm main;
    Cliente clienteLogeado;
    @FXML
    private Pane contentPane;

    @FXML
    private void initialize() {
        // Inicialización del controlador
    }
    @FXML
    private void onServiciosButtonClick() {
        // Limpiar el contentPane antes de agregar nuevos elementos
        contentPane.getChildren().clear();

        // Crear las publicaciones de servicios
        for (int i = 1; i <= 5; i++) {
            // Crear elementos de la publicación
            ImageView imageView = new ImageView(new Image("ruta_de_la_imagen_" + i + ".png"));
            Label titleLabel = new Label("Título del Servicio " + i);
            Label descriptionLabel = new Label("Descripción del Servicio " + i);
            Button assignButton = new Button("Asignar cita");

            // Crear el panel de la publicación
            VBox publicationPane = new VBox(imageView, titleLabel, descriptionLabel, assignButton);
            publicationPane.getStyleClass().add("publication-pane");

            // Agregar la publicación al contentPane
            contentPane.getChildren().add(publicationPane);
        }
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
    }
}
