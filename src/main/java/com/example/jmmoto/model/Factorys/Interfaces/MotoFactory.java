package com.example.jmmoto.model.Factorys.Interfaces;
import com.example.jmmoto.model.moto.Moto;

public interface MotoFactory {
    Moto createMoto(String placa, String modelo, String anioFabricacion, String numeroChasis, String color, String tipoMotor, String cilindraje, String tipoCombustible, String tipoAceite, String kilometraje, String estado, boolean accesorios, String fechaCompra);
}