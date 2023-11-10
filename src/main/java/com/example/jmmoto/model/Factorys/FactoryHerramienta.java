package com.example.jmmoto.model.Factorys;

import com.example.jmmoto.model.herramienta.Herramienta;
import java.io.Serializable;

public class FactoryHerramienta implements Serializable {

    public static Herramienta createHerramienta(String numeroSerie, String nombre, String tipo, String marca, String estado, String fechaAdquisicion, boolean disponibilidad) {
        return new Herramienta(numeroSerie, nombre,tipo, marca, estado, fechaAdquisicion, disponibilidad);
    }
}