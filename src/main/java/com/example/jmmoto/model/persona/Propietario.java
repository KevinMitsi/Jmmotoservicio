package com.example.jmmoto.model.persona;

import com.example.jmmoto.model.Rol.Rol;
import com.example.jmmoto.model.Rol.RolAdministrativo;

import java.io.Serializable;

public class Propietario extends Persona implements Serializable {
    Rol rol;
    public Propietario() {
    }

    public Propietario(String nombre, String apellido, String cedula, String fechaNacimiento, String genero, String numeroTelefono, String email, String estadoCivil) {
        super(nombre, apellido, cedula, fechaNacimiento, genero, numeroTelefono, email, estadoCivil);
        this.rol = new RolAdministrativo("administrativo","propietario del negocio","completo","negocio","manejo del negocio");
    }
}
