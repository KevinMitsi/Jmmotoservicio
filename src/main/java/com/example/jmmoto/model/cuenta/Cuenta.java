package com.example.jmmoto.model.cuenta;

import javafx.scene.image.Image;

import java.io.Serializable;
import java.util.Objects;

public class Cuenta implements Serializable {
    private String usuario;
    private String password;
    private String email;
    private Image foto;
    private String urlFoto;

    public Cuenta(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
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
        return Objects.equals(getUsuario(), cuenta.getUsuario()) && Objects.equals(getPassword(), cuenta.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsuario(), getPassword());
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
}
