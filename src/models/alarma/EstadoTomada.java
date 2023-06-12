package models.alarma;

import models.usuarios.Veterinario;

public class EstadoTomada extends EstadoAlarma {
    private Veterinario encargado;

    public EstadoTomada(Veterinario encargado) {
        this.encargado = encargado;
    }

    @Override
    public void atender(Alarma contexto, Veterinario veterinario) {
        System.out.println("La alarma " + contexto + " ya se encuentra tomada por el veterinario: " + encargado);
    }

    @Override
    public void desactivarAlarma(Alarma contexto) {
        contexto.cambiarEstado(new EstadoInactiva());
        System.out.println("La alarma " + contexto + " ha pasado a estado inactiva");
    }

    @Override
    public void activarAlarma(Alarma contexto) {
        System.out.println("La alarma " + contexto + " ya se encuentra activa");
    }

    @Override
    public boolean debeSonar(Alarma contexto) {
        contexto.cambiarEstado(new EstadoDisponible());
        return contexto.debeSonar();
    }
}
