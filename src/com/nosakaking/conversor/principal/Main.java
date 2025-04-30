package com.nosakaking.conversor.principal;

import com.nosakaking.conversor.modelos.ConversorMonedas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner escritura = new Scanner(System.in);
        ConversorMonedas conversor = new ConversorMonedas();
        double valor = 0;
        int opciones = 0;
        try {
            while (opciones != 7) {
                conversor.verMenu();
                System.out.println("Ingresa una opción válida");
                opciones = escritura.nextInt();
                if (opciones != 7) {
                    System.out.println("Ingresa el valor que deseas convertir:");
                    valor = escritura.nextDouble();
                }
                switch (opciones) {
                    case 1:
                        conversor.ConvertirMoneda(1, valor, "USD");
                        break;
                    case 2:
                        conversor.ConvertirMoneda(2, valor, "ARS");
                        break;
                    case 3:
                        conversor.ConvertirMoneda(3, valor, "USD");
                        break;
                    case 4:
                        conversor.ConvertirMoneda(4, valor, "BRL");
                        break;
                    case 5:
                        conversor.ConvertirMoneda(5, valor, "USD");
                        break;
                    case 6:
                        conversor.ConvertirMoneda(6, valor, "COP");
                        break;
                    case 7:
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;

                }
            }
        }catch (Exception e) {
            System.out.println("Error " +e);
        }

    }
}