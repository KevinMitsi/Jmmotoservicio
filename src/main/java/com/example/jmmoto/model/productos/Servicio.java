package com.example.jmmoto.model.productos;

import java.util.Objects;

public class Servicio extends Producto{
    private String id;
    private String nombre;
    private double precio;
    private String categorías;
    private String especificaciones;
    private String duracion;
    private String estado;

    public Servicio( String nombre, double precio, String categorías, String especificaciones, String duracion, String estado) {
        this.id = String.valueOf( Objects.hash(getNombre(), getPrecio(), getCategorías()));
        this.nombre = nombre;
        this.precio = precio;
        this.categorías = categorías;
        this.especificaciones = especificaciones;
        this.duracion = duracion;
        this.estado = estado;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategorías() {
        return categorías;
    }

    public void setCategorías(String categorías) {
        this.categorías = categorías;
    }

    public String getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(String especificaciones) {
        this.especificaciones = especificaciones;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Servicio servicio)) return false;
        return Double.compare(servicio.getPrecio(), getPrecio()) == 0 && Objects.equals(getNombre(), servicio.getNombre()) && Objects.equals(getCategorías(), servicio.getCategorías());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getPrecio(), getCategorías());
    }
}
