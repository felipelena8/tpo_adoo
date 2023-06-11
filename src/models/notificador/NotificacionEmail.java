package models.notificador;

public class NotificacionEmail implements EstrategiaNotificacion {

    private AdapterNotificadorEmail adapter = new AdapterEmailJavaMail();

    public NotificacionEmail(AdapterNotificadorEmail adapter) {
        this.adapter = adapter;
    }

    @Override
    public void enviar(Notificacion notificacion) {
        adapter.enviarEmail(notificacion);
    }
}
