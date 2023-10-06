package com.example.jmmoto.model.persona;

public class AdminRedesSoc extends Persona{
    private String fechaContratacion;
    private String numeroSeguidores;
    private String numeroInteracciones;
    private double salario;

    public AdminRedesSoc(String nombre, String apellido, String cedula, String fechaNacimiento, String genero, String numeroTelefono, String email, String estadoCivil, String fechaContratacion, String numeroSeguidores, String numeroInteracciones, double salario) {
        super(nombre, apellido, cedula, fechaNacimiento, genero, numeroTelefono, email, estadoCivil);
        this.fechaContratacion = fechaContratacion;
        this.numeroSeguidores = numeroSeguidores;
        this.numeroInteracciones = numeroInteracciones;
        this.salario = salario;
    }

    public AdminRedesSoc() {
    }

    public String getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(String fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public String getNumeroSeguidores() {
        return numeroSeguidores;
    }

    public void setNumeroSeguidores(String numeroSeguidores) {
        this.numeroSeguidores = numeroSeguidores;
    }

    public String getNumeroInteracciones() {
        return numeroInteracciones;
    }

    public void setNumeroInteracciones(String numeroInteracciones) {
        this.numeroInteracciones = numeroInteracciones;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "AdminRedesSoc{" +
                "fechaContratacion='" + fechaContratacion + '\'' +
                ", numeroSeguidores='" + numeroSeguidores + '\'' +
                ", numeroInteracciones='" + numeroInteracciones + '\'' +
                ", salario=" + salario +
                '}';
    }
}
