package models.controllers;

import models.adopcion.Cliente;
import models.adopcion.Ocupacion;

import java.util.ArrayList;
import java.util.List;

public class ControllerClientes {
    private static ControllerClientes instancia = null;
    private List<Cliente> clientes;

    private ControllerClientes() {
        clientes = new ArrayList<>();
        clientes.add(new Cliente("Juan", "González", "juan.gonzalez@example.com", "555-1234", Ocupacion.EMPLEADO, 1, "Compañía para mi mascota solitaria."));
        clientes.add(new Cliente("María", "López", "maria.lopez@example.com", "555-5678", Ocupacion.OTROS, 2, "Quiero adoptar un perro para que sea el compañero de mi otro perro."));
        clientes.add(new Cliente("Carlos", "Martínez", "carlos.martinez@example.com", "555-9876", Ocupacion.OTROS, 0, "Me gustaría tener un gato para hacer ejercicio y jugar con él."));
        clientes.add(new Cliente("Laura", "Hernández", "laura.hernandez@example.com", "555-4321", Ocupacion.ESTUDIANTE, 3, "Deseo adoptar un perro para que sea parte de nuestra familia y cuidar de él."));
        clientes.add(new Cliente("Luis", "García", "luis.garcia@example.com", "555-8765", Ocupacion.EMPLEADO, 1, "Busco una mascota que me acompañe en mis caminatas diarias."));
        clientes.add(new Cliente("Ana", "Ramírez", "ana.ramirez@example.com", "555-2345", Ocupacion.ESTUDIANTE, 2, "Estoy buscando un gato para que me haga compañía en casa."));
        clientes.add(new Cliente("Pedro", "Díaz", "pedro.diaz@example.com", "555-7654", Ocupacion.ESTUDIANTE, 0, "Me gustaría adoptar un perro pequeño que pueda llevar conmigo a todas partes."));
        clientes.add(new Cliente("Sofía", "Vargas", "sofia.vargas@example.com", "555-5432", Ocupacion.OTROS, 1, "Quiero adoptar un gato para que me haga compañía mientras estudio."));
        clientes.add(new Cliente("Gabriel", "Fernández", "gabriel.fernandez@example.com", "555-4567", Ocupacion.EMPLEADO, 2, "Busco un perro de tamaño mediano para salir a correr juntos."));
        clientes.add(new Cliente("Valentina", "Pérez", "valentina.perez@example.com", "555-3456", Ocupacion.EMPLEADO, 0, "Deseo adoptar un gato que pueda brindar amor y compañía en mi hogar."));

    }

    public static ControllerClientes getInstancia() {
        if (instancia == null) {
            instancia = new ControllerClientes();
        }
        return instancia;
    }

    public Cliente buscarCliente(String nombre, String apellido) {
        return clientes.stream().filter(cliente -> cliente.getNombre().equalsIgnoreCase(nombre) && cliente.getApellido().equalsIgnoreCase(apellido)).findFirst().orElse(null);
    }

    public void registrarCliente(String nombre, String apellido, String email, String telefono, Ocupacion ocupacion, int mascotas, String motivoAdopcion) {
        clientes.add(new Cliente(nombre, apellido, email, telefono, ocupacion, mascotas, motivoAdopcion));
    }

    public void imprimirClientes() {
        System.out.println("Nombre | Apellido");
        for (Cliente cliente :
                clientes) {
            System.out.println(cliente.getNombre() + " | " + cliente.getApellido());
        }
    }


}
