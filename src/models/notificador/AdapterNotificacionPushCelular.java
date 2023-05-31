package models.notificador;

public class AdapterNotificacionPushCelular implements AdapterNotificadorPush{

    @Override
    public void enviarPush(Notificacion notificacion) {
        System.out.println("Se ha enviado una notificacion push a los veterinarios. Mensaje: "+notificacion);
    }
}
