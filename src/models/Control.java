package models;

import models.acciones.Accion;
import models.usuarios.Veterinario;
import models.utils.FormatoFecha;

import java.util.Date;
import java.util.List;

public class Control {
    private Veterinario encargado;
    private List<Accion> acciones;
    private Date fechaRealizacion;
    private String observacion;

    public Control(Veterinario encargado, List<Accion> acciones, Date fechaRealizacion, String observacion) {
        this.encargado = encargado;
        this.acciones = acciones;
        this.fechaRealizacion = fechaRealizacion;
        this.observacion = observacion;
        for (Accion accion:acciones){
            accion.ejecutar();
        }
    }

    @Override
    public String toString() {
        return "Control{" +
                "encargado=" + encargado +
                ", acciones=" + acciones +
                ", fechaRealizacion=" + FormatoFecha.formatoFecha(fechaRealizacion) +
                ", observacion='" + observacion + '\'' +
                '}';
    }
}
