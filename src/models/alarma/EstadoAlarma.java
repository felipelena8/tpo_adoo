package models.alarma;

import models.notificador.Notificacion;
import models.usuarios.Veterinario;

public abstract class EstadoAlarma {


    public abstract void atender(Alarma contexto, Veterinario veterinario);
    public abstract void desactivarAlarma(Alarma contexto);
    public abstract void activarAlarma(Alarma contexto);
    public abstract boolean debeSonar(Alarma contexto);

}
