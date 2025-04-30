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
``` Java
public record Monedas(Map<String, Double> conversion_rates) {}

```

## Clase ConversorMonedas
Esta clase forma parte del paquete com.nosakaking.conversor.modelos y tiene como objetivo principal realizar conversiones entre diferentes monedas utilizando datos obtenidos de una API externa.
## Método FiltrarMoneda
Este método realiza una solicitud HTTP a la API de ExchangeRate-API para obtener las tasas de conversión actuales basadas en una moneda base proporcionada.
``` Java
  public Monedas filtrarMonedas(String conversionBase) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/XXXXXXXXXXXXXXX/latest/" + conversionBase);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Monedas.class);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo recibir el recurso");
        }

    }
```
## Método VerMenú
Muestra un menú interactivo en la consola para que el usuario seleccione la conversión de moneda que desea realizar.
``` Java
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
```
## ConvertirMoneda
Realiza la conversión de moneda basada en la opción seleccionada por el usuario.
Dependiendo de la opción seleccionada (opciones), realiza la conversión correspondiente:

- Opción 1: Convierte de Dólar a Peso Argentino utilizando la tasa de "ARS".
- Opción 2: Convierte de Peso Argentino a Dólar utilizando la tasa de "USD".
- Opción 3: Convierte de Dólar a Real Brasileño utilizando la tasa de "BRL".
- Opción 4: Convierte de Real Brasileño a Dólar utilizando la tasa de "USD".
- Opción 5: Convierte de Dólar a Peso Colombiano utilizando la tasa de "COP".
- Opción 6: Convierte de Peso Colombiano a Dólar utilizando la tasa de "USD".


Imprime en la consola el resultado de la conversión.​


``` Java
 public void convertirMoneda(int opciones, double monedaConversion, String conversionBase) {
        Monedas tasas = filtrarMonedas(conversionBase);
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
```

<p align="center">
  <img src="https://i.imgur.com/w6jWEVR.png">
</p>
