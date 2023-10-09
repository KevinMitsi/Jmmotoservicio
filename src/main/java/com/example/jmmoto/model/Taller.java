package com.example.jmmoto.model;

import com.example.jmmoto.model.sede.Sede;

import java.io.Serializable;

public class Taller implements Serializable {

    private boolean isNew;
    private Sede sede;



    public Taller(){
        
    }



    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public Sede getSedes() {
        return sede;
    }

    public void setSedes(Sede sedes) {
        this.sede = sedes;
    }
}