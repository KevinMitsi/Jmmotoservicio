module com.example.jmmoto {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;
    requires java.mail;


    opens com.example.jmmoto to javafx.fxml;
    exports com.example.jmmoto;

    opens com.example.jmmoto.controllers to javafx.fxml;
    exports com.example.jmmoto.controllers;

    exports com.example.jmmoto.model;
    exports com.example.jmmoto.model.Factorys;
    exports com.example.jmmoto.model.persona;
    exports com.example.jmmoto.model.moto;
    exports com.example.jmmoto.model.cita;
    exports com.example.jmmoto.model.factura;
    exports com.example.jmmoto.model.herramienta;
    exports com.example.jmmoto.model.inventario;
    exports com.example.jmmoto.model.marcamoto;
    exports com.example.jmmoto.model.procedimiento;
    exports com.example.jmmoto.model.productos;
    exports com.example.jmmoto.model.redsocial;
    exports com.example.jmmoto.model.Rol;
    exports com.example.jmmoto.model.sede;
    exports com.example.jmmoto.model.cuenta;
    exports com.example.jmmoto.model.Factorys.Interfaces;

}