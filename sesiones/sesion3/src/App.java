import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);

        String[] listaCodigos = new String[10];

        int[][] matrizBodega = new int[100][100];
        int[][] matrizMinima = new int[100][100];

        System.out.println("Ingrese los códigos de los productos separados por espacio");
        String entrada = leer.nextLine();
        listaCodigos = entrada.split(" ");

        System.out.println("Ingrese la cantidad en bodega separando las filas por punto y coma y las cantidades por espacio");

        entrada = leer.nextLine();
        String[] filas = entrada.split(";");

        for (int i = 0; i < filas.length; i++) {
            String[] cantidades = filas[i].split(" ");
            for (int j = 0; j < listaCodigos.length; j++) {

                String num = cantidades[j];
                matrizBodega[i][j] = Integer.parseInt(num);
            }
        }

        System.out.println("Ingrese la cantidad mínima requerida separando las filas por punto y coma y las cantidades por espacio");

        entrada = leer.nextLine();
        filas = entrada.split(";");

        for (int i = 0; i < filas.length; i++) {
            String[] cantidades = filas[i].split(" ");
            for (int j = 0; j < listaCodigos.length; j++) {

                String num = cantidades[j];
                matrizMinima[i][j] = Integer.parseInt(num);
            }
        }

        for (int i = 0; i < filas.length; i++) {
            for (int j = 0; j < listaCodigos.length; j++) {
                if (matrizBodega[i][j] < matrizMinima[i][j])
                    System.out.println("Se debe solicitar producto " + listaCodigos[j] + " en la sede " + i);
            }
           
        }

        float suma_promedios = 0;
        for (int j = 0; j < listaCodigos.length; j++) {
            suma_promedios = 0;
            for (int i = 0; i < filas.length; i++)
                suma_promedios += matrizBodega[i][j];
                
            System.out.println("El promedio de productos del código " + listaCodigos[j] + " es " + (suma_promedios/filas.length));
        }

        leer.close();
    }
}
        