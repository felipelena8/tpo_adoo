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
        fichasMedicas.add(new FichaMedica(new Animal("Max", 0.55, 6.2, 3, "perro", true)));
        fichasMedicas.add(new FichaMedica(new Animal("Luna", 0.35, 4.5, 2, "gato", true)));
        fichasMedicas.add(new FichaMedica(new Animal("Coco", 0.25, 1.8, 1, "pato", false)));
        fichasMedicas.add(new FichaMedica(new Animal("Pelusa", 0.3, 2.3, 4, "gato", true)));
        fichasMedicas.add(new FichaMedica(new Animal("Rocky", 0.7, 8.9, 5, "perro", true)));
        fichasMedicas.add(new FichaMedica(new Animal("Nina", 0.4, 3.5, 2, "gato", true)));
        fichasMedicas.add(new FichaMedica(new Animal("Buddy", 0.6, 7.1, 6, "perro", true)));
        fichasMedicas.add(new FichaMedica(new Animal("Tom", 0.3, 2.6, 1, "conejo", false)));
        fichasMedicas.add(new FichaMedica(new Animal("Charlie", 0.65, 9.5, 4, "perro", true)));
        fichasMedicas.add(new FichaMedica(new Animal("Milo", 0.4, 3.2, 3, "gato", true)));
        fichasMedicas.add(new FichaMedica(new Animal("Bella", 0.55, 5.8, 2, "perro", true)));
        fichasMedicas.add(new FichaMedica(new Animal("Simba", 0.3, 2.1, 1, "leon", false)));
        fichasMedicas.add(new FichaMedica(new Animal("Maxi", 0.75, 8.3, 7, "perro", true)));
        fichasMedicas.add(new FichaMedica(new Animal("Mia", 0.35, 4.1, 2, "gato", true)));
        fichasMedicas.add(new FichaMedica(new Animal("Lola", 0.6, 6.7, 4, "perro", true)));
        fichasMedicas.add(new FichaMedica(new Animal("Kitty", 0.25, 2.5, 1, "gato", true)));
        fichasMedicas.add(new FichaMedica(new Animal("Bruno", 0.85, 12.1, 8, "perro", true)));
        fichasMedicas.add(new FichaMedica(new Animal("Oliver", 0.4, 3.8, 3, "gato", true)));
        fichasMedicas.add(new FichaMedica(new Animal("Lucy", 0.5, 5.2, 2, "perro", true)));
        fichasMedicas.add(new FichaMedica(new Animal("Mimi", 0.3, 2.2, 1, "hámster", false)));


    }

    public static ControllerFichasMedicas getInstancia() {
        if (instancia == null) {
            instancia = new ControllerFichasMedicas();
        }
        return instancia;
    }

    public FichaMedica buscarFichaMedica(int nroFichaMedica) {
        return fichasMedicas.stream().filter(ficha -> ficha.hashCode() == nroFichaMedica).findFirst().orElse(null);
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

    public void adoptarAnimal(FichaMedica fichaMedica, Cliente adoptante, Visitante visitante, PreferenciaRecordatorio preferencia, Periodo periodo, int diasPreAviso) {
        if (fichaMedica.puedeSerAdoptado() && adoptante.getMascotasAdoptadas().size() < 2) {
            SeguimientoAnimal seguimientoAnimal = new SeguimientoAnimal(visitante, preferencia, periodo, diasPreAviso, adoptante);
            fichaMedica.setSeguimientoAnimal(seguimientoAnimal);
            System.out.println("Pausando controles...");
            fichaMedica.pausarControles();
            adoptante.adoptar(fichaMedica.getAnimal());
            System.out.println("El cliente: " + adoptante.getNombre() + " " + adoptante.getApellido() + " ha adoptado una nueva mascota. Se ha asignado al visitante " + visitante + " como responsable para realizar el seguimiento del animal");
            ControllerAlarmas.getInstancia().crearAlarmaSeguimiento(seguimientoAnimal);
        } else {
            if (adoptante.getMascotasAdoptadas().size() == 2) {
                System.out.println("El cliente no puede adoptar mas mascotas");
            }
        }
    }

}
