package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.productos.Servicio;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.ArrayList;

public class ServiciosAdminViewController {
    ObservableList<Servicio>servicioObservableList;
    MainJm main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    Servicio servicioSeleccionado;
    public Hyperlink hlVolver;
    public TableView<Servicio> tableServicios;
    public TableColumn<Servicio, String> colId;
    public TableColumn<Servicio, String> colNombre;
    public TableColumn<Servicio, Double> colPrecio;
    public TableColumn<Servicio, String> colCategoria;
    public Button btnEliminar;
    public Button btnAgregar;

    public void onVolverLinkClick(ActionEvent actionEvent) throws IOException {
        main.abrirPanelAdmin();
    }

    public void onEliminarButtonClick(ActionEvent actionEvent) {
        if (servicioSeleccionado!=null){
            if (Alerta.saltarAlertaConfirmacion("Está apunto de eliminar el servicio seleccionado de su lista","¿Está seguro que quiere eliminar el servicio?") == ButtonType.OK){
                singleton.getSedes().getServicioList().remove(servicioSeleccionado);
                Alerta.saltarAlertaInformacion("Se ha eliminado correctamente el servicio");
                tableServicios.refresh();
            }
        }
        else {
            Alerta.saltarAlertaError("No ha seleccionado ningún servicio");
        }
    }

    public void onAgregarButtonCLick(ActionEvent actionEvent) throws IOException {
        main.abrirAgregarServicio();
    }

    public void setMain(MainJm mainJm) {
        this.main = mainJm;
        fillTable();
    }

    private void fillTable() {
        servicioObservableList = FXCollections.observableArrayList();
        servicioObservableList.addAll(singleton.getSedes().getServicioList());
        tableServicios.getItems().clear();
        tableServicios.getItems().addAll(servicioObservableList);
    }

    @FXML
    void initialize(){
        colId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        colNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        colCategoria.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getcategorias()));
        colPrecio.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getPrecio()));

        tableServicios.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)->{
            servicioSeleccionado = newSelection;
        });
    }
}
