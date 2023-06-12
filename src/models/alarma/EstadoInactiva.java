package models.alarma;

import models.usuarios.Veterinario;

public class EstadoInactiva extends EstadoAlarma {


    @Override
    public void atender(Alarma contexto, Veterinario veterinario) {
        System.out.println("La alarma " + contexto + " se encuentra inactiva");
    }

    @Override
    public void desactivarAlarma(Alarma contexto) {
        System.out.println("La alarma " + contexto + " ya se encuentra inactiva");
    }

    @Override
    public void activarAlarma(Alarma contexto) {
        contexto.cambiarEstado(new EstadoDisponible());
        System.out.println("La alarma " + contexto + " ha pasado a estado activa");
    }

    @Override
    public boolean debeSonar(Alarma contexto) {
        return false;
    }
}
