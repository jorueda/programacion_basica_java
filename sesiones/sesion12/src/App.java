public class App {

    static Seleccion_futbol Vector[] = new Seleccion_futbol[3];
    public static void main(String[] args) throws Exception {
        System.out.println("Poliformismo");

        Vector[0] = new Futbolista(2, "Luis", "Diaz", 29, 7, "Volante");
        Vector[1] = new Entrenador(1, "Reynaldo", "Rueda", 40, 1122);
        Vector[2] = new Masajista(3, "Esteban", "Castro", 35, "Fisioterapeuta", 15);

        System.out.println("Todos los integranes inician una concentración.");

        for (int i = 0; i < Vector.length; i++) {
            System.out.println(Vector[i].getNombre() + " " + Vector[i].getApellido() + " ");
            Vector[i].concentrarse();
        }

        System.out.println("Todos los integrantes viajan a un partido.");

        for (int i = 0; i < Vector.length; i++) {
            System.out.println(Vector[i].getNombre() + " " + Vector[i].getApellido() + " ");
            Vector[i].viajar();
        }

        System.out.println("Todos los integrantes entrenamiento.");

        for (int i = 0; i < Vector.length; i++) {
            System.out.println(Vector[i].getNombre() + " " + Vector[i].getApellido() + " ");
            Vector[i].Entrenamiento();
        }

        System.out.println("************************************************************");
        System.out.println("Entrevista: Solo el futbolista da entrevista.");
        Futbolista.Entrevista();

        System.out.println("************************************************************");
        System.out.println("Planifica: Solo el entrenador planifica el entrenamiento.");
        Entrenador.PlanificarEntrenamiento();

        System.out.println("************************************************************");
        System.out.println("Da masaje: solo el masajista lo hace.");
        Masajista.DarMasaje();


    }
}
