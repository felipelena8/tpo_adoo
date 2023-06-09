package models.animal;


import models.animal.acciones.Accion;

import java.util.List;

public class Control extends RegistroMedico{
    private String nombre;

    public Control(List<Accion> acciones, String nombre) {
        super(acciones);
        this.nombre= nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
