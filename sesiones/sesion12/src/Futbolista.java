public class Futbolista extends Seleccion_futbol {
    
    private int dorsal;
    private String posicion;


    public Futbolista(int id, String nombre, String apellido, int edad, int dorsal, String posicion) {
        super(id, nombre, apellido, edad);
        this.dorsal = dorsal;
        this.posicion = posicion;
    }


    public int getDorsal() {
        return this.dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getPosicion() {
        return this.posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    @Override
    public void Entrenamiento() {
        String mensaje = "Realiza un entrenamiento (clase hija).";
        System.out.println(mensaje);
    }

    public static void Entrevista() {
        System.out.println("Da una entrevista (clase futbolista).");
    }
    
}
