package models.adopcion;

import models.notificador.Notificacion;
import models.usuarios.Visitante;
import models.utils.FormatoFecha;
import models.utils.Periodo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SeguimientoAnimal {
    private Visitante responsable;
    private PreferenciaRecordatorio preferencia;
    private Periodo cadenciaVisita;
    private List<Visita> visitas;
    private boolean seguirAnimal;
    private int diasPreAviso;
    private Cliente cliente;
    private Date fechaAdopcion;

    public SeguimientoAnimal(Visitante responsable, PreferenciaRecordatorio preferencia, Periodo cadenciaVisita, int diasPreAviso, Cliente cliente) {
        this.responsable = responsable;
        this.preferencia = preferencia;
        this.visitas = new ArrayList<>();
        this.cadenciaVisita = cadenciaVisita;
        this.diasPreAviso = diasPreAviso;
        this.cliente = cliente;
        this.seguirAnimal = true;
    }

    public boolean seDebeGenerarRecordatorio() {
        return proximaVisita().getTime() - Periodo.crear(diasPreAviso).pasarAMilisegundos() <= new Date().getTime() && seguirAnimal;
    }

    public Notificacion generarRecordatorio() {
        return new Notificacion("El " + FormatoFecha.formatoFecha(proximaVisita()) + " se realizara una visita para ver el estado del animal", cliente.getTelefono(), cliente.getEmail());
    }

    public Date proximaVisita() {
        if (visitas.size() == 0) {
            return new Date(fechaAdopcion.getTime() + cadenciaVisita.pasarAMilisegundos());
        } else {
            return new Date(visitas.get(visitas.size() - 1).getFecha().getTime() + cadenciaVisita.pasarAMilisegundos());
        }
    }

    public void actualizarSeguimiento(int diasPreAviso, Periodo cadenciaVisita){
        seguirAnimal=true;
        this.diasPreAviso=diasPreAviso;
        this.cadenciaVisita=cadenciaVisita;
    }

    public void agregarVisita(Visita visita) {
        visitas.add(visita);
    }

    public void seDebeFinalizarSeguimiento(boolean finalizar) {
        seguirAnimal = finalizar;
    }

    public Visitante getResponsable() {
        return responsable;
    }

    public void setResponsable(Visitante responsable) {
        this.responsable = responsable;
    }

    public PreferenciaRecordatorio getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(PreferenciaRecordatorio preferencia) {
        this.preferencia = preferencia;
    }

    public Periodo getCadenciaVisita() {
        return cadenciaVisita;
    }

    public void setCadenciaVisita(Periodo cadenciaVisita) {
        this.cadenciaVisita = cadenciaVisita;
    }

    public List<Visita> getVisitas() {
        return visitas;
    }

    public void setVisitas(List<Visita> visitas) {
        this.visitas = visitas;
    }

    public boolean isSeguirAnimal() {
        return seguirAnimal;
    }

    public void setSeguirAnimal(boolean seguirAnimal) {
        this.seguirAnimal = seguirAnimal;
    }

    public int getDiasPreAviso() {
        return diasPreAviso;
    }

    public void setDiasPreAviso(int diasPreAviso) {
        this.diasPreAviso = diasPreAviso;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFechaAdopcion() {
        return fechaAdopcion;
    }

    public void setFechaAdopcion(Date fechaAdopcion) {
        this.fechaAdopcion = fechaAdopcion;
    }
}
