package com.example.jmmoto.model;

import com.example.jmmoto.model.Factorys.Interfaces.*;
import com.example.jmmoto.model.Factorys.InventarioCreator;

import java.io.Serializable;


import java.io.Serializable;

public class Taller implements Serializable {
    private SedeFactory sedeFactory;
    private InventarioCreator inventarioCreatorFactory;
    private CuentaFactory cuentaFactory;
    private CitaFactory citaFactory;
    private FacturaFactory facturaFactory;
    private HerramientaFactory herramientaFactory;
    private MarcaMotoFactory marcaMotoFactory;
    private MotoFactory motoFactory;
    private PersonaFactory personaFactory;
    private ProcedimientoFactory procedimientoFactory;
    private ProductoFactory productoFactory;
    private RedSocialFactory redSocialFactory;
    private RolFactory rolFactory;


    public Taller(){
        
    }

    public SedeFactory getSedeFactory() {
        return sedeFactory;
    }

    public void setSedeFactory(SedeFactory sedeFactory) {
        this.sedeFactory = sedeFactory;
    }

    public InventarioCreator getInventarioCreatorFactory() {
        return inventarioCreatorFactory;
    }

    public void setInventarioCreatorFactory(InventarioCreator inventarioCreatorFactory) {
        this.inventarioCreatorFactory = inventarioCreatorFactory;
    }

    public CuentaFactory getCuentaFactory() {
        return cuentaFactory;
    }

    public void setCuentaFactory(CuentaFactory cuentaFactory) {
        this.cuentaFactory = cuentaFactory;
    }

    public CitaFactory getCitaFactory() {
        return citaFactory;
    }

    public void setCitaFactory(CitaFactory citaFactory) {
        this.citaFactory = citaFactory;
    }

    public FacturaFactory getFacturaFactory() {
        return facturaFactory;
    }

    public void setFacturaFactory(FacturaFactory facturaFactory) {
        this.facturaFactory = facturaFactory;
    }

    public HerramientaFactory getHerramientaFactory() {
        return herramientaFactory;
    }

    public void setHerramientaFactory(HerramientaFactory herramientaFactory) {
        this.herramientaFactory = herramientaFactory;
    }

    public MarcaMotoFactory getMarcaMotoFactory() {
        return marcaMotoFactory;
    }

    public void setMarcaMotoFactory(MarcaMotoFactory marcaMotoFactory) {
        this.marcaMotoFactory = marcaMotoFactory;
    }

    public MotoFactory getMotoFactory() {
        return motoFactory;
    }

    public void setMotoFactory(MotoFactory motoFactory) {
        this.motoFactory = motoFactory;
    }

    public PersonaFactory getPersonaFactory() {
        return personaFactory;
    }

    public void setPersonaFactory(PersonaFactory personaFactory) {
        this.personaFactory = personaFactory;
    }

    public ProcedimientoFactory getProcedimientoFactory() {
        return procedimientoFactory;
    }

    public void setProcedimientoFactory(ProcedimientoFactory procedimientoFactory) {
        this.procedimientoFactory = procedimientoFactory;
    }

    public ProductoFactory getProductoFactory() {
        return productoFactory;
    }

    public void setProductoFactory(ProductoFactory productoFactory) {
        this.productoFactory = productoFactory;
    }

    public RedSocialFactory getRedSocialFactory() {
        return redSocialFactory;
    }

    public void setRedSocialFactory(RedSocialFactory redSocialFactory) {
        this.redSocialFactory = redSocialFactory;
    }

    public RolFactory getRolFactory() {
        return rolFactory;
    }

    public void setRolFactory(RolFactory rolFactory) {
        this.rolFactory = rolFactory;
    }
}