package com.example.jmmoto.model.moto;

import java.io.Serializable;
import java.util.Objects;

public class Moto implements Serializable {
    private String id;
    private String placa;
    private String modelo;
    private String anioFabricacion;
    private String numeroChasis;
    private String color;
    private String tipoMotor;
    private String cilindraje;
    private String tipoCombustible;
    private String tipoAceite;
    private String kilometraje;
    private String estado;
    private boolean accesorios;
    private String fechaCompra;

    public Moto(String placa, String modelo, String anioFabricacion, String numeroChasis, String color, String tipoMotor, String cilindraje, String tipoCombustible, String tipoAceite, String kilometraje, String estado, boolean accesorios, String fechaCompra) {
        this.id = String.valueOf(hashCode());
        this.modelo = modelo;
        this.placa = placa;
        this.anioFabricacion = anioFabricacion;
        this.numeroChasis = numeroChasis;
        this.color = color;
        this.tipoMotor = tipoMotor;
        this.cilindraje = cilindraje;
        this.tipoCombustible = tipoCombustible;
        this.tipoAceite = tipoAceite;
        this.kilometraje = kilometraje;
        this.estado = estado;
        this.accesorios = accesorios;
        this.fechaCompra = fechaCompra;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(String anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public String getNumeroChasis() {
        return numeroChasis;
    }

    public void setNumeroChasis(String numeroChasis) {
        this.numeroChasis = numeroChasis;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public String getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public String getTipoAceite() {
        return tipoAceite;
    }

    public void setTipoAceite(String tipoAceite) {
        this.tipoAceite = tipoAceite;
    }

    public String getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(String kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isAccesorios() {
        return accesorios;
    }

    public void setAccesorios(boolean accesorios) {
        this.accesorios = accesorios;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Moto moto)) return false;
        return Objects.equals(getNumeroChasis(), moto.getNumeroChasis());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumeroChasis());
    }
}
