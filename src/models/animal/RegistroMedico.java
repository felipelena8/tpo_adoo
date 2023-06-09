package models.animal;

import models.animal.acciones.Accion;
import models.usuarios.Veterinario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegistroMedico {
    private List<Accion> acciones;
    private List<SeguimientoRegistroMedico> seguimientos;

    public List<Accion> getAcciones() {
        return acciones;
    }

    public List<SeguimientoRegistroMedico> getSeguimientos() {
        return seguimientos;
    }

    public void generarSeguimiento(Date fechaRealizacion, Veterinario encargado, String observacion){
        seguimientos.add(new SeguimientoRegistroMedico(fechaRealizacion, encargado, observacion));
    }

    public void imprimirSeguimientos(){
        for(SeguimientoRegistroMedico seguimiento: seguimientos){
            System.out.println(seguimiento);
        }
    }

    public RegistroMedico(List<Accion> acciones) {
        this.acciones = acciones;
        seguimientos = new ArrayList<>();
    }
}
