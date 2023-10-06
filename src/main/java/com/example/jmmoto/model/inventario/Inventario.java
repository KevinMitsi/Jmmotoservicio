package com.example.jmmoto.model.inventario;

import com.example.jmmoto.model.herramienta.Herramienta;
import com.example.jmmoto.model.productos.Producto;

import java.util.List;
import java.util.Objects;

public class Inventario {
    private String id;
    private List<Herramienta> herramientas;
    private List<Producto> productos;

    public Inventario(List<Herramienta> herramientas, List<Producto> productos) {
        this.id = String.valueOf(hashCode());
        this.herramientas = herramientas;
        this.productos = productos;
    }

    public Inventario() {
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

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
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
