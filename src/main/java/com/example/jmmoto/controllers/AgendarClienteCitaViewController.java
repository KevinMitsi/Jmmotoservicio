package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.cita.SolicitudCita;
import com.example.jmmoto.model.moto.Moto;
import com.example.jmmoto.model.persona.Cliente;
import com.example.jmmoto.model.productos.Servicio;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AgendarClienteCitaViewController {
    public ComboBox<Moto> cbOpciones;
    public TableView<String> tableComentarios;
    public TableColumn<String,String> colComentarios;
    public TextField tfComenario;
    List<String>comentarios = new ArrayList<>();
    ObservableList<String>comentariosObservable = FXCollections.observableArrayList();
    MainJm main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    Cliente cliente;
    Servicio servicioSeleccionado;
    public void onCancelarButtonClick() throws IOException {
        main.abrirPanelCliente(cliente);
    }

    public void onAgendarButtonClick() {
        if (cbOpciones.getValue()!=null&&comentarios.size()>0){
            try{
                SolicitudCita solicitudCita = cliente.agendarCita(cbOpciones.getValue(), comentarios);
                if (singleton.getSedes().getSolicitudCitas()==null){
                    singleton.getSedes().setSolicitudCitas(new ArrayList<>());
                }
                singleton.getSedes().getSolicitudCitas().add(solicitudCita);
                Alerta.saltarAlertaInformacion("Se ha enviado correctamente la solicitud, cuando se apruebe podrá ver su cita en el apartado de citas");
                singleton.guardarResourceXML();
                main.abrirPanelCliente(cliente);
            }catch (Exception e) {
               Alerta.saltarAlertaError(e.getMessage());
            }
        }
        else{
            Alerta.saltarAlertaError("Agregue al menos un comentario y seleccione una moto");
        }
    }

    public void agregarMotoClick() throws IOException{
        main.abrirAgregarMotoCliente(cliente, true);
    }

    public void agregarComentarioClick() {
        if(!tfComenario.getText().isBlank()){
            comentarios.add(tfComenario.getText());
            comentariosObservable.add(tfComenario.getText());
            cargarTabla(tfComenario.getText());
            Alerta.saltarAlertaInformacion("Se agregó comentario");
            tfComenario.setText("");
        }
        else{
            Alerta.saltarAlertaError("No ha ingresado ningún comentario");
        }
    }

    public void setMain(MainJm main, Cliente cliente, Servicio servicioSeleccionado){
        this.main = main;
        this.cliente = cliente;
        this.servicioSeleccionado = servicioSeleccionado;
        tableComentarios.getItems().add(servicioSeleccionado.getNombre());
        for(Moto moto: cliente.getMotos()){
            cbOpciones.getItems().add(moto);
        }
    }

    private void cargarTabla(String coment) {
        tableComentarios.getItems().add(coment);
        tableComentarios.refresh();
    }

    @FXML
    void initialize() {
        colComentarios.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));
     }
}
