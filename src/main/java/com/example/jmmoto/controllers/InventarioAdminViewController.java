package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.herramienta.Herramienta;
import com.example.jmmoto.model.productos.Repuesto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class InventarioAdminViewController {
    ObservableList<Herramienta> herramientasObservableList;
    ObservableList<Repuesto> repuestoObservableList;
    Herramienta herramientaSeleccionada;
    Repuesto repuestoSeleccionado;
    public TabPane myTab;
    public Tab tabButHerramientas;
    public TableView<Herramienta> tableHerramientas;
    public TableColumn<Herramienta, String> colIDHerramienta;
    public TableColumn<Herramienta, String> colNombreHerramienta;
    public TableColumn<Herramienta, String> colMarcaHerramienta;
    public Tab tabButtRepuesto;
    public TableView<Repuesto> tableRepuestos;
    public TableColumn<Repuesto, String> colIDRepuesto;
    public TableColumn<Repuesto, String> colNombreRepuesto;
    public TableColumn<Repuesto, String> colNombreMarca;
    public Button btnAgregar;
    public Hyperlink hlBack;
    MainJm main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    public void setMain(MainJm mainJm) {
        this.main = mainJm;
        fillTables();
    }

    private void fillTables() {
        herramientasObservableList = FXCollections.observableArrayList();
        repuestoObservableList = FXCollections.observableArrayList();
        herramientasObservableList.addAll(singleton.getSedes().getInventario().getHerramientas());
        repuestoObservableList.addAll(singleton.getSedes().getInventario().getProductos());
        tableHerramientas.getItems().clear();
        tableRepuestos.getItems().clear();
        tableHerramientas.getItems().addAll(herramientasObservableList);
        tableRepuestos.getItems().addAll(repuestoObservableList);
       }

    public void onDragHerramientaItem(MouseEvent mouseEvent) throws IOException {
        if (herramientaSeleccionada!=null){
            main.ampliarHerramienta(herramientaSeleccionada);
        }
        else{
            Alerta.saltarAlertaError("No ha seleccionado ninguna herramienta para la ampliación");
        }
    }

    public void onDragRepuestoItem(MouseEvent mouseEvent) throws IOException {
        if(repuestoSeleccionado!=null){
            main.abrirAmpliarRepuestoSeleccionado(repuestoSeleccionado);
        }
    }

    public void onAgregarButtonClick(ActionEvent event) throws IOException {
       if (tabButHerramientas.isSelected()){
           main.agregarHerramienta();
       }
       if (tabButtRepuesto.isSelected()){
           main.agregarProducto();
       }

    }

    public void onVolverLinkCLick(ActionEvent event) throws IOException {
        main.abrirPanelAdmin();
    }
    @FXML
    public void initialize(){
        colIDHerramienta.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        colNombreHerramienta.setCellValueFactory(cellDate -> new SimpleStringProperty(cellDate.getValue().getNombre()));
        colMarcaHerramienta.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
        //Table herramienta Selection
        tableHerramientas.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)->{
            herramientaSeleccionada = newSelection;
        });

        //Table repuestos
        colIDRepuesto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        colNombreRepuesto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        colNombreMarca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
        //Table repuesto Selection
        tableRepuestos.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)->{
            repuestoSeleccionado = newSelection;
        });

    }
}
