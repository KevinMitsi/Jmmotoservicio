package com.example.jmmoto.controllers;
import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.persona.AdminRedesSoc;
import com.example.jmmoto.model.persona.Analista;
import com.example.jmmoto.model.persona.Recepcionista;
import com.example.jmmoto.model.persona.Tecnico;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.IOException;
import java.util.List;

public class EmpleadosViewController {
    ObservableList<Tecnico>observableListTecnico = FXCollections.observableArrayList();
    ObservableList<Analista>observableListAnalista = FXCollections.observableArrayList();
    ObservableList<AdminRedesSoc>observableListAdminRedes = FXCollections.observableArrayList();
    ObservableList<Recepcionista>observableListRecepcionista = FXCollections.observableArrayList();

    public TabPane myTab;
    public Tab tabButTecnicos;
    public TableView<Tecnico> tableTecnicos;
    public TableColumn<Tecnico,String> colNombreTec;
    public TableColumn<Tecnico,String> colCeduTec;
    public TableColumn<Tecnico,String> colTelefTec;
    public TableColumn<Tecnico,Double> colSalarioTec;
    public Tab tabButtAdminsR;
    public TableView<AdminRedesSoc> tableAdminsR;
    public TableColumn<AdminRedesSoc,String> colNombreAdminR;
    public TableColumn<AdminRedesSoc,String> colCeduAdminR;
    public TableColumn<AdminRedesSoc,String> colTelefAdminR;
    public TableColumn<AdminRedesSoc,Double> colSalarioAdminR;
    public Tab tabButAnalistas;
    public TableView<Analista> tableAnalistas;
    public TableColumn<Analista, String> colNombreAnalist;
    public TableColumn<Analista, String> colCeduAnalist;
    public TableColumn<Analista, String> colTelefAnalist;
    public TableColumn<Analista, Double> colSalarioAnalist;
    public Tab tabButRecepcionistas;
    public TableView<Recepcionista> tableRecepcionistas;
    public TableColumn<Recepcionista, String> colNombreRecep;
    public TableColumn<Recepcionista, String> colCeduRecep;
    public TableColumn<Recepcionista, String> colTelefRecep;
    public TableColumn<Recepcionista, Double> colSalarioRecep;
    public Button btnAgregar;
    public Hyperlink hlBack;
    MainJm main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    Tecnico tecnicoSeleccionado;
    Analista analistaSeleccionado;
    Recepcionista recepcionistaSeleccionado;
    AdminRedesSoc adminRedesSocSeleccionado;

    public void setMain(MainJm mainJm) {
        main=mainJm;
    }
    @FXML
    public void onTabTecnicosChanged() {
        if(tabButTecnicos.isSelected()){
            fillTable(tableTecnicos,observableListTecnico,singleton.getSedes().getTecnicos());
        }
    }

    @FXML
    public void onTabAdminRedesChange() {
        if (tabButtAdminsR.isSelected()){
            fillTable(tableAdminsR,observableListAdminRedes,singleton.getSedes().getAdminRedesSocs());
        }
    }
    @FXML
    public void onTabAnalistasChange() {
        if (tabButAnalistas.isSelected()){
            fillTable(tableAnalistas,observableListAnalista,singleton.getSedes().getAnalistas());
        }
    }

    @FXML
    public void onRecepcionistasChange() {
        if (tabButRecepcionistas.isSelected()){
            fillTable(tableRecepcionistas,observableListRecepcionista,singleton.getSedes().getRecepcionistas());
        }
    }
    @FXML
    public void onNuevoEmpleadoClick() throws IOException {
        if (tabButAnalistas.isSelected()){
            main.abrirCrearAnalista();
        }
        if (tabButtAdminsR.isSelected()){
            main.abrirCrearAdminRedesSoc();
        }
        if (tabButTecnicos.isSelected()){
            main.abrirCrearTecnicos();
        }
        if (tabButRecepcionistas.isSelected()){
            main.abrirAgregarRecepcionista();
        }

    }
    @FXML
    public void onVolverLinkCLick() throws IOException {
        main.abrirPanelAdmin();
    }
    @FXML
    void initialize(){
        colNombreTec.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        colCeduTec.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        colTelefTec.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumeroTelefono()));
        colCeduAdminR.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        colTelefAdminR.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumeroTelefono()));
        colNombreAdminR.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        colNombreAnalist.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        colCeduAnalist.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        colTelefAnalist.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumeroTelefono()));
        colNombreRecep.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        colCeduRecep.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        colTelefRecep.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumeroTelefono()));
        colSalarioTec.setCellValueFactory(cellData-> new SimpleObjectProperty<>(cellData.getValue().getSalario()));
        colSalarioAdminR.setCellValueFactory(cellData-> new SimpleObjectProperty<>(cellData.getValue().getSalario()));
        colSalarioAnalist.setCellValueFactory(cellData-> new SimpleObjectProperty<>(cellData.getValue().getSalario()));
        colSalarioRecep.setCellValueFactory(cellData-> new SimpleObjectProperty<>(cellData.getValue().getSalario()));
        //Selectors
        tableTecnicos.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)-> tecnicoSeleccionado = newSelection);
        tableAdminsR.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)-> adminRedesSocSeleccionado = newSelection);
        tableAnalistas.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)-> analistaSeleccionado = newSelection);
        tableRecepcionistas.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)-> recepcionistaSeleccionado = newSelection);
    }

    private <T> void fillTable(TableView<T> table, ObservableList<T> observableList, List<T> list) {
        observableList.setAll(list);
        table.getItems().setAll(observableList);
    }

}
