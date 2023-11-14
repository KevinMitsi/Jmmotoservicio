package com.example.jmmoto.model.Factorys;



import com.example.jmmoto.model.cita.Cita;
import com.example.jmmoto.model.moto.Moto;
import com.example.jmmoto.model.persona.Cliente;
import com.example.jmmoto.model.persona.Tecnico;
import com.example.jmmoto.model.productos.Servicio;

import java.io.Serializable;
import java.util.List;

public class FactoryCita implements Serializable {

    public static Cita createCita(Cliente cliente, List<String>lista,Tecnico tecnico, String fecha, String hora, String estadoCita, String fechaCreacion, Moto moto) {
        return new Cita(cliente, lista,tecnico,  fecha, hora, estadoCita, fechaCreacion, moto);
    }
}
