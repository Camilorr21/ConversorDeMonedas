package com.camilo.ConversorDeMonedas.service;

import com.camilo.ConversorDeMonedas.model.ConversionRates;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIClient {

    public static ConversionRates getConversionRates(String monedaBase) throws IOException, InterruptedException {
        String direccion = "https://v6.exchangerate-api.com/v6/faf7ada849dd38bdda536c85/latest/" + monedaBase;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);

        if (jsonObject.has("conversion_rates")) {
            JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");
            return new ConversionRates(rates);
        } else {
            System.out.println("Error: No se pudo obtener las tasas de conversión.");
            return null;
        }
    }
}
