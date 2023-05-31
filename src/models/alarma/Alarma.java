package models.alarma;

import models.FichaMedica;
import models.notificador.Notificacion;
import models.utils.Periodo;
import models.usuarios.Veterinario;
import models.acciones.Accion;

import java.util.Date;
import java.util.List;

public class Alarma {


    private String nombre;
    private Periodo periodicidad;
    private List<Accion> acciones;
    private Date ultimaVez;
    private Date fechaInicio;
    private FichaMedica fichaMedica;
    private EstadoAlarma estado;

    public Alarma(String nombre, Periodo periodicidad, List<Accion> acciones, Date fechaInicio, FichaMedica fichaMedica) {
        estado = new EstadoDisponible(null);
        this.nombre =nombre;
        this.periodicidad = periodicidad;
        this.acciones = acciones;
        this.fechaInicio = fechaInicio;
        this.fichaMedica = fichaMedica;
    }

    public boolean debeSonar() {
        long tiempoActual = new Date().getTime();
        if (ultimaVez != null) {
            if (ultimaVez.getTime() + periodicidad.pasarAMilisegundos() <= tiempoActual) {
                return true;
            }
            return false;
        } else {
            if (fechaInicio.getTime() + periodicidad.pasarAMilisegundos() <= tiempoActual) {
                return true;
            }
            return false;
        }
    }

    public Notificacion sonar() {
        ultimaVez = new Date();
        String accionesStr = "Acciones a realizar:{\n";
        for (Accion accion:acciones){
            accionesStr+=accion + "\n";
        }
        accionesStr+="}";

        return new Notificacion(accionesStr,null, null);
    }

    public void concluir(String observacion){
        estado.concluir(this, observacion);
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

    public FichaMedica getFichaMedica() {
        return fichaMedica;
    }

    public Date getUltimaVez() {
        return ultimaVez;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public List<Accion> getAcciones() {
        return acciones;
    }

    @Override
    public String toString() {
        return "Alarma{" +
                "nombre='" + nombre + '\'' +
                ", acciones=" + acciones +
                '}';
    }
}
