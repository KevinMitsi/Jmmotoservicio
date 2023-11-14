package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.cita.Cita;
import com.example.jmmoto.model.persona.Recepcionista;
import com.example.jmmoto.model.productos.Servicio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ExpandirCitaViewController {
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    MainJm main;
    Recepcionista log;
    Cita selected;
    int count;
    public ComboBox<String> cbOpciones;
    public TextField tfComentario;
    public ComboBox<Servicio> cbServicios;

    public void setMain(MainJm main, Recepcionista log, Cita cita){
        this.main =main;
        this.log = log;
        this.selected = cita;
        count=cita.getNotasAdmin().size();
    }

    public void onMasClick() {
        if (tfComentario.getText().isBlank()){
            Alerta.saltarAlertaError("Espacio vacío");
        }
        else{
            selected.getNotasAdmin().add(tfComentario.getText());
            Alerta.saltarAlertaInformacion("Comentario añadido");
            singleton.guardarResourceXML();
            tfComentario.setText("");
        }
    }

    public void onCancelar() throws IOException {
        main.abrirCitasRecep(log);
    }

    public void onAplicar() throws IOException {
        if (verificarCampos()){
            if (cbOpciones!=null){
                selected.setEstadoCita(cbOpciones.getValue());
            }
            if (cbServicios!=null){
                selected.getServicios().add(cbServicios.getValue());
            }
            Alerta.saltarAlertaInformacion("Cambios aplicados");
            singleton.guardarResourceXML();
            main.abrirCitasRecep(log);
        }
        else{
            Alerta.saltarAlertaError("No ha realizado ningún cambio");
        }
    }

    private boolean verificarCampos() {
        return cbServicios!=null || cbOpciones!=null || selected.getNotasAdmin().size()!=count;
    }

    @FXML
    void initialize(){
        for(Servicio servicio : singleton.getSedes().getServicioList()){
            cbServicios.getItems().add(servicio);
        }
        cbOpciones.getItems().addAll("Procesando", "Finalizado");
    }
}
