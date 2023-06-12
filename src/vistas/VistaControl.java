package vistas;

import models.animal.Control;
import models.controllers.ControllerUsuarios;
import models.usuarios.Veterinario;
import models.utils.Input;

import java.util.Date;

public class VistaControl {
    private static Control control;
    private static String menu = "0. Volver\n" +
            "1. Imprimir seguimientos\n" +
            "2. Generar nuevo seguimiento\n" +
            "3. Pausar\n" +
            "4. Iniciar\n" +
            "5. Menu alarma";;

    public static void setControl(Control control) {
        VistaControl.control = control;
    }

    public static boolean desplegarMenu() {
        System.out.println(menu);
        int opcion = Input.inputEntero("Ingrese la opcion: ");
        while (opcion > 5 || opcion < 0) {
            opcion = Input.inputEntero("Debe ingresar una opcion en el rango que se muestra: ");
        }
        switch (opcion) {
            case 0:
                return false;
            case 1:
                control.imprimirSeguimientos();
                break;
            case 2:
                generarNuevoSeguimiento();
                break;
                case 3:
                    control.pausar();
                break;
            case 4:control.iniciar();
                break;
            case 5:
                VistaAlarmas.setRegistroMedico(control);
                while (VistaAlarmas.desplegarMenu()) ;
                break;
        }
        return true;
    }

    private static void generarNuevoSeguimiento() {
        String observacion = Input.inputTexto("Ingrese una observacion sobre el control realizado:");
        control.generarSeguimiento(new Date(), (Veterinario) ControllerUsuarios.getInstancia().getUsuarioLoggeado(), observacion); //TODO ERROR EN EL CASTEO A VETERINARIO YA QUE EL USUARIO LOGGEADO ES UN 'USUARIO'
    }
}
