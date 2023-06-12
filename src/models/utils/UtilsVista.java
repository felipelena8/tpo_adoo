package models.utils;

import models.ExportarFicha.TipoExportacion;
import models.adopcion.Cliente;
import models.adopcion.PreferenciaRecordatorio;
import models.alarma.AlarmaDTO;
import models.animal.Control;
import models.animal.FichaMedica;
import models.animal.RegistroMedico;
import models.animal.TratamientoMedico;
import models.animal.acciones.Accion;
import models.controllers.ControllerAlarmas;
import models.controllers.ControllerFichasMedicas;
import models.controllers.ControllerUsuarios;
import models.usuarios.Visitante;
import vistas.VistaCliente;
import vistas.VistaControl;
import vistas.VistaFichaMedica;
import vistas.VistaTratamientoMedico;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UtilsVista {

    public static List<Accion> crearAcciones() {
        List<Accion> acciones = new ArrayList<>();
        String nombre = Input.inputTexto("Ingrese el nombre de la accion. -1 para finalizar el ingreso");
        while (!nombre.equals("-1")) {
            acciones.add(new Accion(nombre));
            nombre = Input.inputTexto("Ingrese el nombre de la accion. -1 para finalizar el ingreso");
        }
        return acciones;
    }

    public static void buscarTratamientoMedicoVista(FichaMedica fichaMedica) {
        String enfermedad = Input.inputTexto("Ingrese el nombre del tratamiento medico: ");
        TratamientoMedico tratamiento = fichaMedica.buscarTratamientoMedico(enfermedad);
        if (tratamiento != null) {
            VistaTratamientoMedico.setTratamientoMedico(tratamiento);
            while (VistaTratamientoMedico.desplegarMenu()) ;
        } else {
            System.out.println("No existe el tratamiento medico");
        }
    }

    public static void buscarControlVista(FichaMedica fichaMedica) {
        String nombre = Input.inputTexto("Ingrese el nombre del control: ");
        Control control = fichaMedica.buscarControl(nombre);
        if (control != null) {
            VistaControl.setControl(control);
            while (VistaControl.desplegarMenu()) ;
        } else {
            System.out.println("No existe el control");
        }
    }

    public static void adopcionAnimal(FichaMedica fichaMedica) {
        Cliente cliente = VistaCliente.buscarCliente();
        if (cliente == null) {
            System.out.println("No se ha encontrado ningun cliente");
            return;
        }
        String username = Input.inputTexto("Ingrese el username del visitador a cargo");
        Visitante visitante = ControllerUsuarios.getInstancia().buscarVisitante(username);
        if (visitante == null) {
            System.out.println("No existe ningun visitante con ese nombre de usuario");
            return;
        }
        PreferenciaRecordatorio preferenciaRecordatorio;
        try {
            preferenciaRecordatorio = PreferenciaRecordatorio.valueOf(Input.inputTexto("Ingrese la preferencia de notificacion: SMS, EMAIL, WHATSAPP"));
        } catch (IllegalArgumentException e) {
            System.out.println("La preferencia ingresada no existe");
            return;
        }
        int cantDiasPreAviso = Input.inputEntero("Ingrese cuantos dias antes de realizar el seguimiento quiere recibir un aviso: ");//TODO VER Q ONDA CON EL VISITANTE EN EL ADAPTER
        ControllerFichasMedicas.getInstancia().adoptarAnimal(fichaMedica, cliente, visitante, preferenciaRecordatorio, Periodo.crear(), cantDiasPreAviso);
    }

    public static void exportarFichaMedica(FichaMedica fichaMedica) {
        try {
            TipoExportacion tipoExportacion = TipoExportacion.valueOf(Input.inputTexto("Elige el formato en el que desea exportar la ficha medica: Excel o PDF").toUpperCase());
            fichaMedica.exportarFicha(tipoExportacion);
        } catch (IllegalArgumentException e) {
            System.out.println("El tipo de exportacion elegido no existe");
        }
    }

    public static void buscarFichaMedica() {
        int numeroFicha = Input.inputEntero("Ingrese el numero de la ficha medica: ");
        FichaMedica fichaMedica = ControllerFichasMedicas.getInstancia().buscarFichaMedica(numeroFicha);
        if (fichaMedica == null) {
            System.out.println("No existe una ficha medica con ese numero\n");
        } else {
            new VistaFichaMedica(fichaMedica);
            while (VistaFichaMedica.desplegarMenu()) ;
        }
    }

    public static void crearAlarma(RegistroMedico registroMedico) {
        String nombre = Input.inputTexto("Ingrese el nombre de la alarma");
        Periodo periodicidad = Periodo.crear();
        Date fechaInicio = new Date();
        AlarmaDTO alarmaDTO = new AlarmaDTO(nombre, periodicidad, fechaInicio, registroMedico);
        ControllerAlarmas.getInstancia().crearAlarma(alarmaDTO);
    }

}
