package com.example.jmmoto.model.persona;

import com.example.jmmoto.model.Rol.*;
import com.example.jmmoto.model.cuenta.Cuenta;

import java.io.Serializable;
import java.util.Objects;

public class Analista extends Persona implements Serializable {
    private String id;

    private double salario;
    private String horario;
    private String experiencia;
    private Rol rol;
    private Cuenta cuenta;

    public Analista(String nombre, String apellido, String cedula, String fechaNacimiento, String genero, String numeroTelefono, String email, String estadoCivil, double salario, String horario, String experiencia, Cuenta cuenta) {
        super(nombre, apellido, cedula, fechaNacimiento, genero, numeroTelefono, email, estadoCivil);
        this.salario = salario;
        this.horario = horario;
        this.id=String.valueOf(hashCode());
        this.experiencia = experiencia;
        this.rol= new Capacitado();
        this.cuenta=cuenta;
    }

    public Analista() {}

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Analista analista)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(analista.getSalario(), getSalario()) == 0 && Objects.equals(getId(), analista.getId()) && Objects.equals(getHorario(), analista.getHorario()) && Objects.equals(getExperiencia(), analista.getExperiencia()) && Objects.equals(getRol(), analista.getRol()) && Objects.equals(getCuenta(), analista.getCuenta());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getSalario(), getHorario(), getExperiencia(), getRol(), getCuenta());
    }
}
