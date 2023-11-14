package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.cita.Cita;
import com.example.jmmoto.model.cita.SolicitudCita;
import com.example.jmmoto.model.persona.Recepcionista;
import com.example.jmmoto.model.persona.Tecnico;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;

public class AgendarRecepViewController {
    MainJm main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    Recepcionista recepcionistaLogged;
    SolicitudCita solicitudCita;
    public Label lblNombre;
    public Label lblMoto;
    public ComboBox<String> cbTecnico;
    public DatePicker dpFecha;
    public TextField tfHora;
    public  void setMain(MainJm main, Recepcionista log, SolicitudCita solicitudCita){
        this.main = main;
        this.recepcionistaLogged = log;
        this.solicitudCita = solicitudCita;
        lblMoto.setText(solicitudCita.getMotoCliente().getPlaca());
        lblNombre.setText(solicitudCita.getEmisor().getNombre());
    }
    public void onVolver() throws IOException {
        main.abrirCitasRecep(recepcionistaLogged);
    }

    public void onConfirmarCLick() {
        if (verificarCampos()){
            try{
                Tecnico tecnico = retornarTecnico();
                Cita cita = new Cita(solicitudCita.getEmisor(),solicitudCita.getComentarios(),tecnico,String.valueOf(dpFecha.getValue()),tfHora.getText(),"creada",String.valueOf(LocalDate.now()),solicitudCita.getMotoCliente());
                recepcionistaLogged.agendarCita(singleton.getSedes(),cita);
                cita.getCliente().getSolicitudes().remove(solicitudCita);
                singleton.getSedes().getSolicitudCitas().remove(solicitudCita);
                singleton.guardarResourceXML();
                main.abrirCitasRecep(recepcionistaLogged);
            }catch (Exception e){
                Alerta.saltarAlertaError(e.getMessage());
            }
        }
        else{
            Alerta.saltarAlertaError("Campos sin llenar");
        }
    }

    private boolean verificarCampos() {
        return !tfHora.getText().isBlank()
                &&isNumber(tfHora.getText())
                &&cbTecnico.getValue()!=null
                &&dpFecha.getValue()!=null;
    }

    private boolean isNumber(String text) {
        try{
            Float.parseFloat(text);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    private Tecnico retornarTecnico() throws Exception {
        for(Tecnico tecnico: singleton.getSedes().getTecnicos()){
            if (tecnico.getNombre().equals(cbTecnico.getValue())){
                return tecnico;
            }
        }
        throw new Exception("No se encontró el tecnico");
    }

    @FXML
    void initialize(){
        for(Tecnico tecnico:singleton.getSedes().getTecnicos()){
            cbTecnico.getItems().add(tecnico.getNombre());
        }
    }
}
