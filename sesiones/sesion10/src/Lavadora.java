public class Lavadora extends Electrodomestico {

    private int carga;
    private final static int carga_default = 5;


    public Lavadora(double precioBase, double peso) {
        this(precioBase, peso, consumo_default, color_default, carga_default);
    }

    public Lavadora(double precioBase, double peso, char, consumo, String color, int carga) {

        super(precioBase, peso, consumo, color);
        this.carga = carga;
    }


    public int getCarga() {
        return this.carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    public double precioFinal() {

        double aumento = super.precioFinal();
        if (carga >= 30)
            aumento += 50;
        
        return aumento;
        }
    
}
