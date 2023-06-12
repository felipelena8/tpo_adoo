package vistas;

public class VistaMenuVisitante {
    private static String menu = "0. Cerrar sesion\n" +
            "1. Listar fichas medicas\n" +
            "2. Buscar ficha medica por numero\n" +
            "3. Crear nueva ficha medica\n" +
            "4. Realizar adopcion de animal";

    public static boolean desplegarMenu() {
        System.out.println(menu);
        return false;
    }
}
