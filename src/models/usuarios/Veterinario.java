package models.usuarios;

import java.util.ArrayList;
import java.util.List;

public class Veterinario extends Usuario {
    private static List<Veterinario> veterinario = new ArrayList<>();
    public Veterinario(String usuario, String contrasena, String nombre, String apellido) {
        super(usuario, contrasena, nombre, apellido);
    }

}
