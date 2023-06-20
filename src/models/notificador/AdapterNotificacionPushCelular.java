package models.notificador;

import javax.swing.*;

public class AdapterNotificacionPushCelular implements AdapterNotificadorPush {

    @Override
    public void enviarPush(Notificacion notificacion) {
       JOptionPane.showMessageDialog(null,"Se ha enviado una notificacion push. Mensaje: " + notificacion);
    }
}
