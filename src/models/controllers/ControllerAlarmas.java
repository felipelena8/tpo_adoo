package models.controllers;

import models.FichaMedica;
import models.adopcion.SeguimientoAnimal;
import models.acciones.Accion;
import models.alarma.Alarma;
import models.alarma.AlarmaTratamientoMedico;
import models.notificador.*;
import models.utils.Periodo;

import java.util.*;

public class ControllerAlarmas {

    private static ControllerAlarmas instancia = null;
    private List<Alarma> alarmas;
    private List<SeguimientoAnimal> seguimientos;
    private Notificador notificador;
    private final Timer timer = new Timer();
    private final TimerTask sonarAlarmas = new TimerTask() {
        @Override
        public void run() {
            notificador.cambiarEstrategiaNotificacion(new NotificacionPush());
            for (Alarma alarma : alarmas) {
                if (alarma.debeSonar()) {
                    notificador.enviar(alarma.sonar());
                }
            }
            for(SeguimientoAnimal seguimiento:seguimientos){
                if (seguimiento.seDebeGenerarRecordatorio()){
                    Notificacion notificacion = seguimiento.generarRecordatorio();
                    switch (seguimiento.getPreferencia()){
                        case SMS:
                            notificador.cambiarEstrategiaNotificacion(new NotificacionSMS());
                            break;
                        case EMAIL:
                            notificador.cambiarEstrategiaNotificacion(new NotificacionEmail());
                            break;
                        case WHATSAPP:
                            notificador.cambiarEstrategiaNotificacion(new NotificacionWhatsApp());
                            break;
                    }
                    notificador.enviar(notificacion);
                }
            }
        }
    };

    public static ControllerAlarmas getInstancia(){
        if(instancia==null){
            instancia = new ControllerAlarmas();
        }
        return instancia;
    }

    public List<Alarma> getAlarmas() {
        return alarmas;
    }

    public void chequearAlarmasYSeguimientos(){
        timer.schedule(sonarAlarmas,0,1000);
    }
    private ControllerAlarmas(){
        alarmas = new ArrayList<>();
        notificador = new Notificador();
        seguimientos = new ArrayList<>();
        chequearAlarmasYSeguimientos();
    }

    public Alarma buscarAlarma(String nombre){
        return alarmas.stream().filter(alarma -> alarma.getNombre().equals(nombre)).findFirst().orElse(null);
    }

    public void eliminarAlarma(String nombre){
        alarmas.removeIf(alarma -> alarma.getNombre().equals(nombre));
    }

    public void crearAlarma(String nombre, Periodo periodicidad, List<Accion> acciones, Date fechaInicio, FichaMedica fichaMedica) {
        alarmas.add(new Alarma(nombre, periodicidad, acciones, fechaInicio, fichaMedica));
    }
    public void crearAlarmaTratamiento(String nombre, String enfermedad, Periodo periodicidad, List<Accion> acciones, Date fechaInicio, FichaMedica fichaMedica) {
        alarmas.add(new AlarmaTratamientoMedico(enfermedad,nombre, periodicidad, acciones, fechaInicio, fichaMedica));
    }
}
