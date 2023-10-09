package com.example.jmmoto.model.Factorys;


import com.example.jmmoto.model.inventario.Inventario;


import java.io.Serializable;
import java.util.ArrayList;


public class InventarioCreator implements Serializable {

    public static Inventario crearInventario() {
        Inventario inventario = new Inventario();
        inventario.setId(String.valueOf(inventario.hashCode()));
        inventario.setHerramientas(new ArrayList<>());
        inventario.setProductos(new ArrayList<>());
        return inventario;
    }
}