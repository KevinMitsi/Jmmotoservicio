package com.example.jmmoto.model.Factorys.Interfaces;

import com.example.jmmoto.model.cita.Cita;
import com.example.jmmoto.model.persona.Cliente;
import com.example.jmmoto.model.persona.Tecnico;
import com.example.jmmoto.model.productos.Servicio;

import java.util.List;

public interface CitaFactory {
    Cita createCita(Cliente cliente, Tecnico tecnico, List<Servicio> servicios, String fecha, String hora, String estadoCita, String fechaCreacion);
}
