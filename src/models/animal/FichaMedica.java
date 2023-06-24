package models.animal;

import models.ExportarFicha.ExportadorFichaMedica;
import models.ExportarFicha.ExportarExcel;
import models.ExportarFicha.ExportarPDF;
import models.ExportarFicha.TipoExportacion;
import models.adopcion.SeguimientoAnimal;
import models.adopcion.Visita;

import java.util.ArrayList;
import java.util.List;

public class FichaMedica {
    private Animal animal;
    private List<TratamientoMedico> tratamientos;
    private List<Control> controles;
    private ExportadorFichaMedica exportarFicha;
    private SeguimientoAnimal seguimientoAnimal;

    public FichaMedica(Animal animal) {
        this.animal = animal;
        tratamientos = new ArrayList<>();
        controles = new ArrayList<>();
        exportarFicha = new ExportadorFichaMedica();
        seguimientoAnimal = null;
    }

    public ExportadorFichaMedica getExportarFicha() {
        return exportarFicha;
    }

    public void setExportarFicha(ExportadorFichaMedica exportarFicha) {
        this.exportarFicha = exportarFicha;
    }

    public boolean tratamientosFinalizados() {
        for (TratamientoMedico tratamiento : tratamientos) {
            if (!tratamiento.estaFinalizado()) {
                return false;
            }
        }
        return true;
    }

    public void iniciarTratamiento(List<Accion> acciones, String enfermedad) {
        if (buscarTratamientoMedico(enfermedad) == null) {
            tratamientos.add(new TratamientoMedico(acciones, enfermedad));
            System.out.println("Tratamiento por " + enfermedad + " iniciado");
        } else {
            System.out.println("Ya se esta tratando al animal por " + enfermedad);
        }
    }

    public void pausarControles() {
        for (Control control : controles) {
            control.pausar();
        }
    }

    public boolean estaAdoptado(){
        return seguimientoAnimal!=null;
    }

    public void iniciarControl(List<Accion> acciones, String nombre) {
        controles.add(new Control(acciones, nombre));
    }

    public TratamientoMedico buscarTratamientoMedico(String enfermedad) {
        return tratamientos.stream().filter(tratamientoMedico -> tratamientoMedico.getEnfermedad().equals(enfermedad)).findFirst().orElse(null);
    }

    public Control buscarControl(String nombre) {
        return controles.stream().filter(control -> control.getNombre().equals(nombre)).findFirst().orElse(null);
    }

    public boolean puedeSerAdoptado() {
        boolean puedeSerAdopotado = animal.isDomestico() && tratamientosFinalizados();
        if (puedeSerAdopotado) {
            System.out.println("El animal puede ser adoptado");
        } else {
            if (!animal.isDomestico()) {
                System.out.println("El animal no puede ser adoptado ya que no es domestico");
            } else {
                System.out.println("El animal no puede ser adoptado ya que sus tratamientos medicos no han sido finalizado");
            }
        }
        return puedeSerAdopotado;
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

    public void exportarFicha(TipoExportacion tipoExportacion) {
        switch (tipoExportacion) {
            case PDF -> exportarFicha.cambiarEstrategiaExportacion(new ExportarPDF());
            case EXCEL -> exportarFicha.cambiarEstrategiaExportacion(new ExportarExcel());
        }
        exportarFicha.exportarFichaMedica(this);
    }

    public SeguimientoAnimal getSeguimientoAnimal() {
        return seguimientoAnimal;
    }

    public void setSeguimientoAnimal(SeguimientoAnimal seguimientoAnimal) {
        this.seguimientoAnimal = seguimientoAnimal;
    }

    public void verTratamientosMedicos() {
        System.out.println("Enfermedad | Estado");
        for (TratamientoMedico tratamientoMedico : tratamientos) {
            System.out.println(tratamientoMedico.getEnfermedad() + " | " + (tratamientoMedico.estaFinalizado() ? "Finalizado" : "En curso"));
        }
    }

    public void verControles() {
        System.out.println("Nombre | Acciones");
        for (Control control : controles) {
            System.out.println(control.getNombre() + " | " + control.getAcciones());
        }
    }

    public void verSeguimientoAnimal() {
        if (seguimientoAnimal != null) {
            System.out.println("Visitador: " + seguimientoAnimal.getResponsable().getNombre());
            System.out.println("Visitas: \n");
            if (seguimientoAnimal.getVisitas() != null && !seguimientoAnimal.getVisitas().isEmpty()) {
                for (Visita visita : seguimientoAnimal.getVisitas()) {
                    System.out.println("Fecha de Visita: " + visita.getFecha());
                    System.out.println("Encuesta:");
                    System.out.println("Estado del animal: " + visita.getEncuesta().getEstadoAnimal().toString());
                    System.out.println("Limpieza del hogar: " + visita.getEncuesta().getLimpiezaLugar().toString());
                    System.out.println("Ambiente: " + visita.getEncuesta().getAmbiente().toString() + "\n");
                }
            } else {
                System.out.println("Aun no se realizo ninguna visita.\n");
            }
        } else {
            System.out.println("Sin Seguimiento\n");
        }
    }
}
