package com.example.jmmoto.model.Factorys;

import com.example.jmmoto.model.herramienta.Herramienta;
import java.io.Serializable;

public class FactoryHerramienta implements Serializable {

    public static Herramienta createHerramienta(String numeroSerie, String tipo, String marca, String estado, String fechaAdquisicion, boolean disponibilidad) {
        return new Herramienta(numeroSerie, tipo, marca, estado, fechaAdquisicion, disponibilidad);
    }
}