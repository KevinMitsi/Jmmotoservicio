package com.example.jmmoto.model.Factorys;
import com.example.jmmoto.model.productos.Repuesto;
import com.example.jmmoto.model.productos.Servicio;

import java.io.Serializable;

public class FactoryProducto implements Serializable {

    public static Repuesto crearRepuesto(String id, String nombre, String codigoSav, String categoria, String descripcion, String marca, double precioCompra, double precioVenta, String fechaCompra, String disponibilidad) {
        return new Repuesto(nombre, codigoSav, categoria, descripcion, marca, precioCompra, precioVenta, fechaCompra);
    }


    public static Servicio crearServicio(String nombre, double precio, String categorias, String especificaciones, String duracion, String estado, String rutaImagen) {
        return new Servicio(nombre, precio, categorias, especificaciones, duracion, estado, rutaImagen);
    }
}