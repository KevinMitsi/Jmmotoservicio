package com.example.jmmoto;

import com.example.jmmoto.controllers.LoginViewController;
import com.example.jmmoto.model.Factorys.FactoryPersona;
import com.example.jmmoto.model.Taller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainJm extends Application {
    Taller taller = new Taller();
    private Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage=stage;
        inicializarLogin();
    }

    private void inicializarLogin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJm.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        LoginViewController controller = fxmlLoader.getController();
        stage.setTitle("Bienvenido a Jmmotoservicio");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}