package models.notificador;

public class NotificacionSMS implements EstrategiaNotificacion{
    private AdapterNotificadorSMS adapter;
    @Override
    public void enviar(Notificacion notificacion) {
        adapter.enviarSMS(notificacion);
    }

    public NotificacionSMS(AdapterNotificadorSMS adapter) {
        this.adapter = adapter;
    }
}
