package com.example.jmmoto.model.persona;

import com.example.jmmoto.model.moto.Moto;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona{
    private String direccion;
    private List<Moto> motos;

    public Cliente(String nombre, String apellido, String cedula, String fechaNacimiento, String genero, String numeroTelefono, String email, String estadoCivil, String direccion) {
        super(nombre, apellido, cedula, fechaNacimiento, genero, numeroTelefono, email, estadoCivil);
        this.direccion = direccion;
        this.motos = new ArrayList<>();
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
}
