package com.example.jmmoto.model.Factorys.Interfaces;
import com.example.jmmoto.model.productos.Repuesto;
import com.example.jmmoto.model.productos.Servicio;

public interface ProductoFactory {
    Repuesto crearRepuesto(String id, String nombre, String codigoSav, String categoria, String descripcion, String marca, double precioCompra, double precioVenta, String fechaCompra, String disponibilidad);
    Servicio crearServicio(String nombre, double precio, String categorias, String especificaciones, String duracion, String estado);
}