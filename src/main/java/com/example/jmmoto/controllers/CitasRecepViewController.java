package com.example.jmmoto.controllers;
import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.cita.Cita;
import com.example.jmmoto.model.cita.SolicitudCita;
import com.example.jmmoto.model.moto.Moto;
import com.example.jmmoto.model.persona.Recepcionista;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.IOException;

public class CitasRecepViewController {
    public Button btnGenerar;
    public TableColumn<Cita,String> COLeSTADO;
    ObservableList<SolicitudCita>solicitudObservable = FXCollections.observableArrayList();
    ObservableList<Cita>citaObservableList = FXCollections.observableArrayList();
    public Hyperlink hlVolver;
    public Tab tabBSolis;
    public TableView<SolicitudCita> tableSoli;
    public TableColumn<SolicitudCita, String> colFechaSoli;
    public TableColumn<SolicitudCita, Moto> colMotoSoli;
    public Tab tabBCitas;
    public TableView<Cita> tableCitas;
    public TableColumn<Cita,String> colFechaCIta;
    public TableColumn<Cita,String> colHora;
    public TableColumn<Cita,String> colTecnicoCita;
    SolicitudCita solicitudSeleccionada;
    MainJm main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    Recepcionista recepcionista;
    Cita citaSeleccionada;
    public void setMain(MainJm main, Recepcionista recepcionista){
        this.main = main;
        this.recepcionista = recepcionista;
        citaObservableList.setAll(singleton.getSedes().getCitas());
        solicitudObservable.setAll(singleton.getSedes().getSolicitudCitas());

    }
    public void onVolver() throws IOException {
        main.abrirPanelRecepcionista(recepcionista);
    }

    public void onTabBSolis() {
        tableSoli.setItems(solicitudObservable);
        tableSoli.refresh();
    }

    public void onDragSoli() throws IOException {
        if (solicitudSeleccionada!=null){
            main.abrirAgendarCitaRecep(recepcionista,solicitudSeleccionada);
        }
    }

    @FXML
    void initialize(){
        colFechaSoli.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFecha()));
        colMotoSoli.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getMotoCliente()));
        colFechaCIta.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFecha()));
        colTecnicoCita.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTecnico().getNombre()));
        colHora.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getHora()));
        COLeSTADO.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEstadoCita()));

        tableSoli.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)-> solicitudSeleccionada = newSelection);
        tableCitas.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)-> citaSeleccionada = newSelection);

    }

    public void onTabBCitas() {
        tableCitas.setItems(citaObservableList);
        tableCitas.refresh();
    }

    public void onGenrar() throws IOException{
        if (citaSeleccionada!=null&&citaSeleccionada.getEstadoCita().equals("Finalizado")){
            main.abrirCrearFactura(recepcionista,citaSeleccionada);
        }
        else{
            Alerta.saltarAlertaError("Esta cita no está finalizada");
        }
    }

    public void onDragCitas() throws IOException{
        if (citaSeleccionada!=null&&!citaSeleccionada.getEstadoCita().equals("Finalizado")){
            main.expandirCita(recepcionista,citaSeleccionada);
        }
        else{
            Alerta.saltarAlertaError("Esta cita ya está finalizada");
        }
    }
}
