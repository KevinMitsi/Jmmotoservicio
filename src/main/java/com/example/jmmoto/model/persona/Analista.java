package com.example.jmmoto.model.persona;

import com.example.jmmoto.model.Rol.*;

public class Analista extends Persona{

    private double salario;
    private String horario;
    private String experiencia;
    Rol rol;

    public Analista(String nombre, String apellido, String cedula, String fechaNacimiento, String genero, String numeroTelefono, String email, String estadoCivil, double salario, String horario, String experiencia) {
        super(nombre, apellido, cedula, fechaNacimiento, genero, numeroTelefono, email, estadoCivil);
        this.salario = salario;
        this.horario = horario;
        this.experiencia = experiencia;
        this.rol= new Capacitado();
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
}
