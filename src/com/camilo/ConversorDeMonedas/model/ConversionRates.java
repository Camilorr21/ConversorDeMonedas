package com.camilo.ConversorDeMonedas.model;

import com.google.gson.JsonObject;

public class ConversionRates {
    private JsonObject rates;

    public ConversionRates(JsonObject rates) {
        this.rates = rates;
    }

    public double getRate(String currency) {
        if (rates != null && rates.has(currency)) {
            return rates.get(currency).getAsDouble();
        } else {
            System.out.println("No se encontró la tasa para la moneda: " + currency);
            return -1; // Devuelve un valor de error si no se encuentra la tasa
        }
    }
}
