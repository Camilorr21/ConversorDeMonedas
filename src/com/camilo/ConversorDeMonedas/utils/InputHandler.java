package com.camilo.ConversorDeMonedas.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {

    private static final Scanner teclado = new Scanner(System.in);

    public static int getIntInput(String message) {
        int input = 0;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.println(message);
                input = teclado.nextInt();
                valid = true;  // Entrada válida
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número entero.");
                teclado.nextLine(); // Limpiar la entrada no válida
            }
        }

        return input;
    }

    public static double getDoubleInput(String message) {
        double input = 0;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.println(message);
                input = teclado.nextDouble();
                valid = true;  // Entrada válida
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número decimal.");
                teclado.nextLine(); // Limpiar la entrada no válida
            }
        }

        return input;
    }
}
