package com.example.jmmoto.model.Factorys.Interfaces;

import com.example.jmmoto.model.marcamoto.MarcaMoto;

public interface MarcaMotoFactory {
    MarcaMoto createMarcaMoto(String nombre, String paisOrigen, String especializacion, String publicoObjetivo, String sitioweb);
}