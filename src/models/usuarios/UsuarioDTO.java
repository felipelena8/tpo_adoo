package models.usuarios;

public class UsuarioDTO {
    private String usuario;
    private String contrasena;
    private String nombre;
    private String apellido;

    public UsuarioDTO(String usuario, String contrasena, String nombre, String apellido) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Veterinario traerVeterinario() {
        return new Veterinario(usuario, contrasena, nombre, apellido);
    }

    public Visitante traerVisitante() {
        return new Visitante(usuario, contrasena, nombre, apellido);
    }
}
