package models;

import models.animal.FichaMedica;
import models.animal.TratamientoMedico;
import models.animal.acciones.Accion;
import models.animal.acciones.ChequearNutricion;
import models.animal.acciones.ColocarVacuna;
import models.animal.acciones.ComprobarPesoYTamano;
import models.alarma.Alarma;
import models.animal.Animal;
import models.controllers.ControllerAlarmas;
import models.controllers.ControllerFichasMedicas;
import models.controllers.ControllerUsuarios;
import models.usuarios.Veterinario;
import models.utils.Periodo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ControllerAlarmas controladorAlarmas = ControllerAlarmas.getInstancia();
        ControllerFichasMedicas controladorFichas = ControllerFichasMedicas.getInstancia();
        ControllerUsuarios controladorUsuarios = ControllerUsuarios.getInstancia();
        controladorUsuarios.iniciarSesionVeterinario();
        List<Accion> acciones = new ArrayList<Accion>();
        acciones.add(new ColocarVacuna());
        acciones.add(new ChequearNutricion());
        acciones.add(new ComprobarPesoYTamano());

        controladorFichas.crearFichaMedica(new Animal("Yuma",50,15,3,"Perro",true));
        FichaMedica yuma = controladorFichas.buscarFichaMedicaPorNombre("Yuma");
        yuma.iniciarTratamiento(acciones, "hermosura");
        TratamientoMedico tratamientoHermosura = yuma.buscarTratamientoMedico("hermosura");
        controladorFichas.imprimirFichasMedicas();
        controladorAlarmas.crearAlarma("Alarma por tratamiento hermosura", Periodo.crear(0,0,0,0,10),new Date(), tratamientoHermosura);
        Alarma alarma = controladorAlarmas.buscarAlarma("Alarma por tratamiento hermosura");
        alarma.atender((Veterinario) controladorUsuarios.getUsuarioLoggeado());

        Veterinario vete2 = new Veterinario("marquinhos", "1234", "Marcos", "qsyo");
        alarma.atender(vete2);
        Veterinario vete3 = new Veterinario("jorge","1234","Jorge","jorgito");
        tratamientoHermosura.finalizar();
        alarma.atender(vete3);
        tratamientoHermosura.iniciar();
        alarma.atender(vete3);
    }
}