package com.example.jmmoto.model.persona;

import java.util.Objects;

public class Persona {
    private String id;
    private String nombre;
    private String apellido;
    private String cedula;
    private String fechaNacimiento;
    private String genero;
    private String numeroTelefono;
    private String email;
    private String estadoCivil;

    public Persona(String nombre, String apellido, String cedula, String fechaNacimiento, String genero, String numeroTelefono, String email, String estadoCivil) {
        this.id = String.valueOf(Objects.hash(getCedula(), getNumeroTelefono()));
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.numeroTelefono = numeroTelefono;
        this.email = email;
        this.estadoCivil = estadoCivil;
    }

    public Persona() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona persona)) return false;
        return Objects.equals(getCedula(), persona.getCedula()) && Objects.equals(getNumeroTelefono(), persona.getNumeroTelefono());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCedula(), getNumeroTelefono());
    }
}
