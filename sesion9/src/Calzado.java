public class Calzado extends producto {
   
    private int talla;
    
    public Calzado(){

    }
    
    public Calzado(int codigop,String descripcionp, double precio_comprap,double precio_ventap,int cant_bodegap,int cant_min_requeridap, int cant_max_inventariop, int tallap) {

        super(codigop,descripcionp,precio_comprap,precio_ventap,cant_bodegap,cant_min_requeridap,cant_max_inventariop);
        this.talla=tallap;
       // this.porcentaje=porcentajep;
        
    }

    //metodos getters y setters

    public int gettalla(){
        return talla;
    }

    public void settalla(int tallap){
       this.talla=tallap;
    }

    public String Mostrar() {// sobreescribir 
        return "{" +
            " codigo=" + getcodigo()+ " " +
            "- descripcion= " + getdescripcion() + " " +
            "- precio_compra= " + getprecio_compra() + " " +
            "- precio_venta= " + getprecio_venta() + " " +
            "- cant_bodega= " + getcant_bodega() + " " +
            "- cant_min_requerida= " + getcant_minima() + " " +
            "- cant_max_inventario= " + getcant_maxima()+ " " +
            "- talla= " + gettalla()+ " " +
            "}";
    }




}
