package models.animal;

import models.animal.acciones.Accion;
import models.usuarios.Veterinario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegistroMedico {
    private List<Accion> acciones;
    private List<SeguimientoRegistroMedico> seguimientos;

    public RegistroMedico(List<Accion> acciones) {
        this.acciones = acciones;
        seguimientos = new ArrayList<>();
    }

    public List<Accion> getAcciones() {
        return acciones;
    }

    public List<SeguimientoRegistroMedico> getSeguimientos() {
        return seguimientos;
    }

    public void generarSeguimiento(Date fechaRealizacion, Veterinario encargado, String observacion) {
        acciones.stream().forEach(accion -> accion.ejecutar());
        seguimientos.add(new SeguimientoRegistroMedico(fechaRealizacion, encargado, observacion));
        System.out.println("Se ha generado un nuevo seguimiento del animal");
    }

    public void imprimirSeguimientos() {
        for (SeguimientoRegistroMedico seguimiento : seguimientos) {
            System.out.println(seguimiento);
        }
    }
}
