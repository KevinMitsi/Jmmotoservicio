package com.example.jmmoto.model.redsocial;

import java.util.Objects;

public class CampanPublicitaria {
    private String id;
    private String nombre;
    private String objetivo;
    private String presupuesto;
    private String fechaInicio;
    private String fechaFin;
    private String desempeno;

    public CampanPublicitaria(String id, String nombre, String objetivo, String presupuesto, String fechaInicio, String desempeno) {
        this.id = String.valueOf(Objects.hash(getNombre(), getObjetivo()));
        this.nombre = nombre;
        this.objetivo = objetivo;
        this.presupuesto = presupuesto;
        this.fechaInicio = fechaInicio;
        this.fechaFin= null;
        this.desempeno = desempeno;
    }

    public CampanPublicitaria() {
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

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(String presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDesempeno() {
        return desempeno;
    }

    public void setDesempeno(String desempeno) {
        this.desempeno = desempeno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CampanPublicitaria that)) return false;
        return getNombre().equals(that.getNombre()) && getObjetivo().equals(that.getObjetivo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getObjetivo());
    }
}
