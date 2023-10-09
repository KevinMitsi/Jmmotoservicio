package com.example.jmmoto.model.persona;

import com.example.jmmoto.model.cuenta.Cuenta;
import com.example.jmmoto.model.moto.Moto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cliente extends Persona implements Serializable {
    private String direccion;
    private List<Moto> motos;
    private Cuenta cuenta;
    private String id;

    public Cliente(String nombre, String apellido, String cedula, String fechaNacimiento, String genero, String numeroTelefono, String email, String estadoCivil, String direccion, Cuenta cuenta) {
        super(nombre, apellido, cedula, fechaNacimiento, genero, numeroTelefono, email, estadoCivil);
        this.direccion = direccion;
        this.id=String.valueOf(hashCode());
        this.cuenta=cuenta;
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

    public Cuenta getCuenta() {
        return cuenta;
    }


    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getDireccion(), cliente.getDireccion()) && Objects.equals(getCuenta(), cliente.getCuenta());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDireccion(), getCuenta());
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
