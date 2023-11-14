package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.persona.Recepcionista;

import java.io.IOException;

public class RecepcionistaPanelViewController {
    MainJm main;
    Recepcionista recepcionistaLoggged;
    public void setMain(MainJm mainJm, Recepcionista recepcionista) {
        this.main = mainJm;
        this.recepcionistaLoggged = recepcionista;
    }

    public void onCitasClick() throws IOException {
        main.abrirCitasRecep(recepcionistaLoggged);
    }


    public void onSalirLinkClick() throws IOException {
        main.inicializarLoginRecepcionista();
    }
}
