/*Haz una clase llamada Persona que siga las siguientes condiciones:
•	Sus atributos son: nombre, edad, DNI, sexo (H hombre, M mujer), peso y altura. 
•	Por defecto, todos los atributos menos el DNI serán valores por defecto según su tipo (0 números, cadena vacía para String, etc.). 
•	Se implantaran varios constructores: 
o	Un constructor por defecto.
o	Un constructor con el nombre, edad y sexo, el resto por defecto.
o	Un constructor con todos los atributos como parámetro.
•	Los métodos que se implementaran son: 
o	calcularIMC(): calculara si la persona está en su peso ideal (peso en kg/(altura^2  en m)), si esta fórmula devuelve un valor menor que 20, la función devuelve un -1, si devuelve un número entre 20 y 25 (incluidos), significa que está por debajo de su peso ideal la función devuelve un 0  y si devuelve un valor mayor que 25 significa que tiene sobrepeso, la función devuelve un 1. Te recomiendo que uses constantes para devolver estos valores. 
Ahora, crea una clase ejecutable que haga lo siguiente:
•	Pide por teclado el nombre, la edad, sexo, peso y altura.
•	Crea 1 objeto de la clase anterior, con el constructor que pide todos los parametros.
•	comprobar si está en su peso ideal, tiene sobrepeso o por debajo de su peso ideal con un mensaje.*/

import java.util.Scanner;

public class Persona {
    
    String nombre;
    int edad;
    char sexo;
    float peso;
    float altura;
    int dni;

    public Persona(String nombre, float peso, float altura) {
        this.nombre = nombre;
        this.edad = 35;
        this.sexo = 'M';
        this.peso = peso;
        this.altura = altura;
    }

    public void Imc() {

        double Indice = (peso / (altura * altura));

        if (Indice < 20)
            System.out.println("Tiene un peso por debajo del peso ideal.");
        else if (Indice >= 20 && Indice < 25)
            System.out.println("Tiene el peso ideal.");
        else
            System.out.println("Tiene sobrepeso.");
    }

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        System.out.println("Digite su nombre:");
        String nombre = leer.nextLine();

        System.out.println("Digite su peso:");
        float peso = leer.nextFloat();

        System.out.println("Digite su altura:");
        float altura = leer.nextFloat();

        Persona persona1 = new Persona(nombre, peso, altura);
        persona1.Imc();

        leer.close();

    }
}
