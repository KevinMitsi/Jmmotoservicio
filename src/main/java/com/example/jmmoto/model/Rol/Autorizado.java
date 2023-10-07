package com.example.jmmoto.model.Rol;

import java.io.Serializable;

public class Autorizado extends Capacitado implements Serializable {

    public Autorizado(String nombre, String descripcion, String nivelAcceso, String area, String responsabilidadClave) {
        super(nombre, descripcion, nivelAcceso, area, responsabilidadClave);
    }

    public Autorizado() {
    }
}
