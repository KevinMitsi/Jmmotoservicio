package com.example.jmmoto.model.Rol;

import java.io.Serializable;

public class Capacitado extends Rol implements Serializable {
    public Capacitado() {
    }

    public Capacitado(String nombre, String descripcion, String nivelAcceso, String area, String responsabilidadClave) {
        super(nombre, descripcion, nivelAcceso, area, responsabilidadClave);
    }
}
