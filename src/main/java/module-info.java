module com.example.jmmoto {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;


    opens com.example.jmmoto to javafx.fxml;
    exports com.example.jmmoto;

    opens com.example.jmmoto.controllers to javafx.fxml;
    exports com.example.jmmoto.controllers;

    exports com.example.jmmoto.model.Factorys;
    exports com.example.jmmoto.model;


}