// El porcentaje es global de tipo static
import java.util.Scanner;
public class Producto {

    private String codigo;
    private double precioCompra;
    private int cantBodega;
    private int cantMinReq;
    private int cantMaxPer;
    static float porcentajeDesc = 0.05f; /* static, funciona como una variable global */


    public Producto() {
    }


    public Producto(String codigo, double precioCompra, int cantBodega, int cantMinReq, int cantMaxPer) {
        this.codigo = codigo;
        this.precioCompra = precioCompra;
        this.cantBodega = cantBodega;
        this.cantMinReq = cantMinReq;
        this.cantMaxPer = cantMaxPer;
    }
    

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecioCompra() {
        return this.precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getCantBodega() {
        return this.cantBodega;
    }

    public void setCantBodega(int cantBodega) {
        this.cantBodega = cantBodega;
    }

    public int getCantMinReq() {
        return this.cantMinReq;
    }

    public void setCantMinReq(int cantMinReq) {
        this.cantMinReq = cantMinReq;
    }

    public int getCantMaxPer() {
        return this.cantMaxPer;
    }

    public void setCantMaxPer(int cantMaxPer) {
        this.cantMaxPer = cantMaxPer;
    }

    public boolean solicitarPedido() {
        if (cantBodega < cantMinReq)
            return true;
        else
            return false;
    }

    public double totalPagar(int unidades) {
        return (unidades * precioCompra) * (1 - porcentajeDesc);
    }


    @Override
    public String toString() {
        return "{" +
            " codigo='" + getCodigo() + "'" +
            ", precioCompra='" + getPrecioCompra() + "'" +
            ", cantBodega='" + getCantBodega() + "'" +
            ", cantMinReq='" + getCantMinReq() + "'" +
            ", cantMaxPer='" + getCantMaxPer() + "'" +
            "}";
    }


    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite la cantidad de productos a manejar: ");
        int n = scanner.nextInt();

        Producto productos[] = new Producto[n]; /* Crea un vector de objetos de tipo Producto */

        for (int i = 0; i < n; i++) {
            
            scanner.nextLine(); /* Después del nextInt hay que colocar un nextLine */

            System.out.println("Digite el código del producto: " + (i+1));
            String cod = scanner.nextLine();

            System.out.println("Digite el precio de compra del producto: " + (i+1));
            double precio = scanner.nextDouble();

            System.out.println("Digite la cantidad en bodega del producto: " + (i+1));
            int cbodega = scanner.nextInt();

            System.out.println("Digite la cantidad mínima del producto: " + (i+1));
            int cminima = scanner.nextInt();

            System.out.println("Digite la cantidad máxima del producto: " + (i+1));
            int cmaxima = scanner.nextInt();

            productos[i] = new Producto(cod, precio, cbodega, cminima, cmaxima);

        }

        int mayor = productos[0].getCantBodega();
        String Cmayor = productos[0].getCodigo();
        for (int i = 0; i < n; i++) {
            if (productos[i].solicitarPedido())
                System.out.println("¡Alerta generada para el producto " + productos[i].getCodigo() + "!");

            if (productos[i].getCantBodega() > mayor)
                mayor = productos[i].getCantBodega();
                Cmayor = productos[i].getCodigo();
        }

        System.out.println("El producto " + Cmayor + " tiene mayor unidades en bodega, con " + mayor + " unidades.");

        scanner.nextLine();
        System.out.println("Digite el código del producto a comprar: ");
        String cod = scanner.nextLine();

        boolean sw = false;
        for (int i = 0; i < n; i++) {
            if (productos[i].getCodigo().equals(cod)) {
                System.out.println("Digite el número de unidades de compra: ");
                int numUnidades = scanner.nextInt();

                int unidadespermitidas = productos[i].getCantMaxPer() - (productos[i].cantBodega - productos[i].cantMinReq);
                sw = true;

                if (numUnidades <= unidadespermitidas)
                    System.out.println("Total a pagar es de: " + productos[i].totalPagar(numUnidades));
                else
                    System.out.println("El número de unidades excede la capacidad máxima permitida.");


            }
        }

        if (sw == false)
            System.out.println("El producto no hace parte del inventario.");

        for (int i = 0; i < n; i++) {
            System.out.println(productos[i]); /* Imprime con el metodo toString los contenidos */
        }

        scanner.close();

    }
}
