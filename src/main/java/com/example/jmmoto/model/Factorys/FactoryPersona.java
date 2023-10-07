package com.example.jmmoto.model.Factorys;

import com.example.jmmoto.model.Factorys.Interfaces.PersonaFactory;
import com.example.jmmoto.model.cuenta.Cuenta;
import com.example.jmmoto.model.persona.*;

import java.io.Serializable;

public class FactoryPersona implements PersonaFactory, Serializable {
    @Override
    public Persona createPersona(String nombre, String apellido, String cedula, String fechaNacimiento, String genero, String numeroTelefono, String email, String estadoCivil) {
        return new Persona(nombre, apellido, cedula, fechaNacimiento, genero, numeroTelefono, email, estadoCivil);
    }

    @Override
    public AdminRedesSoc createAdminRedesSoc(String nombre, String apellido, String cedula, String fechaNacimiento, String genero, String numeroTelefono, String email, String estadoCivil, String fechaContratacion, String numeroSeguidores, String numeroInteracciones, double salario, Cuenta cuenta) {
        return new AdminRedesSoc(nombre, apellido, cedula, fechaNacimiento, genero, numeroTelefono, email, estadoCivil, fechaContratacion, numeroSeguidores, numeroInteracciones, salario,cuenta);
    }

    @Override
    public Analista createAnalista(String nombre, String apellido, String cedula, String fechaNacimiento, String genero, String numeroTelefono, String email, String estadoCivil, double salario, String horario, String experiencia, Cuenta cuenta) {
        return new Analista(nombre, apellido, cedula, fechaNacimiento, genero, numeroTelefono, email, estadoCivil, salario, horario, experiencia, cuenta);
    }

    @Override
    public Cliente createCliente(String nombre, String apellido, String cedula, String fechaNacimiento, String genero, String numeroTelefono, String email, String estadoCivil, String direccion, Cuenta cuenta) {
        return new Cliente(nombre, apellido, cedula, fechaNacimiento, genero, numeroTelefono, email, estadoCivil, direccion, cuenta);
    }

    @Override
    public Propietario createPropietario(String nombre, String apellido, String cedula, String fechaNacimiento, String genero, String numeroTelefono, String email, String estadoCivil) {
        return new Propietario(nombre, apellido, cedula, fechaNacimiento, genero, numeroTelefono, email, estadoCivil);
    }

    @Override
    public Recepcionista createRecepcionista(String nombre, String apellido, String cedula, String fechaNacimiento, String genero, String numeroTelefono, String email, String estadoCivil, String nivelEducacion, String experienciaLaboral, String salario, String horario) {
        return new Recepcionista(nombre, apellido, cedula, fechaNacimiento, genero, numeroTelefono, email, estadoCivil, nivelEducacion, experienciaLaboral, salario, horario);
    }
}

