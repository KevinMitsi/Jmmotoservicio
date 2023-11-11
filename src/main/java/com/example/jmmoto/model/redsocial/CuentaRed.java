package com.example.jmmoto.model.redsocial;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CuentaRed implements Serializable {
    private String id;
    private String nombre;
    private String descripcion;
    private int interacciones;
    private String password;
    private List<Publicacion> publicaciones;
    private List<CampanPublicitaria> campanas;

    public CuentaRed( String nombre, String descripcion, int interacciones, String password) {
        this.id = String.valueOf(Objects.hash(getNombre(), getPassword()));
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.interacciones = interacciones;
        this.password = password;
        this.publicaciones = new ArrayList<>();

    }

    public CuentaRed() {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getInteracciones() {
        return interacciones;
    }

    public void setInteracciones(int interacciones) {
        this.interacciones = interacciones;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(List<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }

    public List<CampanPublicitaria> getCampanas() {
        return campanas;
    }

    public void setCampanas(List<CampanPublicitaria> campanas) {
        this.campanas = campanas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CuentaRed cuentaRed)) return false;
        return getNombre().equals(cuentaRed.getNombre()) && getPassword().equals(cuentaRed.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getPassword());
    }
}
