package models.notificador;

public class AdapterSMSTwilio implements AdapterNotificadorSMS {
    @Override
    public void enviarSMS(Notificacion notificacion) {
        System.out.println("Se ha enviado un SMS a " + notificacion.getTelefonoDestinatario() + ". Mensaje: " + notificacion);
    }
}
