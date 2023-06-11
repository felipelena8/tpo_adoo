package models.ExportarFicha;

import models.animal.FichaMedica;

public class ExportarPDF implements EstrategiaExportacion {
    @Override
    public void exportarFichaMedica(FichaMedica ficha) {
        System.out.println("Se ha exportado la ficha medica: fichaMedica" + ficha.getAnimal().getNombre() + ".pdf");
    }
}
