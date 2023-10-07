package com.example.jmmoto.model.cuenta;

import javafx.scene.image.Image;

import java.io.Serializable;
import java.util.Objects;

public class Cuenta implements Serializable {
    private String usuario;
    private String password;
    private String email;
    private Image foto;

    public Cuenta(String usuario, String password, String email) {
        this.usuario = usuario;
        this.password = password;
        this.email = email;
        this.foto=null;
    }

    public Cuenta() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cuenta cuenta)) return false;
        return getUsuario().equals(cuenta.getUsuario());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsuario());
    }
}
