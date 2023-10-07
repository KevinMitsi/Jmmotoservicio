package com.example.jmmoto.model.Factorys.Interfaces;
import com.example.jmmoto.model.herramienta.Herramienta;

public interface HerramientaFactory {
    Herramienta createHerramienta(String numeroSerie, String tipo, String marca, String estado, String fechaAdquisicion, boolean disponibilidad);
}