package com.example.jmmoto.model.Factorys;

import com.example.jmmoto.model.Factorys.Interfaces.FacturaFactory;
import com.example.jmmoto.model.factura.Factura;
import com.example.jmmoto.model.moto.Moto;
import com.example.jmmoto.model.persona.Cliente;
import com.example.jmmoto.model.persona.Tecnico;

import java.io.Serializable;

public class FactoryFactura implements FacturaFactory, Serializable {
    @Override
    public Factura createFactura(String numeroFactura, String fechaEmision, String fechaVencimiento,
                                 String subtotal, String impuesto, String descuentos, String total,
                                 String metodoPago, String estadoPago, Tecnico tecnico, Cliente cliente, Moto moto) {
        return new Factura(numeroFactura, fechaEmision, fechaVencimiento, subtotal, impuesto, descuentos, total,
                metodoPago, estadoPago, tecnico, cliente, moto);
    }
}
