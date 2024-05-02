import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ConversorMoneda conversor = new ConversorMoneda("USD");
        InterfazUsuario interfaz = new InterfazUsuario(conversor);
        interfaz.Menu();
    }
}

class InterfazUsuario {
    final ConversorMoneda conversor;
    final Scanner lectura;

    public InterfazUsuario(ConversorMoneda conversor) {
        this.conversor = conversor;
        this.lectura = new Scanner(System.in);
    }

    public void Menu() {
        String menu = """
                ***************************************************
                Sea bienvenido/a al conversor de Moneda
                
                1 - Dólar =>> Peso Argentino
                2 - Peso Argentino =>> Dólar
                3 - Dólar =>> Real brasileño
                4 - Real brasileño =>> Dólar
                5 - Dólar =>> Peso colombiano
                6 - Peso colombiano =>> Dólar
                7 - Salir
                Elija una opción válida:
                ***************************************************
                """;

        int opcion = 0;
        double cantidad;
        String monedaOrigen, monedaDestino;

        while (opcion != 7) {
            System.out.println(menu);

            if (lectura.hasNextInt()) {
                opcion = lectura.nextInt();
                lectura.nextLine();
            } else {
                System.out.println("Error: Ingrese un número válido.\n\n");
                lectura.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    cantidad = obtenerCantidad();
                    monedaOrigen = "USD";
                    monedaDestino = "ARS";
                    double resultado1 = conversor.convertir(cantidad, monedaOrigen, monedaDestino);
                    System.out.println("El valor " + cantidad +" "+monedaOrigen+" corresponde al valor final de =>>> " + resultado1 + " " +monedaDestino +"\n");
                    break;
                case 2:
                    cantidad = obtenerCantidad();
                    monedaOrigen = "ARS";
                    monedaDestino = "USD";
                    double resultado2 = conversor.convertir(cantidad, monedaOrigen, monedaDestino);
                    System.out.println("El valor " + cantidad +" "+monedaOrigen+" corresponde al valor final de =>>> " + String.format("%.4f", resultado2) + " " +monedaDestino +"\n");
                    break;
                case 3:
                    cantidad = obtenerCantidad();
                    monedaOrigen = "USD";
                    monedaDestino = "BRL";
                    double resultado3 = conversor.convertir(cantidad, monedaOrigen, monedaDestino);
                    System.out.println("El valor " + cantidad +" "+monedaOrigen+" corresponde al valor final de =>>> " + resultado3 + " " +monedaDestino +"\n");
                    break;
                case 4:
                    cantidad = obtenerCantidad();
                    monedaOrigen = "BRL";
                    monedaDestino = "USD";
                    double resultado4 = conversor.convertir(cantidad, monedaOrigen, monedaDestino);
                    System.out.println("El valor " + cantidad +" "+monedaOrigen+" corresponde al valor final de =>>> " + String.format("%.4f", resultado4)+ " " +monedaDestino +"\n");
                    break;
                case 5:
                    cantidad = obtenerCantidad();
                    monedaOrigen = "USD";
                    monedaDestino = "COP";
                    double resultado5 = conversor.convertir(cantidad, monedaOrigen, monedaDestino);
                    System.out.println("El valor " + cantidad +" "+monedaOrigen+" corresponde al valor final de =>>> " + resultado5 + " " +monedaDestino +"\n");
                    break;
                case 6:
                    cantidad = obtenerCantidad();
                    monedaOrigen = "COP";
                    monedaDestino = "USD";
                    double resultado6 = conversor.convertir(cantidad, monedaOrigen, monedaDestino);
                    System.out.println("El valor " + cantidad + " " + monedaOrigen + " corresponde al valor final de =>>> " + String.format("%.7f", resultado6) + " " + monedaDestino +"\n");

                    break;
                case 7:
                    System.out.println("Saliendo del programa, gracias por utilizar nuestros servicios");
                    break;
                default:
                    System.out.println("Opción no válida\n");
            }
        }
    }
    private double obtenerCantidad() {
        System.out.println("Ingrese el valor que deseas converter:");
        double cantidad;
        while (true) {
            if (lectura.hasNextDouble()) {
                cantidad = lectura.nextDouble();
                break;
            } else {
                System.out.println("Error: Ingrese un número válido.");
                System.out.println("Ingrese la cantidad nuevamente:");
                lectura.nextLine();
            }
        }
        return cantidad;
    }
}



