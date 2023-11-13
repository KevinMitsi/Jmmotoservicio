package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.productos.Servicio;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class AgregarServicioViewController {
    public TextField tfImagePath;
    public Button btnPlus;
    MainJm main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    public Hyperlink hlVolver;
    public TextField tfNombre;
    public TextField tfPrecio;
    public TextField tfCategoria;
    public TextArea taDescripcion;
    public ComboBox<String> cbHoras;
    public Button btnAgregar;

    public void onVolverLinkCLick() throws IOException {
        main.abrirServciosAdmin();
    }

    public void onAgregarButtonCLick() {
        if(verificarCampos()){
            try {
                singleton.getSedes().agregarServicio(new Servicio(tfNombre.getText(), Double.parseDouble(tfPrecio.getText()), tfCategoria.getText(), taDescripcion.getText(), cbHoras.getValue(), "creado", tfImagePath.getText()));
                Alerta.saltarAlertaInformacion("Se ha agregado el servicio correctamente");
                singleton.guardarResourceXML();
                main.abrirServciosAdmin();
            }catch (Exception e){
                Alerta.saltarAlertaError(e.getMessage());
            }
        }
        else {
            Alerta.saltarAlertaError("Hay campos vacíos o mal llenados");
        }
    }

    private boolean verificarCampos() {
        return !tfCategoria.getText().isBlank()
                &&!tfNombre.getText().isBlank()
                &&(!tfPrecio.getText().isBlank()&&isNumber(tfPrecio.getText()))
                &&!taDescripcion.getText().isBlank()
                &&(cbHoras.getValue()!=null)
                &&!tfImagePath.getText().isBlank();
    }

    private boolean isNumber(String text) {
        try{
            Double.parseDouble(text);
        }catch (NumberFormatException e){
            Alerta.saltarAlertaError("No ha ingresado un numero en el campo de precio");
            return false;
            }
        return true;
    }

    public void setMain(MainJm main){
        this.main = main;
    }

    @FXML
    void initialize(){
        for (int i = 0; i < 9; i++) {
            cbHoras.getItems().add(i+" horas");
        }
        cbHoras.getItems().add("más...");

    }

    public void oPlusButtonClick() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos de imagen", "*.jpg", "*.jpeg", "*.png", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            try {
                // Ruta destino en el paquete profilePhotos
                String destino = "src/main/java/com/example/jmmoto/servicesImgs/" + selectedFile.getName();

                // Copiar el archivo seleccionado al paquete profilePhotos
                Files.copy(selectedFile.toPath(), Paths.get(destino), StandardCopyOption.REPLACE_EXISTING);

                // Actualizar el campo tfRutaArchivo con la ruta del archivo
                tfImagePath.setText(destino);
            } catch (IOException e) {
                Alerta.saltarAlertaError("Error al copiar la imagen: " + e.getMessage());
            }
        }
    }
}
