// Observar que es una clase abstracta
public abstract class Seleccion_futbol {

    protected int id;
    protected String nombre;
    protected String apellido;
    protected int edad;


    public Seleccion_futbol(int id, String nombre, String apellido, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    public void viajar() {
        System.out.println("Viajar (Clase Padre)");

    }

    public void concentrarse() {
        System.out.println("Concentrarse (Clase Padre)");
    }

    public void PartidoFutbol() {
        System.out.println("Asiste al partido (Clase Padre)");
    }

    // Método abstracto, se implementa en las clases hijas.
    public abstract void Entrenamiento();


}