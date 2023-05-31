package models.usuarios;

import java.util.ArrayList;
import java.util.List;

public class AdapterUsuario implements IAdapterUsuario{

    public AdapterUsuario(){

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
    public Visitante iniciarSesionVisitante() {
       return new Visitante("visitante1", "contrasena1", "Lucía", "García");
    }

    @Override
    public Veterinario iniciarSesionVeterinario() {
        return new Veterinario("veterinario1", "contrasena1", "Juan", "Gómez");
    }

}