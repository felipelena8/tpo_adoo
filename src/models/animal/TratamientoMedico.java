package models.animal;

import models.alarma.Alarma;
import models.animal.acciones.Accion;
import models.controllers.ControllerAlarmas;

import java.util.List;

public class TratamientoMedico extends RegistroMedico {

    private String enfermedad;
    private boolean finalizado;

    public TratamientoMedico(List<Accion> acciones, String enfermedad) {
        super(acciones);
        this.enfermedad = enfermedad;
        finalizado = false;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public boolean estaFinalizado() {
        return finalizado;
    }

    public void finalizar() {
        if (!estaFinalizado()) {
            System.out.println("El tratamiento por " + enfermedad + " ha sido finalizado");
            ControllerAlarmas.getInstancia().getAlarmas().stream().filter(alarma -> alarma.getRegistroMedico().equals(this)).toList().forEach(Alarma::desactivarAlarma);
            finalizado = true;

        }
    }

    public void iniciar() {
        if (estaFinalizado()) {
            System.out.println("El tratamiento por " + enfermedad + " ha sido iniciado");
            ControllerAlarmas.getInstancia().getAlarmas().stream().filter(alarma -> alarma.getRegistroMedico().equals(this)).toList().forEach(Alarma::activarAlarma);
            finalizado = false;
        }
    }

    @Override
    public String toString() {
        return enfermedad;
    }
}
