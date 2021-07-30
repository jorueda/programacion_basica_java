import java.util.Scanner;

public class Producto {
    
    int codigo;
    double precio_compra;
    int cantidad_bodega;
    int cantidad_minima_requerida;

    public Producto() {}

    public Producto(int codigop, double precio_comprap, int cantidad_bodegap, int cantidad_minima_requeridap) {

        this.codigo = codigop;
        this.precio_compra = precio_comprap;
        this.cantidad_bodega = cantidad_bodegap;
        this.cantidad_minima_requerida = cantidad_minima_requeridap;
    }

    public boolean solicitar_pedido() {

        if (cantidad_bodega < cantidad_minima_requerida)
            return true;
        else
            return false;
    }


    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        System.out.println("Ingrese el código del producto:");
        int codigo = leer.nextInt();

        System.out.println("Ingrese el precio de compra del producto:");
        double precio = leer.nextDouble();

        System.out.println("Ingrese la cantidad en bodega:");
        int bodega = leer.nextInt();

        System.out.println("Ingrese la cantidad mínima requerida:");
        int minima = leer.nextInt();

        Producto Myproducto = new Producto(codigo, precio, bodega, minima);

        if (Myproducto.solicitar_pedido())
            System.out.println("¡Alerta generada!");
        else 
            System.out.println("No es necesario hacer pedido.");

        leer.close();

    }

}
