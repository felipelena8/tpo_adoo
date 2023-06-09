package models.notificador;

public class NotificacionEmail implements EstrategiaNotificacion {

    private AdapterNotificadorEmail adapter = new AdapterEmailJavaMail();

    @Override
    public void enviar(Notificacion notificacion) {
        adapter.enviarEmail(notificacion);
    }

    public NotificacionEmail(AdapterNotificadorEmail adapter) {
        this.adapter = adapter;
    }
}
