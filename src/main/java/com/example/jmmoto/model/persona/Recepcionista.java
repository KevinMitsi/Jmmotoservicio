package com.example.jmmoto.model.persona;

import com.example.jmmoto.model.Rol.*;

public class Recepcionista extends Persona{
    private String nivelEducacion;
    private String experienciaLaboral;
    private String salario;
    private String horario;

    Rol rol;

    public Recepcionista(String nombre, String apellido, String cedula, String fechaNacimiento, String genero, String numeroTelefono, String email, String estadoCivil, String nivelEducacion, String experienciaLaboral, String salario, String horario) {
        super(nombre, apellido, cedula, fechaNacimiento, genero, numeroTelefono, email, estadoCivil);
        this.nivelEducacion = nivelEducacion;
        this.experienciaLaboral = experienciaLaboral;
        this.salario = salario;
        this.horario = horario;
        this.rol= new RolAdministrativo("administrativo", "Recepcion de clientes/Salidas de moto y citas","completo","recepción","entradas y salidas");
    }
    public Recepcionista(){}

    public String getNivelEducacion() {
        return nivelEducacion;
    }

    public void setNivelEducacion(String nivelEducacion) {
        this.nivelEducacion = nivelEducacion;
    }

    public String getExperienciaLaboral() {
        return experienciaLaboral;
    }

    public void setExperienciaLaboral(String experienciaLaboral) {
        this.experienciaLaboral = experienciaLaboral;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
