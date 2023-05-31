package models.notificador;

public class Notificador {
    private EstrategiaNotificacion estrategia;

    public void enviar(Notificacion notificacion){
        estrategia.enviar(notificacion);
    }

    public void cambiarEstrategiaNotificacion(EstrategiaNotificacion estrategia){
        this.estrategia=estrategia;
    }
}
