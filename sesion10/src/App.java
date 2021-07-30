public class App {
 
    public static void main(String[] args) {

        Electrodomestico lista_Electrodomestico[] = new Electrodomestico[5];

        lista_Electrodomestico[0] = new Electrodomestico(200.0, 60, 'C', "gris");
        lista_Electrodomestico[1] = new Lavadora(150, 30);
        lista_Electrodomestico[2] = new Electrodomestico();
        lista_Electrodomestico[3] = new Electrodomestico(600.0, 20, 'D', 20.0);
        lista_Electrodomestico[4] = new Lavadora(400.0, 100, 'A', "azul", 15);

        for (int i = 0; i < lista_Electrodomestico.length; i++) {
            System.out.println(lista_Electrodomestico[i]);
        }

        double SumLav = 0;
        double SumElec = 0;

        for (int i = 0; i < lista_Electrodomestico.length; i++) {
            if (lista_Electrodomestico[i] instanceof Lavadora)
                SumLav += lista_Electrodomestico[i].precioFinal();
            else
                SumElec += lista_Electrodomestico[i].precioFinal();
        }

        System.out.println("Suma de lavadores: " + SumLav);
        System.out.pirntln("Suma de electrodomésticos: " + SumElec);
    }
}