package com.example.jmmoto.model.marcamoto;

import com.example.jmmoto.model.moto.Moto;
import javafx.scene.image.Image;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MarcaMoto implements Serializable {
    private String id;
    private String nombre;
    private String paisOrigen;
    private String especializacion;
    private String publicoObjetivo;
    private Image logo;
    private String sitioweb;
    private List<Moto>motosMarca;

    public MarcaMoto(String nombre, String paisOrigen, String especializacion, String publicoObjetivo, String sitioweb) {
        this.id = String.valueOf(hashCode());
        this.nombre = nombre;
        this.paisOrigen = paisOrigen;
        this.especializacion = especializacion;
        this.publicoObjetivo = publicoObjetivo;
        this.sitioweb = sitioweb;
        this.motosMarca=new ArrayList<>();
        this.logo=null;
    }

    public MarcaMoto() {
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

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public String getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }

    public String getPublicoObjetivo() {
        return publicoObjetivo;
    }

    public void setPublicoObjetivo(String publicoObjetivo) {
        this.publicoObjetivo = publicoObjetivo;
    }

    public Image getLogo() {
        return logo;
    }

    public void setLogo(Image logo) {
        this.logo = logo;
    }

    public String getSitioweb() {
        return sitioweb;
    }

    public void setSitioweb(String sitioweb) {
        this.sitioweb = sitioweb;
    }

    public List<Moto> getMotosMarca() {
        return motosMarca;
    }

    public void setMotosMarca(List<Moto> motosMarca) {
        this.motosMarca = motosMarca;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MarcaMoto marcaMoto)) return false;
        return Objects.equals(getNombre(), marcaMoto.getNombre()) && Objects.equals(getSitioweb(), marcaMoto.getSitioweb());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getSitioweb());
    }
}
