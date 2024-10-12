package com.camilo.ConversorDeMonedas.main;


import com.camilo.ConversorDeMonedas.service.ConversorService;
import com.camilo.ConversorDeMonedas.utils.InputHandler;


public class ConversorMonedas {

    public static void main(String[] args) throws Exception {
        ConversorService conversorService = new ConversorService();
        int opcion = 0;
        String menu = """
                \n********************************************************
                Bienvenido/a al conversor de moneda :)
                \n1) Dolar => Peso argentino
                2) Peso argentino => Dolar
                3) Dolar => Peso brasileño
                4) Peso brasileño => Dolar
                5) Dolar => Peso Colombiano
                6) Peso Colombiano => Dolar
                7) Salir
                ********************************************************
                """;

        while (opcion != 7) {
            System.out.println(menu);
            opcion = InputHandler.getIntInput("Selecciona una opción: ");

            if (opcion >= 1 && opcion <= 6) {
                double cantidad = InputHandler.getDoubleInput("Escribe la cantidad en la moneda seleccionada: ");
                conversorService.convertir(opcion, cantidad);
            } else if (opcion == 7) {
                System.out.println("Saliendo del programa...");
            } else {
                System.out.println("Opción no válida, por favor elige una opción válida.");
            }
        }
    }
}
