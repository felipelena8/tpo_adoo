package models.usuarios;

import java.util.ArrayList;
import java.util.List;

public class AdapterUsuario implements IAdapterUsuario {

    public AdapterUsuario() {

    }

    public List<Veterinario> getVeterinarios() {
        List<Veterinario> veterinarios = new ArrayList<>();
        veterinarios.add(new Veterinario("veterinario1", "contrasena1", "Juan", "Gómez"));
        veterinarios.add(new Veterinario("veterinario2", "contrasena2", "María", "López"));
        veterinarios.add(new Veterinario("veterinario3", "contrasena3", "Carlos", "Rodríguez"));
        veterinarios.add(new Veterinario("veterinario4", "contrasena4", "Laura", "Fernández"));
        return veterinarios;
    }

    @Override
    public UsuarioDTO iniciarSesion(String usuario, String password) {
        return new UsuarioDTO(usuario, password, "Juan", "Gómez");
    }

    public List<Visitante> getVisitantes() {
        List<Visitante> visitantes = new ArrayList<>();
        visitantes.add(new Visitante("visitante1", "contrasena1", "Juan", "Gómez"));
        visitantes.add(new Visitante("visitante2", "contrasena2", "María", "López"));
        visitantes.add(new Visitante("visitante3", "contrasena3", "Carlos", "Rodríguez"));
        visitantes.add(new Visitante("visitante4", "contrasena4", "Laura", "Fernández"));
        return visitantes;
    }


}
