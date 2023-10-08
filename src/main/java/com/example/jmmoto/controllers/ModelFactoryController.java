package com.example.jmmoto.controllers;

import com.example.jmmoto.MainJm;
import com.example.jmmoto.model.Factorys.*;
import com.example.jmmoto.model.Taller;
import com.example.jmmoto.persistencia.Persistencia;

import java.io.IOException;

public class ModelFactoryController {
    Taller taller;
    MainJm main;

    //Funciones del Domain
    public FactoryCita getFactoryCitas(){
        return taller.getCitaFactory();
    }
    public FactoryCuenta getFactoryCuentas(){
        return taller.getCuentaFactory();
    }
    public FactoryFactura getFactoryFacturas(){
        return taller.getFacturaFactory();
    }
    public FactoryHerramienta getFactoryHerramientas(){
        return taller.getHerramientaFactory();
    }
    public FactoryMarca getFactoryMarcas(){
        return taller.getMarcaMotoFactory();
    }
    public FactoryMoto getFactoryMotos(){
        return taller.getMotoFactory();
    }
    public FactoryPersona getFactoryPersonas(){
        return taller.getFactoryPersona();
    }
    public FactoryProcedimiento getFactoryProcedimientos(){
        return taller.getFactoryProcedimiento();
    }
    public FactoryProducto getFactoryProductos(){
        return taller.getFactoryProducto();
    }
    public FactoryRedSocial getFactoryRedSocial(){
        return taller.getFactoryRedSocial();
    }
    public FactoryRol getFactoryRoles(){
        return taller.getFactoryRol();
    }
    public FactorySede getFactorySedes(){
        return taller.getFactorySede();
    }
    public InventarioCreator getInventario(){
        return taller.getInventarioCreatorFactory();
    }
    public boolean isNew(){
        return taller.isNew();
    }
    public void setNew(boolean value){
        taller.setNew(value);
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



    private void inicializarDatos() throws IOException {
        taller = new Taller();
        taller.setCitaFactory(new FactoryCita());
        taller.setCuentaFactory(new FactoryCuenta());
        taller.setFacturaFactory(new FactoryFactura());
        taller.setHerramientaFactory(new FactoryHerramienta());
        taller.setMarcaMotoFactory(new FactoryMarca());
        taller.setMotoFactory(new FactoryMoto());
        taller.setFactoryPersona(new FactoryPersona());
        taller.setFactoryProcedimiento(new FactoryProcedimiento());
        taller.setFactoryProducto(new FactoryProducto());
        taller.setFactoryRedSocial(new FactoryRedSocial());
        taller.setFactoryRol(new FactoryRol());
        taller.setFactorySede(new FactorySede());
        taller.setInventarioCreatorFactory(new InventarioCreator());
        taller.setNew(false);
        System.out.println("Domain inicializado "+ taller);
    }





}