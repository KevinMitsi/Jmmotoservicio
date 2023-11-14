package com.example.jmmoto.model.persona;

import com.example.jmmoto.controllers.Alerta;
import com.example.jmmoto.model.Rol.*;
import com.example.jmmoto.model.cita.Cita;
import com.example.jmmoto.model.cuenta.Cuenta;
import com.example.jmmoto.model.sede.Sede;
import com.example.jmmoto.threads.EmailThread;
import javafx.scene.control.ButtonType;

import java.io.Serializable;

public class Recepcionista extends Persona implements Serializable {
    private String nivelEducacion;
    private String experienciaLaboral;
    private double salario;
    private String horario;
    private Cuenta cuenta;

    Rol rol;

    public Recepcionista(String nombre, String apellido, String cedula, String fechaNacimiento, String genero, String numeroTelefono, String email, String estadoCivil, String nivelEducacion, String experienciaLaboral, double salario, String horario, Cuenta cuenta) {
        super(nombre, apellido, cedula, fechaNacimiento, genero, numeroTelefono, email, estadoCivil);
        this.nivelEducacion = nivelEducacion;
        this.experienciaLaboral = experienciaLaboral;
        this.salario = salario;
        this.horario = horario;
        this.cuenta = cuenta;
        this.rol= new RolAdministrativo("administrativo", "Recepcion de clientes/Salidas de moto y citas","completo","recepción","entradas y salidas");
    }
    public Recepcionista(){}

    public String getNivelEducacion() {
        return nivelEducacion;
    }

    public void setNivelEducacion(String nivelEducacion) {
        this.nivelEducacion = nivelEducacion;
    }

    public String getExperienciaLaboral() {
        return experienciaLaboral;
    }

    public void setExperienciaLaboral(String experienciaLaboral) {
        this.experienciaLaboral = experienciaLaboral;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getHorario() {
        return horario;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }


    public void agendarCita(Sede sedes, Cita cita) throws Exception {
        if (sedes.getCitas().contains(cita)){
            throw new Exception("Esta cita ya está agendada");
        }
        else{
            sedes.getCitas().add(cita);
            cita.getCliente().getCitas().add(cita);
            if (Alerta.saltarAlertaConfirmacion("Quiere enviar correo?","Puede enviar un correo al cliente")== ButtonType.OK){
                EmailThread emailThread = new EmailThread("Confirmacion de cita JMMOTOSERVICIO", "Este correo es para confirmar que su cita ha sido aprobada" +
                        "\n su cita está agendada para la fecha: "+ cita.getFecha()+ " "+cita.getHora(),cita.getCliente().getEmail());
                emailThread.start();
                while (emailThread.isRunning()){
                    Alerta.saltarAlertaAdvertencia("Enviando correo espere");
                }
                Alerta.saltarAlertaInformacion("Correo enviado");
            }
        }
    }
}
