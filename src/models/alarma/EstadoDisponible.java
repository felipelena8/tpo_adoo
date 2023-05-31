package models.alarma;

import models.usuarios.Veterinario;

public class EstadoDisponible extends EstadoAlarma{

    public EstadoDisponible(Veterinario encargado) {
        super(encargado);
    }

    @Override
    public void atender(Alarma contexto, Veterinario veterinario) {
        super.setEncargado(veterinario);
        System.out.println("El veterinario " + veterinario + " ha atendido la alarma '"+contexto+"'");
        contexto.cambiarEstado(new EstadoTomada(veterinario));
    }

    @Override
    public void concluir(Alarma contexto, String observacion) {

    }
}
