package vistas;

import models.animal.RegistroMedico;
import models.controllers.ControllerAlarmas;
import models.utils.Input;
import models.utils.UtilsVista;

public class VistaAlarmas {
    private static RegistroMedico registroMedico;
    private static String menu = "0. Volver\n" +
            "1. Eliminar alarma\n" +
            "2. Crear alarma";

    public static void setRegistroMedico(RegistroMedico registroMedico) {
        VistaAlarmas.registroMedico = registroMedico;
    }

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
                String nombreAlarma = Input.inputTexto("Ingrese el nombre de la alarma que desea eliminar: ");
                ControllerAlarmas.getInstancia().eliminarAlarma(nombreAlarma, registroMedico);
                break;
            case 2:
                UtilsVista.crearAlarma(registroMedico);
                break;
        }
        return true;
    }
}
