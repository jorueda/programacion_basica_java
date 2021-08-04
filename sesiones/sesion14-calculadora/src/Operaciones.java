public class Operaciones {
    
    private int a;
    private int b;


    public Operaciones(int a, int b) {
        this.a = a;
        this.b = b;
    }


    public int getA() {
        return this.a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return this.b;
    }

    public void setB(int b) {
        this.b = b;
    }


    public int sumar() {
        return a + b;
    }

    public int restar() {
        return a - b;
    }

    public int multiplicar() {
        return a * b;
    }

    public double dividir() {
        return a / b;
    }

}
