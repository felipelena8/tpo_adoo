package vistas;

import models.controllers.ControllerFichasMedicas;
import models.utils.Input;
import models.utils.UtilsVista;

public class VistaMenuVisitante {
    private static String menu = "0. Cerrar sesion\n" +
            "1. Buscar ficha medica\n";

    public static boolean desplegarMenu() {
        System.out.println(menu);
        int opcion = Input.inputEntero("Ingrese la opcion: ");
        while (opcion > 3 || opcion < 0) {
            opcion = Input.inputEntero("Debe ingresar una opcion en el rango que se muestra: ");
        }
        switch (opcion) {
            case 0:
                return false;
            case 1:
                ControllerFichasMedicas.getInstancia().imprimirFichasMedicas();
                UtilsVista.buscarFichaMedica();
                break;
            case 2:
        }
        return true;
    }
}
