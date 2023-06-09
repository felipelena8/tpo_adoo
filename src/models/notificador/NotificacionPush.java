package models.notificador;

public class NotificacionPush implements EstrategiaNotificacion {
    private AdapterNotificadorPush adapter = new AdapterNotificacionPushCelular();

    public NotificacionPush(AdapterNotificadorPush adapter) {
        this.adapter = adapter;
    }

    @Override
    public void enviar(Notificacion notificacion) {
        adapter.enviarPush(notificacion);
    }
}
