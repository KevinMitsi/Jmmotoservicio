package com.example.jmmoto.model.persona;

import com.example.jmmoto.model.cuenta.Cuenta;
import com.example.jmmoto.model.redsocial.RedSocial;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AdminRedesSoc extends Persona implements Serializable {
    String id;
    private String fechaContratacion;
    private String numeroSeguidores;
    private String numeroInteracciones;
    private double salario;
    private List<RedSocial> redSociales;
    private Cuenta cuenta;

    public AdminRedesSoc(String nombre, String apellido, String cedula, String fechaNacimiento, String genero, String numeroTelefono, String email, String estadoCivil, String fechaContratacion, String numeroSeguidores, String numeroInteracciones, double salario, Cuenta cuenta) {
        super(nombre, apellido, cedula, fechaNacimiento, genero, numeroTelefono, email, estadoCivil);
        this.fechaContratacion = fechaContratacion;
        this.id=String.valueOf(hashCode());
        this.numeroSeguidores = numeroSeguidores;
        this.numeroInteracciones = numeroInteracciones;
        this.salario = salario;
        this.redSociales = new ArrayList<>();
        this.cuenta= cuenta;
    }



    public List<RedSocial> getRedSocial() {

        return redSociales;
    }

    public void setRedSocial(List<RedSocial> redSocial) {
        this.redSociales = redSocial;
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

    public List<RedSocial> getRedSociales() {
        return redSociales;
    }

    public void setRedSociales(List<RedSocial> redSociales) {
        this.redSociales = redSociales;
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
    public String toString() {
        return "AdminRedesSoc{" +
                "fechaContratacion='" + fechaContratacion + '\'' +
                ", numeroSeguidores='" + numeroSeguidores + '\'' +
                ", numeroInteracciones='" + numeroInteracciones + '\'' +
                ", salario=" + salario +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdminRedesSoc that)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(that.getSalario(), getSalario()) == 0 && Objects.equals(getFechaContratacion(), that.getFechaContratacion()) && Objects.equals(getNumeroSeguidores(), that.getNumeroSeguidores()) && Objects.equals(getNumeroInteracciones(), that.getNumeroInteracciones()) && Objects.equals(getCuenta(), that.getCuenta());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getFechaContratacion(), getNumeroSeguidores(), getNumeroInteracciones(), getSalario(), getCuenta());
    }
}
