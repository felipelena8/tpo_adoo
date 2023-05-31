package models.notificador;

public class AdapterEmailJavaMail implements AdapterNotificadorEmail{

    @Override
    public void enviarEmail(Notificacion notificacion) {
        System.out.println("Se ha enviado un email a "+ notificacion.getEmailDestinatario()+ ". Mensaje: "+notificacion);
    }
}
