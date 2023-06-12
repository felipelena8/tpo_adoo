package models.controllers;

import models.adopcion.SeguimientoAnimal;
import models.alarma.Alarma;
import models.alarma.AlarmaDTO;
import models.animal.RegistroMedico;
import models.factories.FactoryEstrategiaNotificacion;
import models.notificador.Notificacion;
import models.notificador.Notificador;
import models.usuarios.TipoUsuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ControllerAlarmas {

    private static ControllerAlarmas instancia = null;
    private final Timer timer = new Timer();
    private List<Alarma> alarmas;
    private List<SeguimientoAnimal> seguimientos;
    private Notificador notificador;
    private final TimerTask sonarAlarmas = new TimerTask() {
        @Override
        public void run() {

            if (TipoUsuario.VETERINARIO.equals(ControllerUsuarios.getInstancia().getTipoUsuario())) {
                notificador.cambiarEstrategiaNotificacion(FactoryEstrategiaNotificacion.crearEstrategiaNotificacionPush());
                for (Alarma alarma : alarmas) {
                    if (alarma.debeSonar()) {
                        notificador.enviar(alarma.sonar());
                    }
                }
            } else {
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

    public Alarma buscarAlarma(String nombre, RegistroMedico registroMedico) {
        return alarmas.stream().filter(alarma -> alarma.getNombre().equals(nombre) && alarma.getRegistroMedico().equals(registroMedico)).findFirst().orElse(null);
    }

    public void eliminarAlarma(String nombre, RegistroMedico registroMedico) {
        System.out.println(alarmas.removeIf(alarma -> alarma.getNombre().equals(nombre) && alarma.getRegistroMedico().equals(registroMedico)) ? "Se ha eliminado la alarma " + nombre :
                "No existe una alarma con el nombre " + nombre);
    }

    public void crearAlarma(AlarmaDTO alarmaDTO) {
        Alarma existente = buscarAlarma(alarmaDTO.getNombre(), alarmaDTO.getRegistroMedico());
        if (existente != null) {
            System.out.println("Ya existe una alarma " + existente + " para el registro medico " + alarmaDTO.getRegistroMedico());
            return;
        }
        alarmas.add(alarmaDTO.crearAlarma());
        System.out.println("Se ha creado la alarma");
    }

}
