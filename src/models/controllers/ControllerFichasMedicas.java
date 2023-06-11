package models.controllers;

import models.adopcion.Cliente;
import models.adopcion.PreferenciaRecordatorio;
import models.adopcion.SeguimientoAnimal;
import models.animal.Animal;
import models.animal.FichaMedica;
import models.usuarios.Visitante;
import models.utils.Periodo;

import java.util.ArrayList;
import java.util.List;

public class ControllerFichasMedicas {
    private static ControllerFichasMedicas instancia;
    private List<FichaMedica> fichasMedicas;

    private ControllerFichasMedicas() {
        fichasMedicas = new ArrayList<>();
    }

    public static ControllerFichasMedicas getInstancia() {
        if (instancia == null) {
            instancia = new ControllerFichasMedicas();
        }
        return instancia;
    }

    public FichaMedica buscarFichaMedicaPorNro(int nroFichaMedica) {
        return fichasMedicas.stream().filter(ficha -> ficha.hashCode() == nroFichaMedica).findFirst().orElse(null);
    }

    public FichaMedica buscarFichaMedicaPorNombre(String nombre) {
        return fichasMedicas.stream().filter(ficha -> ficha.getAnimal().getNombre().equals(nombre)).findFirst().orElse(null);
    }

    public void crearFichaMedica(Animal animal) {
        fichasMedicas.add(new FichaMedica(animal));
    }

    public void imprimirFichasMedicas() {
        System.out.println("ID | Nombre Animal | Tipo Animal");
        for (FichaMedica ficha : fichasMedicas) {
            System.out.println(ficha.hashCode() + " | " + ficha.getAnimal().getNombre() + " | " + ficha.getAnimal().getTipoAnimal());
        }
    }

    public void adoptarAnimal(FichaMedica fichaMedica, Visitante visitante, Cliente adoptante, PreferenciaRecordatorio preferencia, Periodo periodo, int diasPreAviso) {
        if (fichaMedica.puedeSerAdoptado() && adoptante.getMascotasAdoptadas().size() < 2) {
            fichaMedica.setSeguimientoAnimal(new SeguimientoAnimal(visitante, preferencia, periodo, diasPreAviso, adoptante));
            adoptante.adoptar(fichaMedica.getAnimal());
            System.out.println("El cliente: " + adoptante + " ha adoptado una nueva mascota. Se ha asignado al visitante " + visitante + " como responsable para realizar el seguimiento del animal");
        }
    }

}
