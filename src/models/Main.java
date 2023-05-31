package models;

import models.acciones.Accion;
import models.acciones.ChequearNutricion;
import models.acciones.ColocarVacuna;
import models.acciones.ComprobarPesoYTamano;
import models.alarma.Alarma;
import models.controllers.ControllerAlarmas;
import models.controllers.ControllerFichasMedicas;
import models.controllers.ControllerUsuarios;
import models.usuarios.AdapterUsuario;
import models.usuarios.Veterinario;
import models.utils.FormatoFecha;
import models.utils.Periodo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ControllerAlarmas controladorAlarmas = ControllerAlarmas.getInstancia();
        ControllerFichasMedicas controladorFichas = ControllerFichasMedicas.getInstancia();
        ControllerUsuarios controladorUsuarios = ControllerUsuarios.getInstancia();
        controladorUsuarios.iniciarSesion("veterinario1","contrasena1");
        List<Accion> acciones = new ArrayList<Accion>();
        acciones.add(new ColocarVacuna());
        acciones.add(new ChequearNutricion());
        acciones.add(new ComprobarPesoYTamano());

        controladorFichas.crearFichaMedica(new Animal("Yuma",50,15,3,"Perro",true));
        controladorFichas.imprimirFichasMedicas();
        controladorAlarmas.crearAlarma("Alarma 1", Periodo.crear(0,0,0,0,10),acciones, new Date(), controladorFichas.buscarFichaMedica(2093176254));
        Alarma alarma = controladorAlarmas.buscarAlarma("Alarma 1");
        alarma.atender((Veterinario) controladorUsuarios.getUsuarioLoggeado());
        alarma.concluir("Se siente mejor");

    }
}