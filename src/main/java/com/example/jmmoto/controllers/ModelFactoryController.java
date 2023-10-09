package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.Factorys.*;
import com.example.jmmoto.model.Taller;
import com.example.jmmoto.model.persona.Propietario;
import com.example.jmmoto.model.sede.Sede;
import com.example.jmmoto.persistencia.Persistencia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ModelFactoryController {
    Taller taller;
    MainJm main;

    //Funciones del Domain

    public boolean isNew(){
        return taller.isNew();
    }
    public void setNew(boolean value){
        taller.setNew(value);
    }

    public Sede getSedes() {
        return taller.getSedes();
    }

    //------------------------------  Singleton ------------------------------------------------
    // Clase estatica oculta. Tan solo se instanciara el singleton una vez
    private static class SingletonHolder {
        // El constructor de Singleton puede ser llamado desde aqu� al ser protected
        private final static ModelFactoryController eINSTANCE;

        static {
            try {
                eINSTANCE = new ModelFactoryController();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // M�todo para obtener la instancia de nuestra clase
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() throws IOException {
        //Siempre se debe verificar si la raiz del recurso es null
        guardarResourceBinario();
        cargarResourceXML();

        if(taller == null)
        {
            System.out.println("es null");
            inicializarDatos();
            guardarResourceXML();
            guardarResourceBinario();
        }


        //Registrar la accion de incio de sesi�n
        Persistencia.guardaRegistroLog("Inicio de sesion del usuario:pedro", 1, "inicioSesion");


    }


    public void guardarResourceBinario() {

        Persistencia.guardarRecursoDomainBinario(taller);
    }


    public void cargarResourceXML() {

        taller = Persistencia.cargarRecursoDomainXML();
    }


    public void guardarResourceXML() {

        Persistencia.guardarRecursoDomainXML(taller);
    }



    private void inicializarDatos() throws IOException {
        taller = new Taller();
        taller.setNew(false);
        taller.setSedes(FactorySede.createSede("Jmmotoservicio","cra 19 # 11-43","310","jmmotoservicio92@gmail.com","horario",new Propietario()));
        System.out.println("Domain inicializado "+ taller);
    }





}