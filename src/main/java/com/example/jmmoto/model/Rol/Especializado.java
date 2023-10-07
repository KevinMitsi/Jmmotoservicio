package com.example.jmmoto.model.Rol;

import java.io.Serializable;

public class Especializado extends Capacitado implements Serializable {
    public Especializado() {
    }

    public Especializado(String nombre, String descripcion, String nivelAcceso, String area, String responsabilidadClave) {
        super(nombre, descripcion, nivelAcceso, area, responsabilidadClave);
    }
}
