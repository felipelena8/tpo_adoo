package vistas;

import models.adopcion.Encuesta;
import models.adopcion.EscalaValoracion;
import models.adopcion.SeguimientoAnimal;
import models.adopcion.Visita;
import models.animal.FichaMedica;
import models.animal.acciones.Accion;
import models.controllers.ControllerAlarmas;
import models.controllers.ControllerUsuarios;
import models.usuarios.TipoUsuario;
import models.utils.Input;
import models.utils.Periodo;
import models.utils.UtilsVista;

import java.util.Date;
import java.util.List;

public class VistaFichaMedica {
    private static FichaMedica fichaMedica;
    private static String menuVeterinario = "0. Volver\n" +
            "1. Adoptar animal\n" +
            "2. Iniciar tratamiento medico\n" +
            "3. Iniciar control\n" +
            "4. Buscar control\n" +
            "5. Buscar tratamiento medico\n" +
            "6. Ver tratamientos medicos\n" +
            "7. Ver controles\n" +
            "8. Ver seguimiento animal\n" +
            "9. Exportar ficha medica";

    private static String menuVisitante = "0. Volver\n" +
            "1. Adoptar animal\n" +
            "2. Buscar control\n" +
            "3. Buscar tratamiento medico\n" +
            "4. Ver tratamientos medicos\n" +
            "5. Ver controles\n" +
            "6. Exportar ficha medica\n" +
            "7. Cargar Visita\n" +
            "8. Ver seguimiento animal";

    public VistaFichaMedica(FichaMedica fichaMedica) {
        VistaFichaMedica.fichaMedica = fichaMedica;
    }

    private static FichaMedica getFichaMedica() {
        return fichaMedica;
    }

    public static boolean desplegarMenu() {

        if (ControllerUsuarios.getInstancia().getTipoUsuario() == TipoUsuario.VETERINARIO) {
            System.out.println(menuVeterinario);
            int opcion = Input.inputEntero("Ingrese la opcion: ");
            while (opcion > 9 || opcion < 0) {
                opcion = Input.inputEntero("Debe ingresar una opcion en el rango que se muestra: ");
            }
            switch (opcion) {
                case 0:
                    return false;
                case 1:
                    UtilsVista.adopcionAnimal(fichaMedica);
                    break;
                case 2:
                    List<Accion> accionList = UtilsVista.crearAcciones();
                    String enfermedad = Input.inputTexto("Ingrese la enfermedad por la que se lo tratara: ");
                    fichaMedica.iniciarTratamiento(accionList, enfermedad);
                    break;
                case 3:
                    accionList = UtilsVista.crearAcciones();
                    String nombre = Input.inputTexto("Ingrese el nombre del control: ");
                    fichaMedica.iniciarControl(accionList, nombre);
                    break;
                case 4:
                    UtilsVista.buscarControlVista(fichaMedica);
                    break;
                case 5:
                    UtilsVista.buscarTratamientoMedicoVista(fichaMedica);
                    break;
                case 6:
                    fichaMedica.verTratamientosMedicos();
                    break;
                case 7:
                    fichaMedica.verControles();
                    break;
                case 8:
                    fichaMedica.verSeguimientoAnimal();
                case 9:
                    UtilsVista.exportarFichaMedica(fichaMedica);
                    break;
            }
        } else {
            System.out.println(menuVisitante);
            int opcion = Input.inputEntero("Ingrese la opcion: ");
            while (opcion > 8 || opcion < 0) {
                opcion = Input.inputEntero("Debe ingresar una opcion en el rango que se muestra: ");
            }
            switch (opcion) {
                case 0:
                    return false;
                case 1:
                    UtilsVista.adopcionAnimal(fichaMedica);
                    break;
                case 2:
                    UtilsVista.buscarControlVista(fichaMedica);
                    break;
                case 3:
                    UtilsVista.buscarTratamientoMedicoVista(fichaMedica);
                    break;
                case 4:
                    fichaMedica.verTratamientosMedicos();
                    break;
                case 5:
                    fichaMedica.verControles();
                    break;
                case 6:
                    UtilsVista.exportarFichaMedica(fichaMedica);
                    break;
                case 7:
                    System.out.println("Complete la siguiente encuesta sobre su visita calificando cada aspecto en BUENO, REGULAR o MALO:\n");
                    EscalaValoracion estadoAnimal = EscalaValoracion.valueOf(Input.inputTexto("Califique el estado del animal: "));
                    EscalaValoracion limpiezaLugar = EscalaValoracion.valueOf(Input.inputTexto("Califique la limpieza del hogar: "));
                    EscalaValoracion ambiente = EscalaValoracion.valueOf(Input.inputTexto("Califique el ambiente del hogar: "));
                    System.out.println();
                    fichaMedica.getSeguimientoAnimal().agregarVisita(new Visita(new Encuesta(estadoAnimal, limpiezaLugar, ambiente), new Date()));
                    SeguimientoAnimal seguimientoAnimal = ControllerAlarmas.getInstancia().buscarSeguimientoAnimal(fichaMedica.getSeguimientoAnimal().getCliente().getNombre(), fichaMedica.getSeguimientoAnimal().getFechaAdopcion());
                    System.out.println("Desea programar una nueva visita ?\n");
                    System.out.println("0. Si");
                    System.out.println("1. No");
                    int opcionNuevaVisita = Input.inputEntero("Ingrese la opcion: ");
                    switch (opcionNuevaVisita) {
                        case 0:
                            int cantDiasPreAviso = Input.inputEntero("Ingrese cuantos dias antes de realizar el seguimiento quiere recibir un aviso: ");
                            Periodo periodo = Periodo.crear();
                            seguimientoAnimal.setCadenciaVisita(periodo);
                            seguimientoAnimal.setDiasPreAviso(cantDiasPreAviso);
                            seguimientoAnimal.setSeguirAnimal(true);
                            break;
                        case 1:
                            seguimientoAnimal.setSeguirAnimal(false);
                            break;
                    }
                    break;
                case 8:
                    fichaMedica.verSeguimientoAnimal();
            }
        }
        return true;
    }
}