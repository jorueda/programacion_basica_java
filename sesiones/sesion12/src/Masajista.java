public class Masajista extends Seleccion_futbol {

    private String titulacion;
    private int experiencia;


    public Masajista(int id, String nombre, String apellido, int edad, String titulacion, int experiencia) {
        super(id, nombre, apellido, edad);
        this.titulacion = titulacion;
        this.experiencia = experiencia;
    }


    public String getTitulacion() {
        return this.titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    public int getExperiencia() {
        return this.experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }
    
    @Override
    public void Entrenamiento() {
        String mensaje = "Dirige asistencia al entrenamiento).";
        System.out.println(mensaje);
    }

    public static void DarMasaje() {
        System.out.println("Dar un masaje (clase Masajista).");
    }


}
