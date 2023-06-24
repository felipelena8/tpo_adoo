package models.utils;

import models.ExportarFicha.TipoExportacion;
import models.adopcion.Cliente;
import models.adopcion.PreferenciaRecordatorio;
import models.alarma.Alarma;
import models.alarma.AlarmaDTO;
import models.animal.Control;
import models.animal.FichaMedica;
import models.animal.RegistroMedico;
import models.animal.TratamientoMedico;
import models.animal.Accion;
import models.controllers.ControllerAlarmas;
import models.controllers.ControllerFichasMedicas;
import models.controllers.ControllerUsuarios;
import models.usuarios.Veterinario;
import models.usuarios.Visitante;
import vistas.VistaCliente;
import vistas.VistaControl;
import vistas.VistaFichaMedica;
import vistas.VistaTratamientoMedico;

import javax.swing.*;
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
            preferenciaRecordatorio = PreferenciaRecordatorio.valueOf(Input.inputTexto("Ingrese la preferencia de notificacion: SMS, EMAIL, WHATSAPP").toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("La preferencia ingresada no existe");
            return;
        }
        int cantDiasPreAviso = Input.inputEntero("Ingrese cuantos dias antes de realizar el seguimiento quiere recibir un aviso: ");
        System.out.println("Ingrese la periodicidad con la que se realizaran las visitas");
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
        System.out.println("Ingrese el periodo ");
        Periodo periodicidad = Periodo.crear();
        Date fechaInicio = new Date();
        AlarmaDTO alarmaDTO = new AlarmaDTO(nombre, periodicidad, fechaInicio, registroMedico);
        ControllerAlarmas.getInstancia().crearAlarma(alarmaDTO);
    }

    public static void atenderAlarma(Alarma alarma){
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Ingresa ATENDER para atender");
//        String respuesta =sc.nextLine();
        int resp = JOptionPane.showConfirmDialog(null, "Deseas atender la alarma " + alarma.getNombre());
        if(resp== JOptionPane.OK_OPTION){
            alarma.atender((Veterinario) ControllerUsuarios.getUsuarioLoggeado());
            alarma.atender(new Veterinario("veterinario20", "veterinario20", "Pepe", "Dominguez"));
        }else{
            alarma.atender(new Veterinario("veterinario4", "contrasena4", "Laura", "Fernández"));
        }
    }
}
