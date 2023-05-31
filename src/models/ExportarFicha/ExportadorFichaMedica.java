package models.ExportarFicha;

import models.FichaMedica;

public class ExportadorFichaMedica {
    private EstrategiaExportacion estrategia;
    public void cambiarEstrategiaExportacion(EstrategiaExportacion estrategia){
       this.estrategia = estrategia;
    }
    public void exportarFichaMedica(FichaMedica fichaMedica){
        estrategia.exportarFichaMedica(fichaMedica);
    }
}
