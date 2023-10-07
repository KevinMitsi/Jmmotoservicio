package com.example.jmmoto.model.Factorys.Interfaces;
import com.example.jmmoto.model.persona.Propietario;
import com.example.jmmoto.model.sede.Sede;

public interface SedeFactory {
    Sede createSede(String nombre, String direccion, String telefono, String email, String horario, Propietario propietario);
}