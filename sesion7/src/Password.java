import javax.swing.JOptionPane;

/* 
1.	Haz una clase llamada Password que siga las siguientes condiciones:
•	Que tenga los atributos longitud y contraseña. Por defecto, la longitud será de 8.
•	Los constructores serán los siguientes: 
o	Un constructor por defecto.
•	Un constructor con la longitud que le pasemos. Generará una contraseña aleatoria con esa longitud.
•	Los métodos que implementa serán: 
o	esFuerte(): devuelve un booleano si es fuerte o no, para que sea fuerte debe tener más de 1 mayúscula, al menos 1 minúscula y más de 4 números.
o	generarPassword():  genera la contraseña del objeto con la longitud que tenga.
o	Método get para contraseña y longitud.
o	Método set para longitud.
Ahora, crea una clase clase ejecutable:
•	Crea un array de Passwords con el tamaño que le indiques por teclado.
•	Crea un bucle que cree un objeto para cada posición del array.
•	Indica también por teclado la longitud de los Passwords.
•	Crea otro array de booleanos donde se almacene si el password del array de Password es o no fuerte.
•	Al final, muestra la contraseña y si es o no fuerte (usa el bucle anterior). Usa este simple formato:
Contraseña1……….. ¡Es fuerte!
Contraseña2……….. ¡No es fuerte! */

public class Password {

    private int longitud;
    private String contrasena;
    private final static int POR_DEFECTO = 8; /* Es constante y es es global */

    public Password(int longitud_constr) {
        this.longitud = longitud_constr;
        this.contrasena = generarContrasena();
    }

    public Password() {
        this(POR_DEFECTO);
    }

    public int getLongitud() {
        return this.longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public String getContrasena() {
        return this.contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String generarContrasena() {
        String contrasena_generada = "";
        
        int eleccion = 1; /* 1 números, 2 minúsculas, 3 mayúsculas */
        for (int i = 0; i < longitud; i++) {
            eleccion = (int)(Math.random() * 3) + 1; /* El random genera double */

            switch (eleccion) {
                case 1: {
                    char caracter_numero = (char)((Math.random() * 10) + 48);
                    contrasena_generada += caracter_numero;
                    break;
                }
                case 2: {
                    char caracter_minuscula = (char)((Math.random() * 26) + 97);
                    contrasena_generada += caracter_minuscula;
                    break;
                }
                case 3: {
                    char caracter_mayuscula = (char)((Math.random() * 26) + 65);
                    contrasena_generada += caracter_mayuscula;
                    break;
                }
            }
        }

        return contrasena_generada;
    }

    public boolean esFuerte(String contrasena_recibida) {

        int contador_mayusculas = 0;
        int contador_minusculas = 0;
        int contador_numeros = 0;

        for (int i = 0; i < contrasena_recibida.length(); i++) {
            
            if (contrasena_recibida.charAt(i) >= 65 && contrasena_recibida.charAt(i) <= 90)
                contador_mayusculas += 1;
            else if (contrasena_recibida.charAt(i) >= 97 && contrasena_recibida.charAt(i) <= 122)
                contador_minusculas += 1;
            else if (contrasena_recibida.charAt(i) >= 48 && contrasena_recibida.charAt(i) <= 57)
                contador_numeros += 1;
        }

        /* System.out.println("Mayúsculas " + contador_mayusculas + " Minúsculas " + contador_minusculas + " Números " + contador_numeros); */

        if (contador_mayusculas > 1 && contador_minusculas >= 1 && contador_numeros > 4)
            return true;
        else
            return false;

    }

    public static void main(String[] args) {

        String mensaje = JOptionPane.showInputDialog("Digite la cantidad de passwords a generar: ");
        int cantidad_passwords = Integer.parseInt(mensaje);

        mensaje = JOptionPane.showInputDialog("Digite la longitud de los passwords: ");
        int longitud_passwords = Integer.parseInt(mensaje);
        
        Password[] vector_passwords = new Password[cantidad_passwords];
        boolean[] vector_booleano = new boolean[cantidad_passwords];

        for (int i = 0; i < vector_booleano.length; i++) {
            vector_passwords[i] = new Password(longitud_passwords);
            vector_booleano[i] = vector_passwords[i].esFuerte(vector_passwords[i].getContrasena());
        }

        for (int i = 0; i < vector_booleano.length; i++) {
            System.out.println(vector_passwords[i].getContrasena() + " " + vector_booleano[i]);
        }

        Password[] vector_default = new Password[cantidad_passwords];

        for (int i = 0; i < vector_default.length; i++) {
            
            vector_default[i] = new Password(); /* Toma la longitud POR_DEFECTO */
            System.out.println(vector_default[i].generarContrasena() + " " + vector_default[i].esFuerte(vector_default[i].getContrasena()));
        }

    }

}
