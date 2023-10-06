package com.example.jmmoto.model.Rol;

public class RolAdministrativo extends Rol{
    public RolAdministrativo(){}

    public RolAdministrativo(String nombre, String descripcion,
                             String nivelAcceso, String area, String responsabilidadClave) {
        super(nombre, descripcion, nivelAcceso, area, responsabilidadClave);
    }

}
