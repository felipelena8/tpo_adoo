package vistas;

import models.adopcion.Cliente;
import models.controllers.ControllerClientes;
import models.utils.Input;

public class VistaCliente {

    private static String menu = "0. Volver\n" +
            "1. Ver clientes\n" +
            "2. Registrar cliente";

    public static void desplegarMenu() {
        System.out.println(menu);
        int opcion = Input.inputEntero("Ingrese la opcion: ");
        while (opcion > 1 || opcion < 0) {
            opcion = Input.inputEntero("Debe ingresar una opcion en el rango que se muestra: ");
        }
        switch (opcion) {
            case 0:
                return;

            case 1:
                break;
        }

    }

    public static Cliente buscarCliente() {
        String nombre = Input.inputTexto("Ingrese el nombre del cliente:");
        String apellido = Input.inputTexto("Ingrese el apellido del cliente:");
        return ControllerClientes.getInstancia().buscarCliente(nombre, apellido);
    }
}
