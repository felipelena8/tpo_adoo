package models;

import models.ExportarFicha.ExportadorFichaMedica;
import models.adopcion.SeguimientoAnimal;

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

    public TratamientoMedico buscarTratamientoMedicoSinFinalizar(String enfermedad){
        for (TratamientoMedico tratamiento:tratamientos){
            if(!tratamiento.estaFinalizado() && tratamiento.soyTratamientoMedico(enfermedad)){
                return tratamiento;
            }
        }
        return null;
    }

    public void iniciarNuevoTratamiento(String enfermedad){
        if(buscarTratamientoMedicoSinFinalizar(enfermedad)==null){
            tratamientos.add(new TratamientoMedico(enfermedad));
        }else{
            System.out.println("Ya se esta tratando al animal por " + enfermedad);
        }
    }

    public void crearControl(Control control){
        controles.add(control);
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

    public void setTratamientos(List<TratamientoMedico> tratamientos) {
        this.tratamientos = tratamientos;
    }

    public List<Control> getControles() {
        return controles;
    }

    public void setControles(List<Control> controles) {
        this.controles = controles;
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
