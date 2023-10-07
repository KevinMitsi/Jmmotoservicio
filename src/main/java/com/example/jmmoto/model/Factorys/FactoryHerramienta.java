package com.example.jmmoto.model.Factorys;

import com.example.jmmoto.model.Factorys.Interfaces.HerramientaFactory;
import com.example.jmmoto.model.herramienta.Herramienta;
import java.io.Serializable;

public class FactoryHerramienta implements HerramientaFactory, Serializable {
    @Override
    public Herramienta createHerramienta(String numeroSerie, String tipo, String marca, String estado, String fechaAdquisicion, boolean disponibilidad) {
        return new Herramienta(numeroSerie, tipo, marca, estado, fechaAdquisicion, disponibilidad);
    }
}