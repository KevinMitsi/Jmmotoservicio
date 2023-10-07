package com.example.jmmoto.controllers;

import com.example.jmmoto.model.Factorys.*;
import com.example.jmmoto.model.Taller;
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
        //Siempre se debe verificar si la raiz del recurso es null
        if(taller == null)
        {
            System.out.println("es null");
            inicializarDatos();
            guardarResourceXML();
            guardarResourceBinario();
        }
        else{
            guardarResourceBinario();
            cargarResourceXML();
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
        taller.setCitaFactory(new FactoryCita());
        taller.setCuentaFactory(new FactoryCuenta());
        taller.setFacturaFactory(new FactoryFactura());
        taller.setHerramientaFactory(new FactoryHerramienta());
        taller.setMarcaMotoFactory(new FactoryMarca());
        taller.setMotoFactory(new FactoryMoto());
        taller.setPersonaFactory(new FactoryPersona());
        taller.setProcedimientoFactory(new FactoryProcedimiento());
        taller.setProductoFactory(new FactoryProducto());
        taller.setRedSocialFactory(new FactoryRedSocial());
        taller.setRolFactory(new FactoryRol());
        taller.setSedeFactory(new FactorySede());
        taller.setInventarioCreatorFactory(new InventarioCreator());

        System.out.println("Domain inicializado "+ taller);
    }



}