package com.example.jmmoto.model.sede;

import com.example.jmmoto.model.cita.Cita;
import com.example.jmmoto.model.cuenta.Cuenta;
import com.example.jmmoto.model.factura.Factura;
import com.example.jmmoto.model.inventario.Inventario;
import com.example.jmmoto.model.moto.Moto;
import com.example.jmmoto.model.persona.*;
import com.example.jmmoto.model.procedimiento.Procedimiento;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sede implements Serializable {
    private String id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private String horario;
    private List<AdminRedesSoc>adminRedesSocs;
    private List<Analista>analistas;
    private List<Recepcionista>recepcionistas;
    private Inventario inventario;
    private List<Procedimiento>procedimientos;
    private List<Factura>facturas;
    private List<Moto>motos;
    private Propietario propietario;
    private List<Tecnico>tecnicos;
    private List<Cliente>clientes;
    private List<Cita>citas;
    private List<Cuenta>cuentas;
    private List<Persona>personas;

    public Sede(String nombre, String direccion, String telefono, String email, String horario, Propietario propietario) {
        this.id = String.valueOf(hashCode());
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.horario = horario;
        this.adminRedesSocs= new ArrayList<>();
        this.analistas=new ArrayList<>();
        this.recepcionistas=new ArrayList<>();
        this.inventario= new Inventario();
        this.procedimientos=new ArrayList<>();
        this.facturas=new ArrayList<>();
        this.motos=new ArrayList<>();
        this.propietario=propietario;
        this.tecnicos=new ArrayList<>();
        this.clientes=new ArrayList<>();
        this.citas=new ArrayList<>();
        this.cuentas=new ArrayList<>();
        this.personas=agregarPeronas();
    }

    private List<Persona> agregarPeronas() {
        List<Persona> personas = new ArrayList<>(this.adminRedesSocs);
        personas.addAll(this.recepcionistas);
        personas.addAll(this.tecnicos);
        personas.addAll(this.clientes);
        personas.addAll(this.analistas);
        personas.add(this.propietario);
        return personas;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public List<AdminRedesSoc> getAdminRedesSocs() {
        return adminRedesSocs;
    }

    public void setAdminRedesSocs(List<AdminRedesSoc> adminRedesSocs) {
        this.adminRedesSocs = adminRedesSocs;
    }

    public List<Analista> getAnalistas() {
        return analistas;
    }

    public void setAnalistas(List<Analista> analistas) {
        this.analistas = analistas;
    }

    public List<Recepcionista> getRecepcionistas() {
        return recepcionistas;
    }

    public void setRecepcionistas(List<Recepcionista> recepcionistas) {
        this.recepcionistas = recepcionistas;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public List<Procedimiento> getProcedimientos() {
        return procedimientos;
    }

    public void setProcedimientos(List<Procedimiento> procedimientos) {
        this.procedimientos = procedimientos;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public List<Moto> getMotos() {
        return motos;
    }

    public void setMotos(List<Moto> motos) {
        this.motos = motos;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public List<Tecnico> getTecnicos() {
        return tecnicos;
    }

    public void setTecnicos(List<Tecnico> tecnicos) {
        this.tecnicos = tecnicos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Cita> getCitas() {
        return citas;
    }
    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sede sede)) return false;
        return Objects.equals(getNombre(), sede.getNombre()) && Objects.equals(getDireccion(), sede.getDireccion()) && Objects.equals(getTelefono(), sede.getTelefono());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getDireccion(), getTelefono());
    }
//-------------------Metodos propios de clase----------------------------
    public boolean verificarCuenta(Cuenta cuenta) {
        return this.cuentas.contains(cuenta);
    }

    public Cliente retornarClienteAsociado(Cuenta cuenta) throws Exception {
        if (verificarCuenta(cuenta)){
            for (Cliente cliente: clientes) {
                if (cliente.getCuenta().equals(cuenta)){
                    return cliente;
                }
            }
            return null;
        }
        else {
            throw new Exception("Usuario no encontrado");
        }
    }
}
