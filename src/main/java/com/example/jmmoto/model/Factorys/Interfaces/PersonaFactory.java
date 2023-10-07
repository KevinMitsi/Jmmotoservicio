package com.example.jmmoto.model.Factorys.Interfaces;


import com.example.jmmoto.model.cuenta.Cuenta;
import com.example.jmmoto.model.persona.*;

public interface PersonaFactory {
    Persona createPersona(String nombre, String apellido, String cedula, String fechaNacimiento, String genero, String numeroTelefono, String email, String estadoCivil);
    AdminRedesSoc createAdminRedesSoc(String nombre, String apellido, String cedula, String fechaNacimiento, String genero, String numeroTelefono, String email, String estadoCivil, String fechaContratacion, String numeroSeguidores, String numeroInteracciones, double salario, Cuenta cuenta);
    Analista createAnalista(String nombre, String apellido, String cedula, String fechaNacimiento, String genero, String numeroTelefono, String email, String estadoCivil, double salario, String horario, String experiencia, Cuenta cuenta);
    Cliente createCliente(String nombre, String apellido, String cedula, String fechaNacimiento, String genero, String numeroTelefono, String email, String estadoCivil, String direccion, Cuenta cuenta);
    Propietario createPropietario(String nombre, String apellido, String cedula, String fechaNacimiento, String genero, String numeroTelefono, String email, String estadoCivil);
    Recepcionista createRecepcionista(String nombre, String apellido, String cedula, String fechaNacimiento, String genero, String numeroTelefono, String email, String estadoCivil, String nivelEducacion, String experienciaLaboral, String salario, String horario);
}
