package com.example.jmmoto.model.persona;

import com.example.jmmoto.model.Rol.Rol;
import com.example.jmmoto.model.herramienta.Herramienta;

import java.util.ArrayList;
import java.util.List;

public class Tecnico extends Persona{
    private String  id;
    private String fechaContratacion;
    private String experienciaLaboral;
    private String horarioTrabajo;
    private double salario;
    private String estadoEmpleo;

    private List<Herramienta>herramientas;
    Rol rol;

    public Tecnico(String nombre, String apellido, String cedula, String fechaNacimiento, String genero, String numeroTelefono, String email, String estadoCivil, String id, String fechaContratacion, String experienciaLaboral, String horarioTrabajo, double salario, String estadoEmpleo) {
        super(nombre, apellido, cedula, fechaNacimiento, genero, numeroTelefono, email, estadoCivil);
        this.id = id;
        this.fechaContratacion = fechaContratacion;
        this.experienciaLaboral = experienciaLaboral;
        this.horarioTrabajo = horarioTrabajo;
        this.salario = salario;
        this.estadoEmpleo = estadoEmpleo;
        this.herramientas=new ArrayList<>();
        this.rol=null;
    }

    public Tecnico() {
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(String fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public String getExperienciaLaboral() {
        return experienciaLaboral;
    }

    public void setExperienciaLaboral(String experienciaLaboral) {
        this.experienciaLaboral = experienciaLaboral;
    }

    public String getHorarioTrabajo() {
        return horarioTrabajo;
    }

    public void setHorarioTrabajo(String horarioTrabajo) {
        this.horarioTrabajo = horarioTrabajo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getEstadoEmpleo() {
        return estadoEmpleo;
    }

    public void setEstadoEmpleo(String estadoEmpleo) {
        this.estadoEmpleo = estadoEmpleo;
    }

    public List<Herramienta> getHerramientas() {
        return herramientas;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public void setHerramientas(List<Herramienta> herramientas) {
        this.herramientas = herramientas;
    }

    @Override
    public String toString() {
        return "Tecnico{" +
                "id='" + id + '\'' +
                ", horarioTrabajo='" + horarioTrabajo + '\'' +
                ", salario=" + salario +
                ", estadoEmpleo='" + estadoEmpleo + '\'' +
                '}';
    }
}
