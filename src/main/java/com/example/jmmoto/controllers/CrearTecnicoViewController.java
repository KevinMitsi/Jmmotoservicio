package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;

public class CrearTecnicoViewController {
    MainJm mainJm;
    ModelFactoryController singleton = ModelFactoryController.getInstance();

    public void setMain(MainJm mainJm) {
        this.mainJm = mainJm;
    }
}
