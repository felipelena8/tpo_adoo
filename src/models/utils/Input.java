package models.utils;

import java.util.Scanner;

public class Input {
    private static Scanner sc = new Scanner(System.in);

    public static String inputTexto(String mensaje) {
        System.out.println(mensaje);
        return sc.nextLine();
    }

    public static int inputEntero(String mensaje) {
        int numero = -1;
        while (numero == -1) {
            try {
                System.out.println(mensaje);
                numero = sc.nextInt();

            } catch (Exception e) {
                System.out.println("Debes ingresar un valor entero");
                sc.nextLine();
            }
        }
        sc.nextLine();
        return numero;
    }

    public static double inputDouble(String mensaje) {
        double numero = -1;
        while (numero == -1) {
            try {
                System.out.println(mensaje);
                numero = sc.nextDouble();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Debes ingresar un valor numerico");
                sc.nextLine();
            }
        }
        return numero;
    }

}
