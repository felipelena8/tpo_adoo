package models.animal;


import models.alarma.Alarma;
import models.controllers.ControllerAlarmas;

import java.util.List;

public class Control extends RegistroMedico {
    private String nombre;
    private boolean pausado;

    public Control(List<Accion> acciones, String nombre) {
        super(acciones);
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void pausar() {
        if (!estaPausado()) {
            System.out.println("El control " + nombre + " ha sido pausado");
            ControllerAlarmas.getInstancia().getAlarmas().stream().filter(alarma -> alarma.getRegistroMedico().equals(this)).toList().forEach(Alarma::desactivarAlarma);
            pausado = true;

        }
    }

    public void iniciar() {
        if (estaPausado()) {
            System.out.println("El control por " + nombre + " ha sido iniciado");
            ControllerAlarmas.getInstancia().getAlarmas().stream().filter(alarma -> alarma.getRegistroMedico().equals(this)).toList().forEach(Alarma::activarAlarma);
            pausado = false;

        }
    }

    public boolean estaPausado() {
        return pausado;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
