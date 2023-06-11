package models.alarma;

import models.usuarios.Veterinario;

import java.util.Date;

public class EstadoDisponible extends EstadoAlarma {


    @Override
    public void atender(Alarma contexto, Veterinario veterinario) {
        System.out.println("El veterinario " + veterinario + " ha atendido la alarma '" + contexto + "'");
        contexto.cambiarEstado(new EstadoTomada(veterinario));
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
        long tiempoActual = new Date().getTime();
        if (contexto.getUltimaVez() != null) {
            if (contexto.getUltimaVez().getTime() + contexto.getPeriodicidad().pasarAMilisegundos() <= tiempoActual) {
                return true;
            }
            return false;
        } else {
            if (contexto.getFechaInicio().getTime() + contexto.getPeriodicidad().pasarAMilisegundos() <= tiempoActual) {
                return true;
            }
            return false;
        }
    }


}
