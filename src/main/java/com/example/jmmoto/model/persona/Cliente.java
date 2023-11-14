package com.example.jmmoto.model.persona;

import com.example.jmmoto.controllers.Alerta;
import com.example.jmmoto.model.cita.Cita;
import com.example.jmmoto.model.cita.SolicitudCita;
import com.example.jmmoto.model.cuenta.Cuenta;
import com.example.jmmoto.model.moto.Moto;
import com.example.jmmoto.model.productos.Servicio;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cliente extends Persona implements Serializable {
    private String direccion;
    private List<Moto> motos;
    private Cuenta cuenta;
    private String id;
    private List<Cita>citas;
    private List<SolicitudCita>solicitudes;

    public Cliente(String nombre, String apellido, String cedula, String fechaNacimiento, String genero, String numeroTelefono, String email, String estadoCivil, String direccion, Cuenta cuenta) {
        super(nombre, apellido, cedula, fechaNacimiento, genero, numeroTelefono, email, estadoCivil);
        this.direccion = direccion;
        this.id=String.valueOf(hashCode());
        this.cuenta=cuenta;
        this.motos = new ArrayList<>();
        this.citas = new ArrayList<>();
        this.solicitudes = new ArrayList<>();
    }

    public Cliente(){}

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Moto> getMotos() {
        return motos;
    }

    public void setMotos(List<Moto> motos) {
        this.motos = motos;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

    public List<SolicitudCita> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<SolicitudCita> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }


    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public void eliminarMoto(Moto motoSeleccioanda) throws Exception {
        if (!motos.contains(motoSeleccioanda)){
            throw new Exception("Esta moto no se encuentra registrada como suya");
        }
        else{
            motos.remove(motoSeleccioanda);
            Alerta.saltarAlertaInformacion("Se ha eliminado correctamente la moto");
        }

    }

    public void agregarMoto(Moto motoSeleccioanda) throws Exception {
        if (motos.contains(motoSeleccioanda)){
            throw new Exception("Esta moto ya se encuentra registrada como suya");
        }
        else{
            motos.add(motoSeleccioanda);
            Alerta.saltarAlertaInformacion("Se ha agregado correctamente la moto");
        }
    }

    public SolicitudCita agendarCita(Moto moto,List<String>list) throws Exception {
        SolicitudCita miSolcitud = new SolicitudCita(String.valueOf(LocalDate.now()),this,moto,list);
        if (solicitudes.contains(miSolcitud)){
            throw new Exception("Esta solicitud ya está creada");
        }
        solicitudes.add(miSolcitud);
        return miSolcitud;
    }



}
