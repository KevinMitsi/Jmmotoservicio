package com.example.jmmoto.model.redsocial;

import java.io.Serializable;
import java.util.Objects;

public class Publicacion implements Serializable {
    private String id;
    private String descripcion;
    private String fecha;
    private String interacciones;


    public Publicacion() {
    }

    public Publicacion(String descripcion, String fecha, String interacciones) {
        this.id = String.valueOf(Objects.hash(getDescripcion(), getFecha()));
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.interacciones = interacciones;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getInteracciones() {
        return interacciones;
    }

    public void setInteracciones(String interacciones) {
        this.interacciones = interacciones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publicacion that)) return false;
        return getDescripcion().equals(that.getDescripcion()) && getFecha().equals(that.getFecha());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescripcion(), getFecha());
    }
}
