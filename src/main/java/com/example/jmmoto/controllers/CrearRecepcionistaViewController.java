package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;

public class CrearRecepcionistaViewController {
    MainJm main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();

    public void setMain(MainJm mainJm) {
        this.main = mainJm;
    }
}
