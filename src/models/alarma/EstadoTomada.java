package models.alarma;

import models.animal.Control;
import models.animal.TratamientoMedico;
import models.usuarios.Veterinario;

import java.util.Date;

public class EstadoTomada extends EstadoAlarma{
    private Veterinario encargado;
    @Override
    public void atender(Alarma contexto, Veterinario veterinario) {
        System.out.println("La alarma ya se encuentra tomada por el veterinario: " +encargado);
    }

    @Override
    public void desactivarAlarma(Alarma contexto) {
        contexto.cambiarEstado(new EstadoInactiva());
        System.out.println("La alarma ha pasado a estado inactiva");
    }

    @Override
    public void activarAlarma(Alarma contexto) {
        System.out.println("La alarma ya se encuentra activa");
    }


    @Override
    public boolean debeSonar(Alarma contexto) {
        contexto.cambiarEstado(new EstadoDisponible());
        return contexto.debeSonar();
    }

    public EstadoTomada(Veterinario encargado) {
        this.encargado = encargado;
    }
}
