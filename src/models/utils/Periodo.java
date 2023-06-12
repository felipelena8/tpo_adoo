package models.utils;

public class Periodo {

    private int meses;
    private int dias;
    private int horas;
    private int minutos;
    private int segundos;

    private Periodo(int dias) {
        this.dias = dias;
    }

    private Periodo(int meses, int dias, int horas, int minutos, int segundos) {
        this.meses = meses;
        this.dias = dias;
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public static Periodo crear() {
        int meses = Input.inputEntero("Ingrese la cantidad de meses:");
        int dias = Input.inputEntero("Ingrese la cantidad de dias:");
        int horas = Input.inputEntero("Ingrese la cantidad de horas:");
        int minutos = Input.inputEntero("Ingrese la cantidad de minutos:");
        int segundos = Input.inputEntero("Ingrese la cantidad de segundos:");
        return crear(meses, dias, horas, minutos, segundos);
    }

    public static Periodo crear(int meses, int dias, int horas, int minutos, int segundos) {
        if (segundos < 0 || dias < 0 || horas < 0 || minutos < 0 || meses < 0) {
            return null;
        } else {
            return new Periodo(meses, dias, horas, minutos, segundos);
        }
    }

    public static Periodo crear(int dias) {
        if (dias < 0) {
            return null;
        } else {
            return new Periodo(dias);
        }
    }

    public long pasarAMilisegundos() {
        int dias = getMeses() * 30 + getDias();
        int horas = getHoras() + dias * 24;
        int minutos = getMinutos() + horas * 60;
        long segundos = getSegundos() + minutos * 60;
        return segundos * 1000;
    }

    public int getMeses() {
        return meses;
    }

    public int getDias() {
        return dias;
    }

    public int getHoras() {
        return horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }


}
