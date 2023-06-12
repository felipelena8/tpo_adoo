package vistas;

import models.controllers.ControllerUsuarios;
import models.usuarios.TipoUsuario;
import models.utils.Input;

public class VistaIniciarSesion {
    public static void iniciarSesion() {
        String username = Input.inputTexto("Ingrese el username: ");
        String password = Input.inputTexto("Ingrese el password: ");
        TipoUsuario tipoUsuario = TipoUsuario.parseTipoUsuario(Input.inputTexto("Elige el tipo de usuario: Veterinario, Visitante").toUpperCase());
        while (tipoUsuario == null) {
            System.out.println("El tipo de usuario elegido no existe");
            tipoUsuario = TipoUsuario.parseTipoUsuario(Input.inputTexto("Elige el tipo de usuario: Veterinario, Visitante").toUpperCase());
        }
        ControllerUsuarios.getInstancia().iniciarSesion(username, password, tipoUsuario);
        switch (tipoUsuario) {
            case VETERINARIO:
                while (VistaMenuVeterinario.desplegarMenu()) ;
                break;
            case VISITANTE:
                while (VistaMenuVisitante.desplegarMenu()) ;
                break;
        }
    }
}
