package models.alarma;

import models.FichaMedica;
import models.utils.Periodo;
import models.acciones.Accion;

import java.util.Date;
import java.util.List;

public class AlarmaTratamientoMedico extends Alarma{
    private String enfermedad;

    public void tratamientoFinalizado(boolean seFinalizo){
        super.getFichaMedica().buscarTratamientoMedicoSinFinalizar(enfermedad).finalizarTratamiento();
    }
    public AlarmaTratamientoMedico(String nombre,String enfermedad, Periodo periodicidad, List<Accion> acciones, Date fechaInicio, FichaMedica fichaMedica) {
        super(nombre,periodicidad, acciones, fechaInicio, fichaMedica);
        this.enfermedad =enfermedad;
    }

    public String getEnfermedad() {
        return enfermedad;
    }
}
