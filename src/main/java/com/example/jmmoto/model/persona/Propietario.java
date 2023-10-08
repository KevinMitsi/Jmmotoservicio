package com.example.jmmoto.model.persona;

import com.example.jmmoto.model.Rol.Rol;
import com.example.jmmoto.model.Rol.RolAdministrativo;
import com.example.jmmoto.model.cuenta.Cuenta;

import java.io.Serializable;

public class Propietario extends Persona implements Serializable {
    private Rol rol;
    private Cuenta cuenta;
    public Propietario() {
    }

    public Propietario(String nombre, String apellido, String cedula, String fechaNacimiento, String genero, String numeroTelefono, String email, String estadoCivil) {
        super(nombre, apellido, cedula, fechaNacimiento, genero, numeroTelefono, email, estadoCivil);
        this.rol = new RolAdministrativo("administrativo","propietario del negocio","completo","negocio","manejo del negocio");
        this.cuenta = new Cuenta();
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
