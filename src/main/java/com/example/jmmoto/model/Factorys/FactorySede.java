package com.example.jmmoto.model.Factorys;



import com.example.jmmoto.model.persona.Propietario;
import com.example.jmmoto.model.sede.Sede;

public class FactorySede {
    public static Sede crearSede(String nombre, String direccion, String telefono, String email, String horario, Propietario propietario) {
        return new Sede(nombre, direccion, telefono, email, horario, propietario);
    }
}
