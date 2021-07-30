import java.util.Scanner;
public class reto1 {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        int longitud_vector = leer.nextInt();

        float lectura = 0;
        float suma_promedios = 0;
        float cant_porcentajes_riesgo = 0;
        boolean existe_solo_vigilancia = false;
        for (int contador = 0; contador < longitud_vector; contador++) {
            lectura = leer.nextFloat();
            suma_promedios += lectura;
            if (lectura >= 35.1)
                cant_porcentajes_riesgo += 1;
            if (lectura >= 0 && lectura <=5)
                existe_solo_vigilancia = true;
        }

        float promedio = suma_promedios / longitud_vector;

        String texto = "";
        if (promedio >= 80.1 && promedio <= 100)
            texto = "INVIABLE SANITARIAMENTE";
        else if (promedio >= 35.1 && promedio <= 80)
            texto = "ALTO";
        else if (promedio >= 14.1 && promedio <= 35)
            texto = "MEDIO";
        else if (promedio >= 5.1 && promedio <= 14)
            texto = "BAJO";
        else 
            texto = "SIN RIESGO";

        System.out.println(texto);

        System.out.printf("%.2f\n", cant_porcentajes_riesgo / longitud_vector * 100);

        if (existe_solo_vigilancia)
            System.out.println("SI");
        else
            System.out.println("NO");
            
        leer.close();
    }
}
