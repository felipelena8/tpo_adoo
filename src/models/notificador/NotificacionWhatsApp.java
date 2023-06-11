package models.notificador;

public class NotificacionWhatsApp implements EstrategiaNotificacion {
    private AdapterNotificadorWhatsApp adapter = new AdapterWhatsAppTwilio();

    public NotificacionWhatsApp(AdapterNotificadorWhatsApp adapter) {
        this.adapter = adapter;
    }

    @Override
    public void enviar(Notificacion notificacion) {
        adapter.enviarWhatsApp(notificacion);
    }
}
