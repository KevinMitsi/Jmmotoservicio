package com.example.jmmoto.model.productos;

import java.io.Serializable;
import java.util.Objects;

public class Servicio extends Producto implements Serializable {
    private String id;
    private String nombre;
    private double precio;
    private String categorias;
    private String especificaciones;
    private String duracion;
    private String estado;
    private String rutaImagen;

    public Servicio(String nombre, double precio, String categorias, String especificaciones, String duracion, String estado, String rutaImagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.categorias = categorias;
        this.especificaciones = especificaciones;
        this.duracion = duracion;
        this.estado = estado;
        this.rutaImagen = rutaImagen;
        this.id = String.valueOf( Objects.hash(getNombre(), getPrecio(), getcategorias()));
    }

    public Servicio() {
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

    public String getcategorias() {
        return categorias;
    }

    public void setcategorias(String categorias) {
        this.categorias = categorias;
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

    public String getCategorias() {
        return categorias;
    }

    public void setCategorias(String categorias) {
        this.categorias = categorias;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Servicio servicio)) return false;
        return Objects.equals(getNombre(), servicio.getNombre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre());
    }

    @Override
    public String toString() {
        return
               nombre + " precio=" + precio;
    }
}
