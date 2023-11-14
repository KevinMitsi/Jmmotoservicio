package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.cita.Cita;
import com.example.jmmoto.model.persona.Recepcionista;
import com.example.jmmoto.model.productos.Servicio;
import com.example.jmmoto.threads.EmailThread;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.util.Objects;

public class FacturaViewController {
    ObservableList<Servicio>serviciosObservable = FXCollections.observableArrayList();
    MainJm mainJm;
    ModelFactoryController singleton=ModelFactoryController.getInstance();
    Recepcionista log;
    Cita select;
    public TableView<Servicio> tableServicios;
    public TableColumn<Servicio,String> colItem;
    public TableColumn<Servicio,Double> colPrecio;

    public void onEnviar() {
        StringBuilder mensaje = new StringBuilder();
        double total = 0;
        for(Servicio servicio : select.getServicios()){
            mensaje.append(" \n").append(servicio.toString());
            total+=servicio.getPrecio();
        }
        try {
            EmailThread emailThread = new EmailThread("Envío de precios a pagar", "Hola! "+select.getCliente().getNombre()+" Esta es tu lista de precios a pagar: " + mensaje + " Para un total de: "+total, select.getCliente().getEmail());
            emailThread.start();
            while (emailThread.isRunning()) {
                Alerta.saltarAlertaAdvertencia("Enviando correo espere");
            }
            Alerta.saltarAlertaInformacion("Enviado");
            if (select.getCliente().getCitas().contains(select)){
                select.getCliente().getCitas().remove(select);
            }
            singleton.getSedes().getCitas().remove(select);
            singleton.guardarResourceXML();
            mainJm.abrirCitasRecep(log);
        }catch (Exception e){
            Alerta.saltarAlertaError(e.getMessage());
        }


    }

    public void oonVolver(ActionEvent event) throws IOException {
        mainJm.abrirCitasRecep(log);
    }
    public void setMain(MainJm main, Recepcionista log, Cita select){
        this.mainJm =main;
        this.log=log;
        this.select=select;
        select.getServicios().removeIf(Objects::isNull);
        serviciosObservable.setAll(select.getServicios());
        tableServicios.setItems(serviciosObservable);
    }

    @FXML
    void initialize(){
        colItem.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getNombre()));
        colPrecio.setCellValueFactory(cellData->new SimpleObjectProperty<>(cellData.getValue().getPrecio()));
    }
}
