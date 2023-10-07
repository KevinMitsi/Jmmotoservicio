package com.example.jmmoto.model.Factorys;
import com.example.jmmoto.model.Factorys.Interfaces.RolFactory;
import com.example.jmmoto.model.Rol.*;

import java.io.Serializable;

public class FactoryRol implements RolFactory, Serializable {

    @Override
    public Rol crearRol(String nombre, String descripcion, String nivelAcceso, String area, String responsabilidadClave) {
        return new Rol(nombre, descripcion, nivelAcceso, area, responsabilidadClave);
    }

    public Rol crearRolAdministrativo(String nombre, String descripcion, String nivelAcceso, String area, String responsabilidadClave) {
        return new RolAdministrativo(nombre, descripcion, nivelAcceso, area, responsabilidadClave);
    }

    public Rol crearCapacitado(String nombre, String descripcion, String nivelAcceso, String area, String responsabilidadClave) {
        return new Capacitado(nombre, descripcion, nivelAcceso, area, responsabilidadClave);
    }

    public Rol crearEspecializado(String nombre, String descripcion, String nivelAcceso, String area, String responsabilidadClave) {
        return new Especializado(nombre, descripcion, nivelAcceso, area, responsabilidadClave);
    }

    public Rol crearAutorizado(String nombre, String descripcion, String nivelAcceso, String area, String responsabilidadClave) {
        return new Autorizado(nombre, descripcion, nivelAcceso, area, responsabilidadClave);
    }
}