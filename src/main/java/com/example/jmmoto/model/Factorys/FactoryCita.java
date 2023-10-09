package com.example.jmmoto.model.Factorys;



import com.example.jmmoto.model.cita.Cita;
import com.example.jmmoto.model.persona.Cliente;
import com.example.jmmoto.model.persona.Tecnico;
import com.example.jmmoto.model.productos.Servicio;

import java.io.Serializable;
import java.util.List;

public class FactoryCita implements Serializable {

    public static Cita createCita(Cliente cliente, Tecnico tecnico, List<Servicio> servicios, String fecha, String hora, String estadoCita, String fechaCreacion) {
        return new Cita(cliente, tecnico, servicios, fecha, hora, estadoCita, fechaCreacion);
    }
}
