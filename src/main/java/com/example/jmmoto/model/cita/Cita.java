package com.example.jmmoto.model.cita;

import com.example.jmmoto.model.moto.Moto;
import com.example.jmmoto.model.persona.Cliente;
import com.example.jmmoto.model.persona.Tecnico;
import com.example.jmmoto.model.productos.Repuesto;
import com.example.jmmoto.model.productos.Servicio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cita implements Serializable {
    private Cliente cliente;
    private Tecnico tecnico;
    private Moto moto;
    private List<Servicio>servicios;
    private List<Repuesto>repuestos;
    private String id;
    private String fecha;
    private String hora;
    private String estadoCita;
    private String fechaCreacion;
    private List<String> notasCliente;
    private List<String> notasAdmin;

    public Cita(Cliente cliente, List<String>notasCliente,Tecnico tecnico, String fecha, String hora, String estadoCita, String fechaCreacion, Moto moto) {
        this.moto = moto;
        this.cliente = cliente;
        this.tecnico = tecnico;
        this.servicios = new ArrayList<>();
        this.id = String.valueOf(hashCode());
        this.fecha = fecha;
        this.hora = hora;
        this.estadoCita = estadoCita;
        this.fechaCreacion = fechaCreacion;
        this.repuestos = new ArrayList<>();
        this.notasAdmin=new ArrayList<>();
        this.notasCliente=notasCliente;
    }

    public Cita() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Moto getMoto() {
        return moto;
    }

    public void setMoto(Moto moto) {
        this.moto = moto;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEstadoCita() {
        return estadoCita;
    }

    public void setEstadoCita(String estadoCita) {
        this.estadoCita = estadoCita;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public List<String> getNotasCliente() {
        return notasCliente;
    }

    public void setNotasCliente(List<String> notasCliente) {
        this.notasCliente = notasCliente;
    }

    public List<String> getNotasAdmin() {
        return notasAdmin;
    }

    public void setNotasAdmin(List<String> notasAdmin) {
        this.notasAdmin = notasAdmin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cita cIta)) return false;
        return Objects.equals(getCliente(), cIta.getCliente()) && Objects.equals(getTecnico(), cIta.getTecnico()) && Objects.equals(getFecha(), cIta.getFecha()) && Objects.equals(getFechaCreacion(), cIta.getFechaCreacion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCliente(), getTecnico(), getFecha(), getFechaCreacion());
    }
}
