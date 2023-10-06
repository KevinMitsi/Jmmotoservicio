package com.example.jmmoto.controllers;

import com.example.jmmoto.model.Factorys.FactoryPersona;
import com.example.jmmoto.model.Taller;
import com.example.jmmoto.model.persona.Persona;
import com.example.jmmoto.model.persona.Tecnico;
import com.example.jmmoto.persistencia.Persistencia;

public class ModelFactoryController {
    Taller taller;
    private FactoryPersona factoryPersona;

    public FactoryPersona getFactoryPersona(){
        return this.factoryPersona;
    }

    //------------------------------  Singleton ------------------------------------------------
    // Clase estatica oculta. Tan solo se instanciara el singleton una vez
    private static class SingletonHolder {
        // El constructor de Singleton puede ser llamado desde aqu� al ser protected
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    // M�todo para obtener la instancia de nuestra clase
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {


        guardarResourceBinario();
        cargarResourceXML();


        //Siempre se debe verificar si la raiz del recurso es null
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



    private void inicializarDatos() {
        taller = new Taller();
        System.out.println("Domain inicializado "+ taller);
    }



}