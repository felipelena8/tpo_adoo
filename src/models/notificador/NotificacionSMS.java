package models.notificador;

public class NotificacionSMS implements EstrategiaNotificacion{
    private AdapterNotificadorSMS adapter = new AdapterSMSTwilio();
    @Override
    public void enviar(Notificacion notificacion) {
        adapter.enviarSMS(notificacion);
    }

}
