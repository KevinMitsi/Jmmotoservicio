module com.example.jmmoto {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.jmmoto to javafx.fxml;
    exports com.example.jmmoto;

    opens com.example.jmmoto.controllers to javafx.fxml;
    exports com.example.jmmoto.controllers;

}