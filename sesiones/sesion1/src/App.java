// Hello World
/* public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
} */


// Ejemplo 1 y 2: Estructura condicional simple y doble
/* import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
 
            System.out.println("Ingrese la cantidad en bodega:");
            int cant_bodega = lea.nextInt();
 
        System.out.println("Ingrese la cantidad mínima requerida:");
        int cant_requerida = lea.nextInt();
 
        if (cant_bodega > cant_requerida)
            System.out.println("No es necesario realizar pedido");
 
        else 
            System.out.println("Es necesario realizar pedido");
 
        lea.close();
 
    }
} */


// Ejemplo 3: Estructura condicional múltiple
/* import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
 
            System.out.println("Ingrese la cantidad en bodega:");
            int cant_bodega = lea.nextInt();
 
        System.out.println("Ingrese la cantidad mínima requerida:");
        int cant_requerida = lea.nextInt();
 
        if (cant_bodega > cant_requerida) {

            System.out.println("No es necesario realizar pedido.");
            int restante = cant_bodega-cant_requerida;
            System.out.println("Faltan por vender " + (restante) + " unidades.");
            if (restante < 10)
                System.out.println("Alerta generada.");

        }

        else
            System.out.println("Es necesario realizar pedido.");
 
        lea.close();
 
    }
} */


// Ejemplo 3: Estructura condicional anidado
/* import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
 
            System.out.println("Ingrese la cantidad en bodega:");
            int cant_bodega = lea.nextInt();
 
        System.out.println("Ingrese la cantidad mínima requerida:");
        int cant_requerida = lea.nextInt();
 
        if (cant_bodega > cant_requerida) {

            System.out.println("No es necesario realizar pedido.");
            int restante = cant_bodega-cant_requerida;
            System.out.println("Faltan por vender " + (restante) + " unidades.");
            if (restante < 10)
                System.out.println("Alerta generada.");

        }
        else {

            System.out.println("Es necesario realizar pedido.");
            System.out.println("Ingrese las cantidades de compra deseadas:");
            int cant_compra = lea.nextInt();
            System.out.println("Ingrese el valor de compra:");
            int valor_compra = lea.nextInt();
            System.out.println("Ingrese el valor en caja:");
            int valor_caja = lea.nextInt();

            int pedido = cant_compra * valor_compra;
            if (pedido<valor_caja)
                System.out.println("Sí es posible realizar el pedido.");
            else
                System.out.println("No es posible realizar el pedido.");

        }

        lea.close();
 
    }
} */


// Ejemplo 5: Estructura dependiendo de o Según
/* import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        
        Scanner lea = new Scanner(System.in);
 
            System.out.println("Ingrese un día entre 1 y 7:");
            int dia = lea.nextInt();
            System.out.println("Total a pagar sin descuento:");
            int valor_sin_descuento = lea.nextInt();

            int descuento = 0;
            switch (dia) {
                case 1: descuento = 5;
                    break;
                case 2: descuento = 3;
                    break;
                case 3: descuento = 10;
                    break;
                case 4: descuento = 4;
                    break;
                case 5: descuento = 6;
                    break;
                case 6: descuento = 2;
                    break;
                case 7: descuento = 1;
                    break;
            }

            float descuento_pesos = valor_sin_descuento * descuento / 100;
            float valor_con_descuento = valor_sin_descuento - descuento_pesos;
            System.out.println("El descuento es: " + descuento + "% $" + descuento_pesos);
            System.out.println("El valor total restando descuento es: $" + valor_con_descuento);

        lea.close();

    }
}
 */


// Ejemplo 6: Estructura cíclica
/* import java.util.Scanner;
public class App {
    public static void main(String[] args) {

        Scanner lea = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de productos:");
        int cantidad_productos = lea.nextInt();

        int total_factura = 0;
        for (int contador = 1; contador <= cantidad_productos; contador++) {

            System.out.println("Cantidad del producto " + contador + ":");
            int cantidad_producto = lea.nextInt();
            System.out.println("Valor del producto " + contador + ":");
            int valor_producto = lea.nextInt();

            total_factura += cantidad_producto * valor_producto;

        }

        System.out.println("Total de la factura: $" + total_factura);

        lea.close();

    }
} */


// Ejemplo 7: Integración estructuras condicionales y cíclicas (while if-else) (for if-else)
import java.util.Scanner;
public class App {
    public static void main(String[] args) {

        Scanner lea = new Scanner(System.in);

        int continuar = 0;
        int total_factura = 0;
        int numero_cliente = 0;
        do {

        System.out.println("Información para el cliente " + (++numero_cliente));
        System.out.println("Ingrese la cantidad de productos:");
        int cantidad_productos = lea.nextInt();
        
        int total_cliente = 0;
        for (int contador = 1; contador <= cantidad_productos; contador++) {

            System.out.println("Cantidad del producto " + contador + ":");
            int cantidad_producto = lea.nextInt();
            System.out.println("Valor del producto " + contador + ":");
            int valor_producto = lea.nextInt();

            total_cliente += cantidad_producto * valor_producto;
            
        }

        total_factura += total_cliente;
        System.out.println("Total cliente " + numero_cliente + ": $" + total_cliente);

        System.out.println("Cualquier número continuar, -1 salir.");
        continuar = lea.nextInt();

        } while (continuar != -1);

        System.out.println("Total de la factura: $" + total_factura);

        lea.close();

    }
}