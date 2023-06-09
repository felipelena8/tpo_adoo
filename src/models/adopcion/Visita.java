package models.adopcion;

import java.util.Date;

public class Visita {
    private Encuesta encuesta;
    private Date fecha;

    public Visita(Encuesta encuesta, Date fecha) {
        this.encuesta = encuesta;
        this.fecha = fecha;
    }

    public Encuesta getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
