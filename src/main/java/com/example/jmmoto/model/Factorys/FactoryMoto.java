package com.example.jmmoto.model.Factorys;
import com.example.jmmoto.model.moto.Moto;

import java.io.Serializable;


public class FactoryMoto implements Serializable {

    public static Moto createMoto(String placa, String modelo, String anioFabricacion, String numeroChasis, String color, String tipoMotor, String cilindraje, String tipoCombustible, String tipoAceite, String kilometraje, String estado, boolean accesorios, String fechaCompra) {
        Moto moto = new Moto(placa, modelo, anioFabricacion, numeroChasis, color, tipoMotor, cilindraje, tipoCombustible, tipoAceite, kilometraje, estado, accesorios, fechaCompra);
        moto.setId(String.valueOf(moto.hashCode()));
        return moto;
    }
}