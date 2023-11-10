package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.herramienta.Herramienta;

public class AmpliarHerramientaViewComtroller {
    MainJm main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    Herramienta herramientaSeleccionada;
    public void setMain(MainJm main, Herramienta herramientaSeleccionada){
        this.main=main;
        this.herramientaSeleccionada = herramientaSeleccionada;
    }
}
