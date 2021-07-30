import java.util.Scanner;

public class Producto {

    // Atributos de la clase con acceso privado para el encapsulamiento

    private String codigo;
    private double precio_de_compra;
    private int cantidad_en_bodega;
    private int cantidad_minima;

    // Constructores

    public Producto(String codigo, double precio_de_compra, int cantidad_en_bodega, int cantidad_minima) {
        this.codigo = codigo;
        this.precio_de_compra = precio_de_compra;
        this.cantidad_en_bodega = cantidad_en_bodega;
        this.cantidad_minima = cantidad_minima;
    }

    // Establecemos los métodos getter

    public String getCodigo() {
        return codigo;
    }

    public double getPrecio_de_compra() {
        return precio_de_compra;
    }

    public int getCantidad_bodega() {
        return cantidad_en_bodega;
    }

    public int getCantidad_minima () {
        return cantidad_minima;
    }

    // Establecemos los métodos setter

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setPrecio_compra(double precio_compra) {
        this.precio_de_compra = precio_compra;
    }

    public void setCantidad_bodega(int cant_bodega) {
        this.cantidad_en_bodega = cant_bodega;
    }

    public void setCantidad_minima(int cant_minima) {
        this.cantidad_minima = cant_minima;
    }

    public boolean solicitar_pedido() {
        if (cantidad_en_bodega < cantidad_minima)
            return true;
        else
            return false;
    }

    public static void main(String[] args) throws Exception {

        Scanner leer = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de productos a manejar: ");
        int n = leer.nextInt();

        Producto productos[] = new Producto[n];

        for (int i = 0; i < n ; i++) {

            leer.nextLine();
            System.out.println("Ingrese el código del producto: " + (i+1));
            String cod = leer.nextLine();

            System.out.println("Ingrese el precio de compra del producto: " + (i+1));
            double precio = leer.nextDouble();

            System.out.println("Ingrese la cantidad en bodega del producto: " + (i+1));
            int Cbodega = leer.nextInt();

            System.out.println("Ingre la cantidad mínima requerida del producto: " + (i+1));
            int Cminima = leer.nextInt();

            productos[i] = new Producto(cod, precio, Cbodega, Cminima);

        }

        int menor = productos[0].getCantidad_bodega();
        String Cmenor = productos[0].getCodigo();
        for (int i = 0; i < n; i++) {
            if (productos[i].solicitar_pedido())
                System.out.println("¡Alerta generada para el producto: " + productos[i].getCodigo());
            else
                System.out.println("No es necesario hacer pedido para el producto: " + productos[i].getCodigo());

            if (productos[i].getCantidad_bodega() < menor) {
                menor = productos[i].getCantidad_bodega();
                Cmenor = productos[i].getCodigo();
            }
        }
        System.out.println("El producto " + Cmenor + " tiene menor cantidad en bodega con " + menor + " unidades.");

        leer.close();

    }
}
