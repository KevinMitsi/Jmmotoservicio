package com.example.jmmoto.model.Factorys;

import com.example.jmmoto.model.Factorys.Interfaces.SedeFactory;
import com.example.jmmoto.model.persona.Propietario;
import com.example.jmmoto.model.sede.Sede;

import java.io.Serializable;
import java.util.ArrayList;

public class FactorySede implements SedeFactory, Serializable {
    @Override
    public Sede createSede(String nombre, String direccion, String telefono, String email, String horario, Propietario propietario) {
        Sede sede = new Sede(nombre, direccion, telefono, email, horario, propietario);
        sede.setAdminRedesSocs(new ArrayList<>());
        sede.setAnalistas(new ArrayList<>());
        sede.setRecepcionistas(new ArrayList<>());
        sede.setProcedimientos(new ArrayList<>());
        sede.setFacturas(new ArrayList<>());
        sede.setMotos(new ArrayList<>());
        sede.setTecnicos(new ArrayList<>());
        sede.setClientes(new ArrayList<>());
        sede.setCitas(new ArrayList<>());
        return sede;
    }
}