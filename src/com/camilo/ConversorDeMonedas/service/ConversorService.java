package com.camilo.ConversorDeMonedas.service;

import com.camilo.ConversorDeMonedas.model.ConversionRates;

public class ConversorService {

    public void convertir(int opcion, double cantidad) throws Exception {
        String monedaBase = "USD";
        String monedaDestino = "";

        switch (opcion) {
            case 1 -> monedaDestino = "ARS";  // Dólar a Peso Argentino
            case 2 -> {
                monedaBase = "ARS";  // Peso Argentino a Dólar
                monedaDestino = "USD";
            }
            case 3 -> monedaDestino = "BRL";  // Dólar a Peso Brasileño
            case 4 -> {
                monedaBase = "BRL";  // Peso Brasileño a Dólar
                monedaDestino = "USD";
            }
            case 5 -> monedaDestino = "COP";  // Dólar a Peso Colombiano
            case 6 -> {
                monedaBase = "COP";  // Peso Colombiano a Dólar
                monedaDestino = "USD";
            }
        }

        // Llamar al servicio APIClient para obtener la tasa de cambio
        ConversionRates rates = APIClient.getConversionRates(monedaBase);

        if (rates == null) {
            System.out.println("Error: No se pudieron obtener las tasas de conversión.");
            return;
        }

        double tasaCambio = rates.getRate(monedaDestino);

        if (tasaCambio == -1) {
            System.out.println("Error: No se encontró la tasa de cambio.");
            return;
        }

        // Realizar la conversión
        double resultado = cantidad * tasaCambio;
        System.out.println("La tasa de cambio de " + monedaBase + " a " + monedaDestino + " es: " + tasaCambio);
        System.out.println("El valor convertido es: " + resultado);
    }
}
