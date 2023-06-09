package models.notificador;

public class NotificacionWhatsApp implements EstrategiaNotificacion{
    private AdapterNotificadorWhatsApp adapter = new AdapterWhatsAppTwilio();

    @Override
    public void enviar(Notificacion notificacion) {
        adapter.enviarWhatsApp(notificacion);
    }

    public NotificacionWhatsApp(AdapterNotificadorWhatsApp adapter) {
        this.adapter = adapter;
    }
}
