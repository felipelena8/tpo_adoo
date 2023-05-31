package models.notificador;

public class NotificacionPush implements EstrategiaNotificacion{
    private AdapterNotificadorPush adapter = new AdapterNotificacionPushCelular();
    @Override
    public void enviar(Notificacion notificacion) {
        adapter.enviarPush(notificacion);
    }
}
