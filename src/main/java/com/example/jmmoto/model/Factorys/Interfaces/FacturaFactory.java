package com.example.jmmoto.model.Factorys.Interfaces;
import com.example.jmmoto.model.factura.Factura;
import com.example.jmmoto.model.moto.Moto;
import com.example.jmmoto.model.persona.Cliente;
import com.example.jmmoto.model.persona.Tecnico;

public interface FacturaFactory {
    Factura createFactura(String numeroFactura, String fechaEmision, String fechaVencimiento,
                          String subtotal, String impuesto, String descuentos, String total,
                          String metodoPago, String estadoPago, Tecnico tecnico, Cliente cliente, Moto moto);
}