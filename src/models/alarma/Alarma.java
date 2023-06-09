package models.alarma;

import models.animal.FichaMedica;
import models.animal.RegistroMedico;
import models.notificador.Notificacion;
import models.utils.Periodo;
import models.usuarios.Veterinario;
import models.animal.acciones.Accion;

import java.util.Date;
import java.util.List;

public class Alarma {


    private String nombre;
    private Periodo periodicidad;

    private Date ultimaVez;
    private Date fechaInicio;
    private EstadoAlarma estado;
    private RegistroMedico registroMedico;
    public Alarma(String nombre, Periodo periodicidad,Date fechaInicio,RegistroMedico registroMedico) {
        estado = new EstadoDisponible();
        this.nombre =nombre;
        this.periodicidad = periodicidad;
        this.fechaInicio = fechaInicio;
        this.registroMedico=registroMedico;
    }

    public boolean debeSonar() {
       return estado.debeSonar(this);
    }

    public Notificacion sonar() {
        ultimaVez = new Date();
        String accionesStr = "Acciones a realizar:{\n";
        for (Accion accion:registroMedico.getAcciones()){
            accionesStr+=accion + "\n";
        }
        accionesStr+="}";

        return new Notificacion(accionesStr,null, null);
    }

    public void desactivarAlarma(){
        estado.desactivarAlarma(this);
    }

    public void activarAlarma(){
        estado.activarAlarma(this);
    }

    public Periodo getPeriodicidad() {
        return periodicidad;
    }

    public void atender(Veterinario veterinario) {
        estado.atender(this, veterinario);
    }

    public void cambiarEstado(EstadoAlarma estado){
        this.estado=estado;
    }

    public String getNombre() {
        return nombre;
    }

    public RegistroMedico getRegistroMedico() {
        return registroMedico;
    }

    public void setRegistroMedico(RegistroMedico registroMedico) {
        this.registroMedico = registroMedico;
    }

    public Date getUltimaVez() {
        return ultimaVez;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    @Override
    public String toString() {
        return "Alarma{" +
                "nombre='" + nombre + '\'' +
                ", acciones=" + registroMedico.getAcciones() +
                '}';
    }
}
