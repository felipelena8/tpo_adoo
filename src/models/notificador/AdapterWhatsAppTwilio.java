package models.notificador;

public class AdapterWhatsAppTwilio implements AdapterNotificadorWhatsApp {
    @Override
    public void enviarWhatsApp(Notificacion notificacion) {
        System.out.println("Se ha enviado un WhatsApp a " + notificacion.getTelefonoDestinatario() + ". Mensaje: " + notificacion);
    }
}
