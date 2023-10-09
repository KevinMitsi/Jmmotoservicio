package com.example.jmmoto.model.Factorys;
import com.example.jmmoto.model.Rol.*;

import java.io.Serializable;

public class FactoryRol implements Serializable {

    public static Rol crearRol(String nombre, String descripcion, String nivelAcceso, String area, String responsabilidadClave) {
        return new Rol(nombre, descripcion, nivelAcceso, area, responsabilidadClave);
    }

    public static Rol crearRolAdministrativo(String nombre, String descripcion, String nivelAcceso, String area, String responsabilidadClave) {
        return new RolAdministrativo(nombre, descripcion, nivelAcceso, area, responsabilidadClave);
    }

    public static Rol crearCapacitado(String nombre, String descripcion, String nivelAcceso, String area, String responsabilidadClave) {
        return new Capacitado(nombre, descripcion, nivelAcceso, area, responsabilidadClave);
    }

    public static Rol crearEspecializado(String nombre, String descripcion, String nivelAcceso, String area, String responsabilidadClave) {
        return new Especializado(nombre, descripcion, nivelAcceso, area, responsabilidadClave);
    }

    public static Rol crearAutorizado(String nombre, String descripcion, String nivelAcceso, String area, String responsabilidadClave) {
        return new Autorizado(nombre, descripcion, nivelAcceso, area, responsabilidadClave);
    }
}