package com.example.jmmoto.model.cita;

import com.example.jmmoto.model.moto.Moto;
import com.example.jmmoto.model.persona.Cliente;

import java.util.ArrayList;
import java.util.List;

public class SolicitudCita {
    private String fecha;
    private Cliente emisor;
    private Moto motoCliente;
    private List<String>comentarios;
    public SolicitudCita(String fecha, Cliente emisor, Moto motoCliente) {
        this.fecha = fecha;
        this.emisor = emisor;
        this.motoCliente = motoCliente;
        comentarios = new ArrayList<>();
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


}
