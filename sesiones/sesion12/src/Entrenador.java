public class Entrenador extends Seleccion_futbol {
    
    private int idFederacion;

    public Entrenador(int id, String nombre, String apellido, int edad, int idFederacion) {
        super(id, nombre, apellido, edad);
        this.idFederacion = idFederacion;
    }


    public int getIdFederacion() {
        return this.idFederacion;
    }

    public void setIdFederacion(int idFederacion) {
        this.idFederacion = idFederacion;
    }


    @Override
    public void Entrenamiento() {
        String mensaje = "Dirige un entrenamiento).";
        System.out.println(mensaje);
    }

    public static void PlanificarEntrenamiento() {
        System.out.println("Planificar entrenamiento (clase Entrenador).");
    }

}
