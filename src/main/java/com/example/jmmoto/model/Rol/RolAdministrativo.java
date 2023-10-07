package com.example.jmmoto.model.Rol;

import java.io.Serializable;

public class RolAdministrativo extends Rol implements Serializable {
    public RolAdministrativo(){}

    public RolAdministrativo(String nombre, String descripcion,
                             String nivelAcceso, String area, String responsabilidadClave) {
        super(nombre, descripcion, nivelAcceso, area, responsabilidadClave);
    }

}
