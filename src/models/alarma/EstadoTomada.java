package models.alarma;

import models.Control;
import models.TratamientoMedico;
import models.usuarios.Veterinario;

import java.util.Date;

public class EstadoTomada extends EstadoAlarma{
    @Override
    public void atender(Alarma contexto, Veterinario veterinario) {
        System.out.println("La alarma ya se encuentra tomada por el veterinario: " + super.getEncargado());
    }

    @Override
    public void concluir(Alarma contexto, String observacion) {
        if(contexto instanceof AlarmaTratamientoMedico){
            TratamientoMedico tratamiento = contexto.getFichaMedica().buscarTratamientoMedicoSinFinalizar(((AlarmaTratamientoMedico) contexto).getEnfermedad());
            Control nuevoControl = new Control(super.getEncargado(), contexto.getAcciones(), contexto.getUltimaVez(),observacion);
            tratamiento.agregarControl(nuevoControl);
            System.out.println("Se ha registrado un nuevo control: " + nuevoControl);
            //preguntar si finalizar o no el tratamiento
        }else{
            Control nuevoControl = new Control(super.getEncargado(), contexto.getAcciones(), new Date(), observacion);
            contexto.getFichaMedica().crearControl(nuevoControl);
            System.out.println("Se ha registrado un nuevo control: " + nuevoControl);
        }
        contexto.cambiarEstado(new EstadoDisponible(null));
    }

    public EstadoTomada(Veterinario encargado) {
        super(encargado);
    }
}
