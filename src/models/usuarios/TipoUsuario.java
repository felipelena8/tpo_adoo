package models.usuarios;

public enum TipoUsuario {
    VETERINARIO("VETERINARIO"),
    VISITANTE("VISITANTE");

    private final String tipoUsuario;

    TipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public static TipoUsuario parseTipoUsuario(String tipoUsuario) {
        if (tipoUsuario == null) {
            return null;
        }
        for (TipoUsuario tipoU : TipoUsuario.values()) {
            if (tipoU.getTipoUsuario().equals(tipoUsuario.toUpperCase())) {
                return tipoU;
            }
        }
        return null;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

}
