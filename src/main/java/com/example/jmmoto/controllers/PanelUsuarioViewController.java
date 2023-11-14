package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.moto.Moto;
import com.example.jmmoto.model.persona.Cliente;
import com.example.jmmoto.model.productos.Servicio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class PanelUsuarioViewController {
    public ScrollPane scrollPane;
    public ImageView imgPerfil;
    public AnchorPane anchorP;
    MainJm main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    Cliente clienteLogeado;

    @FXML
    private void initialize() {
    }

    @FXML
    public void onProfileImgClick() throws IOException {
        main.inicializarLogin();
    }
    @FXML
    private void onServiciosButtonClick() {
        VBox mainVbox = new VBox();
        mainVbox.setSpacing(10);
        mainVbox.setMaxWidth(anchorP.getPrefWidth());
        for(Servicio servicio: singleton.getSedes().getServicioList()){
            VBox servicioVbox = crearPublicacion(servicio);
            servicioVbox.setSpacing(5);

            mainVbox.getChildren().add(servicioVbox);
        }
        scrollPane.setMaxWidth(anchorP.getPrefWidth());
        scrollPane.setContent(mainVbox);
    }

    private VBox crearPublicacion(Servicio servicio) {
        // Crear elementos de la publicación
        ImageView imageView = new ImageView(imagenServicio(servicio));
        imageView.setFitHeight(100);  // Establecer la altura deseada
        imageView.setPreserveRatio(true);  // Mantener la proporción de la imagen
        Label titleLabel = new Label(servicio.getNombre());
        Text descriptionLabel = new Text(servicio.getEspecificaciones());
        descriptionLabel.setWrappingWidth(anchorP.getPrefWidth()-100);
        Button assignButton = new Button("Asignar cita");
        assignButton.getStyleClass().add("login-button"); // Aplicar estilo al botón
        assignButton.setOnAction(event ->{
            try {
               main.abrirAmpliacionServicio(clienteLogeado,servicio);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        // Crear el panel de la publicación
        VBox publicationPane = new VBox(imageView, titleLabel, descriptionLabel, assignButton);
        publicationPane.getStyleClass().add("publication-pane");
        publicationPane.setMaxWidth(anchorP.getPrefWidth());
        // Crear el panel de la publicación
        return publicationPane;
    }


    // Métodos para manejar otros eventos y funcionalidades, si es necesario

    public void setMain(MainJm mainJm, Cliente cliente) {
        main=mainJm;
        clienteLogeado=cliente;
        ponerImg(clienteLogeado);
    }

    private void ponerImg(Cliente clienteLogeado) {
        String urlFoto = clienteLogeado.getCuenta().getUrlFoto();
        if (urlFoto != null) {
            File file = new File(urlFoto);
            if (file.exists()) {
                Image image = new Image(file.toURI().toString());
                this.imgPerfil.setImage(image);
            } else {
                System.err.println("El archivo de imagen no existe en la ubicación especificada.");
                // Cargar una imagen predeterminada en su lugar
                this.imgPerfil.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/jmmoto/user.png"))));
            }
        } else {
            System.err.println("La URL de la imagen es nula.");
            // Cargar una imagen predeterminada en su lugar
            this.imgPerfil.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/jmmoto/user.png"))));
        }
    }

    public Image imagenServicio(Servicio servicio){
        Image theImage = null;
        String urlFoto = servicio.getRutaImagen();
        if (urlFoto != null) {
            File file = new File(urlFoto);
            if (file.exists()) {
                theImage = new Image(file.toURI().toString());
            } else {
                System.err.println("El archivo de imagen no existe en la ubicación especificada.");
            }
        } else {
            System.err.println("La URL de la imagen es nula.");
            }
        return  theImage;
    }


    public void menuItemCitasClick() throws IOException{
        main.abrirCitasCliente(clienteLogeado);
    }

    public void menuItemMisMotosClick() throws  IOException{
        main.abrirMotosCliente(clienteLogeado);
    }

    public void menuItemAddMotoClick() throws IOException{
        main.abrirAgregarMotoCliente(clienteLogeado, true);
    }
}
