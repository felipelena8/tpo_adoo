package models.controllers;

import models.adopcion.SeguimientoAnimal;
import models.alarma.Alarma;
import models.animal.RegistroMedico;
import models.factories.FactoryEstrategiaNotificacion;
import models.notificador.Notificacion;
import models.notificador.Notificador;
import models.usuarios.TipoUsuario;
import models.utils.Periodo;

import java.util.*;

public class ControllerAlarmas {

    private static ControllerAlarmas instancia = null;
    private final Timer timer = new Timer();
    private List<Alarma> alarmas;
    private List<SeguimientoAnimal> seguimientos;
    private Notificador notificador;
    private final TimerTask sonarAlarmas = new TimerTask() {
        @Override
        public void run() {

            if(TipoUsuario.VETERINARIO.equals(ControllerUsuarios.getInstancia().getTipoUsuario())){
                notificador.cambiarEstrategiaNotificacion(FactoryEstrategiaNotificacion.crearEstrategiaNotificacionPush());
                for (Alarma alarma : alarmas) {
                    if (alarma.debeSonar()) {
                        notificador.enviar(alarma.sonar());
                    }
                }
            }else{
                for (SeguimientoAnimal seguimiento : seguimientos) {
                    if (seguimiento.seDebeGenerarRecordatorio()) {
                        Notificacion notificacion = seguimiento.generarRecordatorio();
                        notificador.cambiarEstrategiaNotificacion(FactoryEstrategiaNotificacion.crearEstrategiaNotificacion(seguimiento.getPreferencia()));
                        notificador.enviar(notificacion);
                    }
                }
            }


        }
    };

    private ControllerAlarmas() {
        alarmas = new ArrayList<>();
        notificador = new Notificador();
        seguimientos = new ArrayList<>();
        chequearAlarmasYSeguimientos();
    }

    public static ControllerAlarmas getInstancia() {
        if (instancia == null) {
            instancia = new ControllerAlarmas();
        }
        return instancia;
    }

    public List<Alarma> getAlarmas() {
        return alarmas;
    }

    public void chequearAlarmasYSeguimientos() {
        timer.schedule(sonarAlarmas, 0, 1000);
    }

    public Alarma buscarAlarma(String nombre) {
        return alarmas.stream().filter(alarma -> alarma.getNombre().equals(nombre)).findFirst().orElse(null);
    }

    public void eliminarAlarma(String nombre) {
        alarmas.removeIf(alarma -> alarma.getNombre().equals(nombre));
    }

    public void crearAlarma(String nombre, Periodo periodicidad, Date fechaInicio, RegistroMedico registroMedico) {
        alarmas.add(new Alarma(nombre, periodicidad, fechaInicio, registroMedico));
    }

}
