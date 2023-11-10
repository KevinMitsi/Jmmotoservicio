package com.example.jmmoto.model.inventario;

import com.example.jmmoto.model.herramienta.Herramienta;
import com.example.jmmoto.model.productos.Producto;
import com.example.jmmoto.model.productos.Repuesto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Inventario implements Serializable{
    private String id;
    private List<Herramienta> herramientas;
    private List<Repuesto> productos;

    public Inventario() {
        this.id = String.valueOf(hashCode());
        this.herramientas = new ArrayList<>();
        this.productos = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Herramienta> getHerramientas() {
        return herramientas;
    }

    public void setHerramientas(List<Herramienta> herramientas) {
        this.herramientas = herramientas;
    }

    public List<Repuesto> getProductos() {
        return productos;
    }

    public void setProductos(List<Repuesto> productos) {
        this.productos = productos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Inventario that)) return false;
        return Objects.equals(getHerramientas(), that.getHerramientas()) && Objects.equals(getProductos(), that.getProductos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHerramientas(), getProductos());
    }
}
