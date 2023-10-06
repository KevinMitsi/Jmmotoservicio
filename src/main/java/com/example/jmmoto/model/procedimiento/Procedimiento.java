package com.example.jmmoto.model.procedimiento;

import com.example.jmmoto.model.moto.Moto;
import com.example.jmmoto.model.persona.Tecnico;
import com.example.jmmoto.model.productos.Producto;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Procedimiento {
    private String id;
    private String nombre;
    private String descripcion;
    private String tiempoEstimiado;
    private String nivelDificultad;
    private List<String> pasos;
    private Image foto;
    private String fechaRealizacion;
    private Tecnico tecnicoDueno;
    private Moto motoIntervenida;
    private List<Producto>productosUtilizados;

    public Procedimiento(String nombre, String descripcion, String tiempoEstimiado, String nivelDificultad, String fechaRealizacion, Tecnico tecnicoDueno, Moto motoIntervenida) {
        this.id=String.valueOf(hashCode());
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tiempoEstimiado = tiempoEstimiado;
        this.nivelDificultad = nivelDificultad;
        this.fechaRealizacion = fechaRealizacion;
        this.pasos= new ArrayList<>();
        this.foto=null;
        this.tecnicoDueno=tecnicoDueno;
        this.motoIntervenida= motoIntervenida;
        this.productosUtilizados= new ArrayList<>();
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

    public String getTiempoEstimiado() {
        return tiempoEstimiado;
    }

    public void setTiempoEstimiado(String tiempoEstimiado) {
        this.tiempoEstimiado = tiempoEstimiado;
    }

    public String getNivelDificultad() {
        return nivelDificultad;
    }

    public void setNivelDificultad(String nivelDificultad) {
        this.nivelDificultad = nivelDificultad;
    }

    public List<String> getPasos() {
        return pasos;
    }

    public void setPasos(List<String> pasos) {
        this.pasos = pasos;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public String getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(String fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public Tecnico getTecnicoDueno() {
        return tecnicoDueno;
    }

    public void setTecnicoDueno(Tecnico tecnicoDueno) {
        this.tecnicoDueno = tecnicoDueno;
    }

    public Moto getMotoIntervenida() {
        return motoIntervenida;
    }

    public void setMotoIntervenida(Moto motoIntervenida) {
        this.motoIntervenida = motoIntervenida;
    }

    public List<Producto> getProductosUtilizados() {
        return productosUtilizados;
    }

    public void setProductosUtilizados(List<Producto> productosUtilizados) {
        this.productosUtilizados = productosUtilizados;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Procedimiento that)) return false;
        return Objects.equals(getNombre(), that.getNombre()) && Objects.equals(getDescripcion(), that.getDescripcion()) && Objects.equals(getTecnicoDueno(), that.getTecnicoDueno()) && Objects.equals(getMotoIntervenida(), that.getMotoIntervenida()) && Objects.equals(getProductosUtilizados(), that.getProductosUtilizados());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getDescripcion(), getTecnicoDueno(), getMotoIntervenida(), getProductosUtilizados());
    }
}
