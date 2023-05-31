package models.alarma;

import models.usuarios.Veterinario;

public abstract class EstadoAlarma {
    public Veterinario getEncargado() {
        return encargado;
    }

    public void setEncargado(Veterinario encargado) {
        this.encargado = encargado;
    }

    private Veterinario encargado;
    public abstract void atender(Alarma contexto, Veterinario veterinario);
    public abstract void concluir(Alarma contexto, String observacion);

    public EstadoAlarma(Veterinario encargado) {
        this.encargado = encargado;
    }
}
