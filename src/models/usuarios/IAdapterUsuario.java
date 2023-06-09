package models.usuarios;

import java.util.List;

public interface IAdapterUsuario {
    List<Veterinario> getVeterinarios();

    UsuarioDTO iniciarSesion(String usuario, String password);

    List<Visitante> getVisitantes();
}
