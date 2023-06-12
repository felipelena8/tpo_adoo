package vistas;

import models.animal.TratamientoMedico;
import models.controllers.ControllerUsuarios;
import models.usuarios.Veterinario;
import models.utils.Input;

import java.util.Date;

public class VistaTratamientoMedico {
    private static TratamientoMedico tratamientoMedico;
    private static String menu = "0. Volver\n" +
            "1. Imprimir seguimientos\n" +
            "2. Generar nuevo seguimiento\n" +
            "3. Finalizar\n" +
            "4. Iniciar\n" +
            "5. Menu alarma";

    public static void setTratamientoMedico(TratamientoMedico tratamientoMedico) {
        VistaTratamientoMedico.tratamientoMedico = tratamientoMedico;
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
                tratamientoMedico.imprimirSeguimientos();
                break;
            case 2:
                generarNuevoSeguimiento();
                break;
            case 3:
                tratamientoMedico.finalizar();
                break;
            case 4:
                tratamientoMedico.iniciar();
                break;
            case 5:
                VistaAlarmas.setRegistroMedico(tratamientoMedico);
                while (VistaAlarmas.desplegarMenu()) ;
                break;
        }
        return true;
    }

    private static void generarNuevoSeguimiento() {
        String observacion = Input.inputTexto("Ingrese una observacion sobre el tratamiento realizado:");
        tratamientoMedico.generarSeguimiento(new Date(), (Veterinario) ControllerUsuarios.getInstancia().getUsuarioLoggeado(), observacion);
    }
}
