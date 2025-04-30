package com.nosakaking.conversor.modelos;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ConversorMonedas {
    public Monedas FiltrarMonedas(String conversionBase) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/c9fa9cf3498a164fe7198d7b/latest/" + conversionBase);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Monedas.class);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo recibir el recurso");
        }

    }
    public void verMenu() {
        System.out.println("""
                    Bienvenido al mejor sistema de conversor de monedas
                    *************************************************
                    1) Dólar =>> Peso Argentino
                    2) Peso argentino ==> Dólar
                    3) Dólar ==> Real brasileño
                    4) Real brasileño ==> Dólar
                    5) Dólar ==> Peso colombiano
                    6) Peso colombiano ==> Dólar
                    7) Salir
                    ************************************
                    """);
    }
    public void ConvertirMoneda(int opciones, double monedaConversion, String conversionBase) {
        Monedas tasas = FiltrarMonedas(conversionBase);
        Map<String, Double> conversiones = tasas.conversion_rates();
        double resultado = 0.0;
        Double tasaUsd = conversiones.get("USD");
        switch (opciones) {
            case 1:
                Double tasaArs = conversiones.get("ARS");
                resultado = monedaConversion * tasaArs;
                System.out.println("El valor "  + monedaConversion + " [USD] corresponde al valor final de ==> " + resultado + " [ARS]");
                break;
            case 2:
                resultado = monedaConversion * tasaUsd;
                System.out.println("El valor "  + monedaConversion + " [ARS] corresponde al valor final de ==> " + resultado + " [USD]");
                break;
            case 3:
                Double tasaBrl = conversiones.get("BRL");
                resultado = monedaConversion * tasaBrl;
                System.out.println("El valor "  + monedaConversion + " [USD] corresponde al valor final de ==> " + resultado + " [BRL]");
                break;
            case 4:
                resultado = monedaConversion * tasaUsd;
                System.out.println("El valor "  + monedaConversion + " [BRL] corresponde al valor final de ==> " + resultado + " [USD]");
                break;
            case 5:
                Double tasaCop = conversiones.get("COP");
                resultado = monedaConversion * tasaCop;
                System.out.println("El valor "  + monedaConversion + " [USD] corresponde al valor final de ==> " + resultado + " [COP]");
                break;
            case 6:
                resultado = monedaConversion * tasaUsd;
                System.out.println("El valor "  + monedaConversion + " [COP] corresponde al valor final de ==> " + resultado + " [USD]");
                break;
            default:

        }
    }
}
