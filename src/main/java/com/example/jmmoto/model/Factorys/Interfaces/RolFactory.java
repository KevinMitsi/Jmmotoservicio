package com.example.jmmoto.model.Factorys.Interfaces;

import com.example.jmmoto.model.Rol.Rol;

public interface RolFactory {
    Rol crearRol(String nombre, String descripcion, String nivelAcceso, String area, String responsabilidadClave);

}