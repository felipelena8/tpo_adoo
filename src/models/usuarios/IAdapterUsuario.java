package models.usuarios;

import java.util.List;

public interface IAdapterUsuario {
    List<Veterinario> getVeterinarios();
    Visitante iniciarSesionVisitante();
    Veterinario iniciarSesionVeterinario();
}
