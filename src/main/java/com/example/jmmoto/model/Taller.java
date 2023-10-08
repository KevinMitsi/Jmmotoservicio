package com.example.jmmoto.model;

import com.example.jmmoto.model.Factorys.*;
import java.io.Serializable;

public class Taller implements Serializable {
    private FactorySede factorySede;
    private InventarioCreator inventarioCreatorFactory;
    private FactoryCuenta cuentaFactory;
    private FactoryCita citaFactory;
    private FactoryFactura facturaFactory;
    private FactoryHerramienta herramientaFactory;
    private FactoryMarca marcaMotoFactory;
    private FactoryMoto motoFactory;
    private FactoryPersona factoryPersona;
    private FactoryProcedimiento factoryProcedimiento;
    private FactoryProducto factoryProducto;
    private FactoryRedSocial factoryRedSocial;
    private FactoryRol factoryRol;
    private boolean isNew;


    public Taller(){
        
    }

    public FactorySede getFactorySede() {
        return factorySede;
    }

    public void setFactorySede(FactorySede factorySede) {
        this.factorySede = factorySede;
    }

    public InventarioCreator getInventarioCreatorFactory() {
        return inventarioCreatorFactory;
    }

    public void setInventarioCreatorFactory(InventarioCreator inventarioCreatorFactory) {
        this.inventarioCreatorFactory = inventarioCreatorFactory;
    }

    public FactoryCuenta getCuentaFactory() {
        return cuentaFactory;
    }

    public void setCuentaFactory(FactoryCuenta cuentaFactory) {
        this.cuentaFactory = cuentaFactory;
    }

    public FactoryCita getCitaFactory() {
        return citaFactory;
    }

    public void setCitaFactory(FactoryCita citaFactory) {
        this.citaFactory = citaFactory;
    }

    public FactoryFactura getFacturaFactory() {
        return facturaFactory;
    }

    public void setFacturaFactory(FactoryFactura facturaFactory) {
        this.facturaFactory = facturaFactory;
    }

    public FactoryHerramienta getHerramientaFactory() {
        return herramientaFactory;
    }

    public void setHerramientaFactory(FactoryHerramienta herramientaFactory) {
        this.herramientaFactory = herramientaFactory;
    }

    public FactoryMarca getMarcaMotoFactory() {
        return marcaMotoFactory;
    }

    public void setMarcaMotoFactory(FactoryMarca marcaMotoFactory) {
        this.marcaMotoFactory = marcaMotoFactory;
    }

    public FactoryMoto getMotoFactory() {
        return motoFactory;
    }

    public void setMotoFactory(FactoryMoto motoFactory) {
        this.motoFactory = motoFactory;
    }

    public FactoryPersona getFactoryPersona() {
        return factoryPersona;
    }

    public void setFactoryPersona(FactoryPersona factoryPersona) {
        this.factoryPersona = factoryPersona;
    }

    public FactoryProcedimiento getFactoryProcedimiento() {
        return factoryProcedimiento;
    }

    public void setFactoryProcedimiento(FactoryProcedimiento factoryProcedimiento) {
        this.factoryProcedimiento = factoryProcedimiento;
    }

    public FactoryProducto getFactoryProducto() {
        return factoryProducto;
    }

    public void setFactoryProducto(FactoryProducto factoryProducto) {
        this.factoryProducto = factoryProducto;
    }

    public FactoryRedSocial getFactoryRedSocial() {
        return factoryRedSocial;
    }

    public void setFactoryRedSocial(FactoryRedSocial factoryRedSocial) {
        this.factoryRedSocial = factoryRedSocial;
    }

    public FactoryRol getFactoryRol() {
        return factoryRol;
    }

    public void setFactoryRol(FactoryRol factoryRol) {
        this.factoryRol = factoryRol;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }
}