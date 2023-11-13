package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.cita.Cita;
import com.example.jmmoto.model.cita.SolicitudCita;
import com.example.jmmoto.model.moto.Moto;
import com.example.jmmoto.model.persona.Cliente;
import com.example.jmmoto.model.persona.Tecnico;
import com.example.jmmoto.model.productos.Servicio;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClienteCitasViewController {
    ObservableList<SolicitudCita>solicitudCitaObservableList = FXCollections.observableArrayList();
    ObservableList<Cita>citaObservableList = FXCollections.observableArrayList();

    public Hyperlink hlVolver;
    public TableView<Cita> tableCitas;
    public TableColumn<Cita, String> colFechaCIta;
    public TableColumn<Servicio, String> colServicioCita;
    public TableColumn<Moto, String> colMotoCita;
    public TableColumn<Tecnico, String> colTecnicoCita;
    public TableView<SolicitudCita> tableSoli;
    public TableColumn<SolicitudCita, String> colFechaSoli;
    public TableColumn<Moto,String> colMotoSoli;
    public TableColumn<Servicio, String> colServicioSoli;
    public Tab tabBCitas;
    public Tab tabBSolis;
    Cliente clienteLogeado;
    MainJm main;

    public void onVolver() throws IOException {
        main.abrirPanelCliente(clienteLogeado);
    }

    public void onTabBCitas() {
        if (tabBCitas.isSelected()){
            if (clienteLogeado.getCitas()==null){
                clienteLogeado.setCitas(new ArrayList<>());
            }
            fillTable(tableCitas,citaObservableList,clienteLogeado.getCitas());
        }
    }

    public void onTabBSolis() {
        if (tabBCitas.isSelected()){
            if (clienteLogeado.getSolicitudes()==null){
                clienteLogeado.setSolicitudes(new ArrayList<>());
            }
            fillTable(tableSoli,solicitudCitaObservableList,clienteLogeado.getSolicitudes());
        }
    }

    public void setMain(MainJm main, Cliente clienteLogeado){
        this.main = main;
        this.clienteLogeado=clienteLogeado;
    }

    @FXML
    void initialize(){
        colFechaCIta.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFecha()));
        colFechaSoli.setCellValueFactory(cellData ->new SimpleStringProperty(cellData.getValue().getFecha()));
        colMotoCita.setCellValueFactory(cellData ->new SimpleStringProperty(cellData.getValue().getPlaca()));
        colMotoSoli.setCellValueFactory(cellData ->new SimpleStringProperty(cellData.getValue().getPlaca()));
        colServicioCita.setCellValueFactory(cellData ->new SimpleStringProperty(cellData.getValue().getNombre()));
        colServicioSoli.setCellValueFactory(cellData ->new SimpleStringProperty(cellData.getValue().getNombre()));
        colTecnicoCita.setCellValueFactory(cellData ->new SimpleStringProperty(cellData.getValue().getNombre()));
    }

    private <T> void fillTable(TableView<T> table, ObservableList<T> observableList, List<T> list) {
        observableList.setAll(list);
        table.getItems().setAll(observableList);
    }
}
