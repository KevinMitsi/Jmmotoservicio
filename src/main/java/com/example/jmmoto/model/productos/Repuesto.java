package com.example.jmmoto.model.productos;

import java.io.Serializable;

public class Repuesto extends Producto implements Serializable {
    private String id;
    private String nombre;
    private String codigoSav;
    private String categoria;
    private String descripcion;
    private String marca;
    private double precioCompra;
    private double precioVenta;
    private String fechaCompra;
    private String fechaVenta;
    private String disponibilidad;

    public Repuesto(String id, String nombre, String codigoSav, String categoria, String descripcion, String marca, double precioCompra, double precioVenta, String fechaCompra, String disponibilidad) {
        this.id = id;
        this.nombre = nombre;
        this.codigoSav = codigoSav;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.marca = marca;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.fechaCompra = fechaCompra;
        this.fechaVenta = null;
        this.disponibilidad = disponibilidad;
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

    public String getCodigoSav() {
        return codigoSav;
    }

    public void setCodigoSav(String codigoSav) {
        this.codigoSav = codigoSav;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
