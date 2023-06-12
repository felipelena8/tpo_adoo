package vistas;

import models.animal.Animal;
import models.controllers.ControllerFichasMedicas;
import models.utils.Input;
import models.utils.UtilsVista;

public class VistaMenuVeterinario {
    private static String menu = "0. Cerrar sesion\n" +
            "1. Listar fichas medicas\n" +
            "2. Buscar ficha medica por numero\n" +
            "3. Crear nueva ficha medica\n" +
            "4. Ir al menu de alarmas";


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
                ControllerFichasMedicas.getInstancia().imprimirFichasMedicas();
                break;
            case 2: //buscar ficha medica
                UtilsVista.buscarFichaMedica();
                break;
            case 3://creacion ficha medica
                System.out.println("Ingrese los datos del animal: ");
                String nombre = Input.inputTexto("Ingrese el nombre: ");
                double altura = Input.inputDouble("Ingrese la altura: ");
                double peso = Input.inputDouble("Ingrese el peso: ");
                int edad = Input.inputEntero("Ingrese la edad: ");
                String tipoAnimal = Input.inputTexto("Que tipo de animal es: ");
                boolean esDomestico = Input.inputTexto("Es domestico?: Si, No").equalsIgnoreCase("SI");
                ControllerFichasMedicas.getInstancia().crearFichaMedica(new Animal(nombre, altura, peso, edad, tipoAnimal, esDomestico));
                break;
            case 4:

        }
        return true;
    }
}
