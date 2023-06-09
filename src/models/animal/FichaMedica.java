package models.animal;

import models.ExportarFicha.ExportadorFichaMedica;
import models.adopcion.SeguimientoAnimal;
import models.animal.acciones.Accion;

import java.util.ArrayList;
import java.util.List;

public class FichaMedica {
    private Animal animal;
    private List<TratamientoMedico> tratamientos;
    private List<Control> controles = new ArrayList<>();
    private ExportadorFichaMedica exportarFicha;
    private SeguimientoAnimal seguimientoAnimal;

    public FichaMedica(Animal animal) {
        this.animal = animal;
        tratamientos = new ArrayList<>();
        controles = new ArrayList<>();
        exportarFicha = new ExportadorFichaMedica();
        seguimientoAnimal = null;

    }

    public boolean tratamientosFinalizados(){
        for (TratamientoMedico tratamiento:tratamientos){
            if(!tratamiento.estaFinalizado()){
                return false;
            }
        }
        return true;
    }

    public void iniciarTratamiento(List<Accion> acciones, String enfermedad){
        if(buscarTratamientoMedico(enfermedad)==null){
            tratamientos.add(new TratamientoMedico(acciones, enfermedad));
        }else{
            System.out.println("Ya se esta tratando al animal por " + enfermedad);
        }
    }

    public void iniciarControl(List<Accion> acciones, String nombre){
        controles.add(new Control(acciones, nombre));
    }
    public TratamientoMedico buscarTratamientoMedico(String enfermedad){
        return tratamientos.stream().filter(tratamientoMedico -> tratamientoMedico.getEnfermedad().equals(enfermedad)).findFirst().orElse(null);
    }
    public Control buscarControl(String nombre){
        return controles.stream().filter(control -> control.getNombre().equals(nombre)).findFirst().orElse(null);
    }

    public boolean puedeSerAdoptado(){
        return animal.isEsDomestico() && tratamientosFinalizados();
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public List<TratamientoMedico> getTratamientos() {
        return tratamientos;
    }


    public List<Control> getControles() {
        return controles;
    }

    public ExportadorFichaMedica getExportarFicha() {
        return exportarFicha;
    }

    public void setExportarFicha(ExportadorFichaMedica exportarFicha) {
        this.exportarFicha = exportarFicha;
    }

    public SeguimientoAnimal getSeguimientoAnimal() {
        return seguimientoAnimal;
    }

    public void setSeguimientoAnimal(SeguimientoAnimal seguimientoAnimal) {
        this.seguimientoAnimal = seguimientoAnimal;
    }
}
