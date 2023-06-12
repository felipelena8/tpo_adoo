package models.alarma;

import models.animal.RegistroMedico;
import models.utils.Periodo;

import java.util.Date;

public class AlarmaDTO {
    private String nombre;
    private Periodo periodicidad;
    private Date fechaInicio;
    private RegistroMedico registroMedico;

    public AlarmaDTO(String nombre, Periodo periodicidad, Date fechaInicio, RegistroMedico registroMedico) {
        this.nombre = nombre;
        this.periodicidad = periodicidad;
        this.fechaInicio = fechaInicio;
        this.registroMedico = registroMedico;
    }

    public String getNombre() {
        return nombre;
    }

    public RegistroMedico getRegistroMedico() {
        return registroMedico;
    }

    public Alarma crearAlarma() {
        return new Alarma(nombre, periodicidad, fechaInicio, registroMedico);
    }
}
