package com.example.jmmoto.model.Factorys;

import com.example.jmmoto.model.persona.Persona;
import com.example.jmmoto.model.persona.Tecnico;

public class FactoryPersona {
    public static Persona crearPersona(String tipo, String nombre, String apellido, String cedula, String fechaNacimiento, String genero, String numeroTelefono, String email, String estadoCivil, String id, String fechaContratacion, String experienciaLaboral, String horarioTrabajo, double salario, String estadoEmpleo) {
        if ("Tecnico".equalsIgnoreCase(tipo)) {
            return new Tecnico(nombre, apellido, cedula, fechaNacimiento, genero, numeroTelefono, email, estadoCivil, id, fechaContratacion, experienciaLaboral, horarioTrabajo, salario, estadoEmpleo);
        }
        else {
            // Create and return a generic Persona object for other types
            return new Persona(nombre, apellido, cedula, fechaNacimiento, genero, numeroTelefono, email, estadoCivil);
        }
    }
}

