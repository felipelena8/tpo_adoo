package models.notificador;

public class Notificacion {
    private String mensaje;
    private String emailDestinatario;
    private String telefonoDestinatario;

    public Notificacion(String mensaje, String emailDestinatario, String telefonoDestinatario) {
        this.mensaje = mensaje;
        this.emailDestinatario = emailDestinatario;
        this.telefonoDestinatario = telefonoDestinatario;
    }


    public String getMensaje() {
        return mensaje;
    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public String getTelefonoDestinatario() {
        return telefonoDestinatario;
    }

    @Override
    public String toString() {
        return mensaje;
    }
}
