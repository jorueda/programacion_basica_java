import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);

        System.out.println("Tamaño de los vectores:");
        int longitud_vector = leer.nextInt();

        int[] codigos = new int[longitud_vector];
        int[] cantidad_en_bodega = new int[longitud_vector];
        int[] cantidad_minima = new int[longitud_vector];

        for (int contador = 0; contador < longitud_vector; contador++) {

            System.out.println("Código " + (contador + 1) + ":");
            codigos[contador] = leer.nextInt();

            System.out.println("Cantidad en bodega " + (contador + 1) + ":");
            cantidad_en_bodega[contador] = leer.nextInt();

            System.out.println("Cantidad mínima requerida " + (contador + 1) + ":");
            cantidad_minima[contador] = leer.nextInt();

        }

        int menor = cantidad_en_bodega[0];
        int mayor = cantidad_en_bodega[0];
        int codigo_menor = 0;
        int codigo_mayor = 0;

        System.out.println("Códigos de productos que son necesarios pedir:");
        for (int contador = 0; contador < longitud_vector; contador ++) {
            
            if (cantidad_en_bodega[contador] < cantidad_minima[contador])
                System.out.println((codigos[contador]));
            
            if (cantidad_en_bodega[contador] > mayor) {
                mayor = cantidad_en_bodega[contador];
                codigo_mayor = contador;
            }
            else if (cantidad_en_bodega[contador] < menor) {
                menor = cantidad_en_bodega[contador];
                codigo_menor = contador;
            }
                
        }

        System.out.println("Código con mayor número de unidades: " + codigos[codigo_mayor]);
        System.out.println("Código con menor número de unidades: " + codigos[codigo_menor]);

        leer.close();

    }
}
