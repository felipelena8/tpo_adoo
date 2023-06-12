package models.animal;

import models.usuarios.Veterinario;

import java.util.Date;

public class SeguimientoRegistroMedico {
    private Date fechaRealizacion;
    private Veterinario encargado;
    private String observacion;

    public SeguimientoRegistroMedico(Date fechaRealizacion, Veterinario encargado, String observacion) {
        this.fechaRealizacion = fechaRealizacion;
        this.encargado = encargado;
        this.observacion = observacion;
    }

    public Date getFechaRealizacion() {
        return fechaRealizacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public Veterinario getEncargado() {
        return encargado;
    }

    @Override
    public String toString() {
        return
                "fechaRealizacion=" + fechaRealizacion +
                        ", encargado=" + encargado +
                        ", observacion='" + observacion;

    }
}
