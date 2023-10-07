package com.example.jmmoto.model.redsocial;

import javafx.scene.image.Image;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RedSocial implements Serializable {
    private String id;
    private String nombre;
    private Image logo;
    private String url;

    private CuentaRed cuentaRed;

    public RedSocial(String nombre, String url) {
        this.id = String.valueOf(Objects.hash(getNombre(), getUrl()));
        this.nombre = nombre;
        this.logo = null;
        this.url = url;
        this.cuentaRed = null;
    }

    public RedSocial() {
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

    public Image getLogo() {
        return logo;
    }

    public void setLogo(Image logo) {
        this.logo = logo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public CuentaRed getCuentaRed() {
        return cuentaRed;
    }

    public void setCuentaRed(CuentaRed cuentaRed) {
        this.cuentaRed = cuentaRed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RedSocial redSocial)) return false;
        return getNombre().equals(redSocial.getNombre()) && getUrl().equals(redSocial.getUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getUrl());
    }
}
