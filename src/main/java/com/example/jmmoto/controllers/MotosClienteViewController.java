package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.moto.Moto;
import com.example.jmmoto.model.persona.Cliente;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;

public class MotosClienteViewController {
    MainJm mainJm;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    Cliente cliente;
    Moto motoSeleccioanda;
    ObservableList<Moto>motoObservableList = FXCollections.observableArrayList();
    public Hyperlink hlVolver;
    public TableView<Moto> tableMoto;
    public TableColumn<Moto,String> colPlaca;
    public TableColumn<Moto,String>  colMarca;
    public TableColumn<Moto,String>  colModelo;
    public Button btnEliminar;
    public Button btnAgregar;

    public void onVolverLinkClick() throws IOException {
        mainJm.abrirPanelCliente(cliente);
    }

    public void onEliminarButtonClick() {
        if (motoSeleccioanda!=null){
            try {
                cliente.eliminarMoto(motoSeleccioanda);
                tableMoto.refresh();
            }catch (Exception e){
                Alerta.saltarAlertaError(e.getMessage());
            }
        }
    }

    public void onAgregarButtonCLick() throws IOException {
        mainJm.abrirAgregarMotoCliente(cliente);
    }

    public void setMain(MainJm main, Cliente cliente){
        this.mainJm=main;
        this.cliente=cliente;
        fillTable();
    }

    private void fillTable() {
        motoObservableList.setAll(cliente.getMotos());
        tableMoto.setItems(motoObservableList);
    }
    @FXML
    void initialize(){
        colMarca.setCellValueFactory(callData -> new SimpleStringProperty(callData.getValue().getMarca()));
        colModelo.setCellValueFactory(callData -> new SimpleStringProperty(callData.getValue().getModelo()));
        colPlaca.setCellValueFactory(callData -> new SimpleStringProperty(callData.getValue().getPlaca()));
        tableMoto.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)-> motoSeleccioanda = newSelection);
    }

}
