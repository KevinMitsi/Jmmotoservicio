package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.cita.SolicitudCita;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;

public class VistaSolicitudesViewController {
    ObservableList<SolicitudCita>solicitudesObservable = FXCollections.observableArrayList();
    MainJm main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    SolicitudCita solicitudSeleccionada;
    public TableView<SolicitudCita> tableSolicitudes;
    public TableColumn<SolicitudCita,String> colLiente;
    public TableColumn<SolicitudCita,String> colMoto;
    public TableColumn<SolicitudCita,String> colFecha;

    public void onVolverLinkCLick() throws IOException {
        main.abrirPanelAdmin();
    }

    public void onAsignarButtonCLick() throws IOException {
        if (solicitudSeleccionada!=null){
            main.abrirAmpliarSolicitud(solicitudSeleccionada);
        }
        else {
            Alerta.saltarAlertaError("No ha seleccionado ninguna solicitud");
        }
    }

    public void setMain(MainJm main){
        this.main = main;
        solicitudesObservable.setAll(singleton.getSedes().getSolicitudCitas());
        tableSolicitudes.setItems(solicitudesObservable);
    }
    @FXML
    void initialize(){
        colFecha.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getFecha()));
        colMoto.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getMotoCliente().getPlaca()));
        colLiente.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getEmisor().getNombre()));
        tableSolicitudes.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)-> solicitudSeleccionada = newSelection);

    }
}
