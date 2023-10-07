package com.example.jmmoto.model.herramienta;

import java.io.Serializable;
import java.util.Objects;

public class Herramienta implements Serializable {
    private String id;
    private String numeroSerie;
    private String tipo;
    private String marca;
    private String estado;
    private String fechaAdquisicion;
    private boolean disponibilidad;

    public Herramienta(String id, String numeroSerie, String tipo, String marca, String estado, String fechaAdquisicion, boolean disponibilidad) {
        this.id = String.valueOf(Objects.hash(getNumeroSerie()));
        this.numeroSerie = numeroSerie;
        this.tipo = tipo;
        this.marca = marca;
        this.estado = estado;
        this.fechaAdquisicion = fechaAdquisicion;
        this.disponibilidad = disponibilidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(String fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Herramienta that)) return false;
        return Objects.equals(getNumeroSerie(), that.getNumeroSerie());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumeroSerie());
    }
}
