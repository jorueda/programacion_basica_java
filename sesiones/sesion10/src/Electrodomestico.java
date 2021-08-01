/* Crearemos una superclase llamada Electrodoméstico con las siguientes características:
•	Sus atributos son precio base, color, consumo energético (letras entre A y F) y peso. Indica que se podrán heredar.
•	Por defecto, el color sera blanco, el consumo energético será F, el precioBase es de $100  y el peso de 5 kg. Usa constantes para ello.
•	Los colores disponibles son blanco, negro, rojo, azul y gris. No importa si el nombre está en mayúsculas o en minúsculas.
•	Los constructores que se implementaran serán 
o	Un constructor por defecto.
o	Un constructor con el precio y peso. El resto por defecto.
o	Un constructor con todos los atributos.
•	Los métodos que implementara serán: 
o	Métodos get de todos los atributos.
o	comprobarConsumoEnergetico(char letra): comprueba que la letra es correcta, sino es correcta usara la letra por defecto. Se invocara al crear el objeto y no sera visible.
o	comprobarColor(String color): comprueba que el color es correcto, sino lo es usa el color por defecto. Se invocara al crear el objeto y no será visible.
o	precioFinal(): según el consumo energético, aumentara su precio, y según su tamaño, también. Esta es la lista de precios:
Letra	Precio
A	$ 100 
B	$ 80 
C	$ 60 
D	$ 50 
E	$ 30 
F	$ 10 
Tamaño	Precio
Entre 0 y 19 kg	$10
Entre 20 y 49 kg	$50
Entre 50 y 79 kg	$80
Mayor que 80 kg	$100
Crearemos una subclase llamada Lavadora con las siguientes características:
•	Su atributo es carga, además de los atributos heredados.
•	Por defecto, la carga es de 5 kg. Usa una constante para ello.
•	Los constructores que se implementaran serán: 
o	Un constructor por defecto.
o	Un constructor con el precio y peso. El resto por defecto.
o	Un constructor con la carga y el resto de atributos heredados. Recuerda que debes llamar al constructor de la clase padre.
•	Los métodos que se implementara serán: 
o	Método get de carga.
o	precioFinal(): si tiene una carga mayor de 30 kg, aumentara el precio $50, sino es así no se incrementara el precio. Llama al método padre y añade el código necesario. Recuerda que las condiciones que hemos visto en la clase Electrodoméstico también deben afectar al precio.
Ahora crea una clase ejecutable que realice lo siguiente:
•	Crea un array de Electrodomésticos de 5 posiciones.
•	Asigna a cada posición un objeto de las clases anteriores con los valores que desees.
•	Ahora, recorre este array y ejecuta el método precioFinal().
•	Deberás mostrar el precio de cada clase, es decir, el precio de todas las lavadoras y la suma de los Electrodomésticos (puedes crear objetos Electrodoméstico).
 */

public class Electrodomestico {
    
    protected double precioBase;
    protected String color;
    protected char consumo;
    protected double peso;

    protected final static String color_default = "Blanco";
    protected final static char consumo_default = 'F';
    protected final static double precioBase_default = 100;
    protected final static double peso_default = 5;

    public Electrodomestico() {
        this(precioBase_default, peso_default, consumo_default, color_default);
    }

    public Electrodomestico(double precioBase, double peso, char consumo, String color) {
        this.precioBase = precioBase;
        this.peso = peso;
        comprobarColor(color);
        comprobarConsumo(consumo);
    }

    
    public double getPrecioBase() {
        return this.precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public char getConsumo() {
        return this.consumo;
    }

    public void setConsumo(char consumo) {
        this.consumo = consumo;
    }

    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void comprobarConsumo(char consumo) {
        if (consumo >= 65 && consumo <= 70)
            this.consumo = consumo;
        else
            this.consumo = consumo_default;
    }

    String colores[] = {"blanco", "negro", "gris", "rojo", "azul"};
    public void comprobarColor(String color) {

        boolean encontrado = false;
        for (int i = 0; i < colores.length; i++) {
            if (colores[i].equals(color))
                encontrado = true;
        }
        if (encontrado)
            this.color = color;
        else
            this.color = color_default;
    }

    public double precioFinal() {

        double aumento = 0;
        switch (consumo) {
            case 'A':
                aumento += 100;
                break;
            case 'B':
                aumento += 80;
                break;
            case 'C':
                aumento += 60;
                break;
            case 'D':
                aumento += 50;
                break;
            case 'E':
                aumento += 30;
                break;
            case 'F':
                aumento += 10;
                break;
        }

        if (peso >= 0 && peso <= 19)
            aumento += 10;
        else if (peso >= 20 && peso <= 49)
            aumento += 50;
        else if (peso >= 50 && peso <= 79)
            aumento += 80;
        else if (peso >= 80)
            aumento += 100;
        
        return precioBase + aumento;
    }


    @Override
    public String toString() {
        return "{" +
            " precioBase='" + getPrecioBase() + "'" +
            ", color='" + getColor() + "'" +
            ", consumo='" + getConsumo() + "'" +
            ", peso='" + getPeso() + "'" +
            "}";
    }


}
