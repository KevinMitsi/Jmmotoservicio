package com.example.jmmoto.model.factura;

import com.example.jmmoto.model.moto.Moto;
import com.example.jmmoto.model.persona.Cliente;
import com.example.jmmoto.model.persona.Tecnico;
import com.example.jmmoto.model.procedimiento.Procedimiento;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Factura implements Serializable {
    private String id;
    private String numeroFactura;
    private String fechaEmision;
    private String fechaVencimiento;
    private String subtotal;
    private String impuesto;
    private String descuentos;
    private String total;
    private String metodoPago;
    private String estadoPago;
    private Tecnico tecnicoDueno;
    private Moto motoIntervenida;
    private List<Procedimiento>procedimientos;
    private Cliente clienteDueno;

    public Factura() {
    }

    public Factura(String numeroFactura, String fechaEmision, String fechaVencimiento,
                   String subtotal, String impuesto, String descuentos, String total, String metodoPago, String estadoPago, Tecnico tecnico, Cliente cliente, Moto moto) {
        this.id = String.valueOf(hashCode());
        this.numeroFactura = numeroFactura;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
        this.subtotal = subtotal;
        this.impuesto = impuesto;
        this.descuentos = descuentos;
        this.total = total;
        this.metodoPago = metodoPago;
        this.estadoPago = estadoPago;
        this.tecnicoDueno=tecnico;
        this.clienteDueno=cliente;
        this.motoIntervenida=moto;
        this.procedimientos= new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(String impuesto) {
        this.impuesto = impuesto;
    }

    public String getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(String descuentos) {
        this.descuentos = descuentos;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    public Tecnico getTecnicoDueno() {
        return tecnicoDueno;
    }

    public void setTecnicoDueno(Tecnico tecnicoDueno) {
        this.tecnicoDueno = tecnicoDueno;
    }

    public Moto getMotoIntervenida() {
        return motoIntervenida;
    }

    public void setMotoIntervenida(Moto motoIntervenida) {
        this.motoIntervenida = motoIntervenida;
    }

    public List<Procedimiento> getProcedimientos() {
        return procedimientos;
    }

    public void setProcedimientos(List<Procedimiento> procedimientos) {
        this.procedimientos = procedimientos;
    }

    public Cliente getClienteDueno() {
        return clienteDueno;
    }

    public void setClienteDueno(Cliente clienteDueno) {
        this.clienteDueno = clienteDueno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Factura factura)) return false;
        return Objects.equals(getNumeroFactura(), factura.getNumeroFactura()) && Objects.equals(getFechaEmision(), factura.getFechaEmision()) && Objects.equals(getEstadoPago(), factura.getEstadoPago()) && Objects.equals(getTecnicoDueno(), factura.getTecnicoDueno()) && Objects.equals(getMotoIntervenida(), factura.getMotoIntervenida());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumeroFactura(), getFechaEmision(), getEstadoPago(), getTecnicoDueno(), getMotoIntervenida());
    }
}
