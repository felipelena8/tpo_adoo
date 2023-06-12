package vistas;

import models.animal.FichaMedica;
import models.animal.acciones.Accion;
import models.utils.Input;
import models.utils.UtilsVista;

import java.util.List;

public class VistaFichaMedica {
    private static FichaMedica fichaMedica;
    private static String menu = "0. Volver\n" +
            "1. Adoptar animal\n" +
            "2. Iniciar tratamiento medico\n" +
            "3. Iniciar control\n" +
            "4. Buscar control\n" +
            "5. Buscar tratamiento medico\n" +
            "6. Ver tratamientos medicos\n" +
            "7. Ver controles\n" +
            "8. Exportar ficha medica";


    public VistaFichaMedica(FichaMedica fichaMedica) {
        VistaFichaMedica.fichaMedica = fichaMedica;
    }

    private static FichaMedica getFichaMedica() {
        return fichaMedica;
    }

    public static boolean desplegarMenu() {
        System.out.println(menu);
        int opcion = Input.inputEntero("Ingrese la opcion: ");
        while (opcion > 8 || opcion < 0) {
            opcion = Input.inputEntero("Debe ingresar una opcion en el rango que se muestra: ");
        }
        switch (opcion) {
            case 0:
                return false;
            case 1://adoptar animal
                UtilsVista.adopcionAnimal(fichaMedica);
                break;
            case 2:
                List<Accion> accionList = UtilsVista.crearAcciones();
                String enfermedad = Input.inputTexto("Ingrese la enfermedad por la que se lo tratara: ");
                fichaMedica.iniciarTratamiento(accionList, enfermedad);
                break;
            case 3:
                accionList = UtilsVista.crearAcciones();
                String nombre = Input.inputTexto("Ingrese el nombre del control: ");
                fichaMedica.iniciarControl(accionList, nombre);
                break;
            case 4:
                UtilsVista.buscarControlVista(fichaMedica);
                break;
            case 5:
                UtilsVista.buscarTratamientoMedicoVista(fichaMedica);
                break;
            case 6:
                fichaMedica.verTratamientosMedicos();
                break;
            case 7:
                fichaMedica.verControles();
                break;
            case 8:
                UtilsVista.exportarFichaMedica(fichaMedica);
                break;
        }
        return true;
    }

}
