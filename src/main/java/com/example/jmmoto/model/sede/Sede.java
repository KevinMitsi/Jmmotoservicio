package com.example.jmmoto.model.sede;

import com.example.jmmoto.model.cita.Cita;
import com.example.jmmoto.model.cita.SolicitudCita;
import com.example.jmmoto.model.cuenta.Cuenta;
import com.example.jmmoto.model.factura.Factura;
import com.example.jmmoto.model.inventario.Inventario;
import com.example.jmmoto.model.moto.Moto;
import com.example.jmmoto.model.persona.*;
import com.example.jmmoto.model.procedimiento.Procedimiento;
import com.example.jmmoto.model.productos.Repuesto;
import com.example.jmmoto.model.productos.Servicio;

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
    private List<Servicio> servicioList;
    private List<SolicitudCita>solicitudCitas;

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
        this.personas=new ArrayList<>();
        this.personas = agregarPeronas();
        this.servicioList = new ArrayList<>();
        this.solicitudCitas = new ArrayList<>();
    }

    public Sede(){

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

    public List<SolicitudCita> getSolicitudCitas() {
        return solicitudCitas;
    }

    public void setSolicitudCitas(List<SolicitudCita> solicitudCitas) {
        this.solicitudCitas = solicitudCitas;
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

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sede sede)) return false;
        return Objects.equals(getNombre(), sede.getNombre()) && Objects.equals(getDireccion(), sede.getDireccion()) && Objects.equals(getTelefono(), sede.getTelefono());
    }

    public List<Servicio> getServicioList() {
        return servicioList;
    }

    public void setServicioList(List<Servicio> servicioList) {
        this.servicioList = servicioList;
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

    public void agregarCiente(Cliente cliente) {
        clientes.add(cliente);
        personas.add(cliente);
        cuentas.add(cliente.getCuenta());
    }

    public boolean existUsuario(String text) {
        for (Cuenta cuenta: cuentas) {
            if (cuenta.getUsuario().equals(text)){
                return true;
            }
        }
        return false;
    }

    public Cuenta intentarRecuperar(String text) {
        Cuenta cuenta = null;
        for (Cuenta cuent:cuentas) {
            if (cuent.getUsuario().equals(text)){
                cuenta=cuent;
            }
        }
        if (cuenta==null){
            throw new NullPointerException("Usuario no encontrado");
        }
        return cuenta;
    }

    public String calcularDisponibilidad(Repuesto repuestoSeleccionado) {
        int contador = 0;
        for (Repuesto repuesto: inventario.getProductos()){
            if (repuestoSeleccionado.getCodigoSav().equals(repuesto.getCodigoSav())){
                contador++;
            }
        }
        return String.valueOf(contador);
    }

    public void agregarAnalista(Analista analista) throws Exception {
        if (analistas.contains(analista)){
            throw new Exception("Este analista ya está creado");
        }
        else{
            analistas.add(analista);
            personas.add(analista);
        }
    }

    public void agregarServicio(Servicio creado) throws Exception {
        if (servicioList.contains(creado)){
            throw new Exception("Este servicio ya estác creado");
        }
        else{
            servicioList.add(creado);
        }
    }

    public void agregarTecnico(Tecnico tecnico) throws Exception {
        if (tecnicos.contains(tecnico)){
            throw new Exception("Este tecnico ya está creado");
        }
        else{
            tecnicos.add(tecnico);
            personas.add(tecnico);
            cuentas.add(tecnico.getCuenta());
        }

    }

    public void agregarRecepcionista(Recepcionista recepcionista) throws Exception {
        if (recepcionistas.contains(recepcionista)){
            throw new Exception("Este recepcionista ya está creado");
        }
        else{
            recepcionistas.add(recepcionista);
            personas.add(recepcionista);
            cuentas.add(recepcionista.getCuenta());
        }
    }

    public Recepcionista retornarRecepcionista(Cuenta cuenta) throws Exception {
        if (verificarCuenta(cuenta)){
            for (Recepcionista cliente: recepcionistas) {
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
