# Conversor de monedas en Java utilizando [Intellij IDEA Community](https://www.jetbrains.com/idea/download/?section=linux)
> Curso de [Alura Latam](https://www.youtube.com/@AluraLatam)
<p align="center">
  <img src="https://i.imgur.com/ABp2MGC.png">
</p>

## Scanner
<p>Se Utilizo Scanner para poder pedirle al usuario los datos, y todo ello se almacene en teclado</p>

- Agregamos el siguiente codigo para usar Scanner
``` Java
import java.util.Scanner;
Scanner escritura = new Scanner(System.in);
```

## Ciclo While
El ciclo While nos permitió usar el case de mejor manera ya que al seleccionar un numero diferente a 7 el ciclo seguira continuando, pero al poner el numero 7. el ciclo terminará
``` Java
 while (opciones != 7) {
                conversor.verMenu();
                System.out.println("Ingresa una opción válida");
                opciones = escritura.nextInt();
                if (opciones != 7) {
                    System.out.println("Ingresa el valor que deseas convertir:");
                    valor = escritura.nextDouble();
                }stem.out.println("Media de evaluación de los usuarios: " + mediaEvaluacionUsuario / 3);
    }
```

## Uso de Case
Utilizamos case para, dependiendo de la selección del usuario, realizar la función específica. En este ejemplo usamos 6 opciones y una opción extra para salir.
``` Java
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
```

## Clase Monedas
Este record llamado Monedas tiene un único campo: conversion_rates, que es un Map<String, Double>. Esto permite que, al deserializar el JSON, las tasas de conversión se almacenen en este mapa, facilitando su acceso y manipulación.
