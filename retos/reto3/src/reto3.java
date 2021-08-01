import java.util.Scanner;

public class reto3 {

    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);

        int cantidad_cuerpos_de_agua = leer.nextInt();
        leer.nextLine();
        CuerpoDeAgua cuerpo[] = new CuerpoDeAgua[cantidad_cuerpos_de_agua];

        for (int i = 0; i < cuerpo.length; i++) {
            String entrada = leer.nextLine();
            String[] vector = entrada.split(" ");
            int id_entero = Integer.parseInt(vector[1]);
            float irca_flotante = Float.parseFloat(vector[3]);
    
            cuerpo[i] = new CuerpoDeAgua(vector[0], id_entero, vector[2], irca_flotante);
            
        }

        int contador = 0;
        float mas_alto = 0;
        for (int i = 0; i < cuerpo.length; i++) {
            System.out.println(cuerpo[i].getNombre() + " " + cuerpo[i].getMunicipio());

            if (cuerpo[i].getIRCA() >= 35.1)
                contador += 1;

            if (cuerpo[i].getIRCA() > mas_alto)
                mas_alto = cuerpo[i].getIRCA();

        }

        String contador_string = String.format("%.2f", (float)contador);
        System.out.println(contador_string);

        for (int i = 0; i < cuerpo.length; i++) {
            
            if (CuerpoDeAgua.nivel(cuerpo[i].getIRCA()) == "ALTO")
                System.out.print(cuerpo[i].getMunicipio() + " ");
        }

        System.out.println();
        System.out.println(CuerpoDeAgua.nivel(mas_alto));

        leer.close();
    }
}
