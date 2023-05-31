package models;

import models.acciones.Accion;

import java.util.ArrayList;
import java.util.List;

public class TratamientoMedico {
    public String getEnfermedad() {
        return enfermedad;
    }

    private String enfermedad;
    private boolean finalizado;
    private List<Control> controles;
    private List<Accion> acciones;

    public void finalizarTratamiento(){
        finalizado = true;
    }

    public void agregarControl(Control control){
        controles.add(control);
    }

    public void agregarAccion(Accion accion) {
        acciones.add(accion);
    }

    public boolean estaFinalizado(){
        return finalizado;
    }

    public boolean soyTratamientoMedico(String enfermedad){
        return enfermedad.equals(this.enfermedad);
    }

    public TratamientoMedico(String enfermedad) {
        this.enfermedad = enfermedad;
        finalizado=false;
        controles = new ArrayList<>();
        acciones = new ArrayList<>();
    }
}
