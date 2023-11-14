package com.example.jmmoto.model.cita;

import com.example.jmmoto.model.moto.Moto;
import com.example.jmmoto.model.persona.Cliente;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SolicitudCita implements Serializable {
    private String fecha;
    private Cliente emisor;
    private Moto motoCliente;
    private List<String>comentarios;
    public SolicitudCita(String fecha, Cliente emisor, Moto motoCliente, List<String>comentarios) {
        this.fecha = fecha;
        this.emisor = emisor;
        this.motoCliente = motoCliente;
        this.comentarios = comentarios;
    }

    public List<String> getComentarios() {
        return comentarios;
    }

    public SolicitudCita() {
    }
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Cliente getEmisor() {
        return emisor;
    }

    public void setEmisor(Cliente emisor) {
        this.emisor = emisor;
    }

    public Moto getMotoCliente() {
        return motoCliente;
    }

    public void setMotoCliente(Moto motoCliente) {
        this.motoCliente = motoCliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SolicitudCita that)) return false;
        return Objects.equals(getEmisor(), that.getEmisor()) && Objects.equals(getMotoCliente(), that.getMotoCliente());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmisor(), getMotoCliente());
    }
}
