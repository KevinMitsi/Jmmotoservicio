package com.example.jmmoto.model.Rol;

import java.util.Objects;

public class Rol {
    private String id;
    private String nombre;
    private String descripcion;
    private String nivelAcceso;
    private String area;
    private String responsabilidadClave;

    public Rol( String nombre, String descripcion, String nivelAcceso, String area, String responsabilidadClave) {
        this.id = String.valueOf(Objects.hash(getNombre(), getNivelAcceso(), getArea()));
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nivelAcceso = nivelAcceso;
        this.area = area;
        this.responsabilidadClave = responsabilidadClave;
    }

    public Rol() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNivelAcceso() {
        return nivelAcceso;
    }

    public void setNivelAcceso(String nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getResponsabilidadClave() {
        return responsabilidadClave;
    }

    public void setResponsabilidadClave(String responsabilidadClave) {
        this.responsabilidadClave = responsabilidadClave;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rol rol)) return false;
        return getNombre().equals(rol.getNombre()) && getNivelAcceso().equals(rol.getNivelAcceso()) && getArea().equals(rol.getArea());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getNivelAcceso(), getArea());
    }
}
