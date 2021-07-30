public class Prendas_vestir extends producto {
    
     private String talla;
     private String planchado;


     public Prendas_vestir(){

     }

     public Prendas_vestir(int codigop,String descripcionp,double precio_comprap,double precio_ventap,int cant_bodegap,int cant_min_requeridap, int cant_max_inventariop,String tallap, String planchadop) {

        super(codigop,descripcionp,precio_comprap,precio_ventap,cant_bodegap,cant_min_requeridap,cant_max_inventariop);
        this.talla=tallap;
        this.planchado=planchadop;
       // this.porcentaje=porcentajep;
        
    }
    // metodos getters
    public String gettalla(){
        return talla;
    }

    public String getplanchado(){
        return planchado;
    }


    // metodos setters
    public void settalla(String tallap){
        this.talla=tallap;
     }

    public void setplanchado(String planchadop){
       this.planchado=planchadop;
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
            "- planchado= " + getplanchado() +" " +
            "}";
    }

    @Override
    public boolean solicitar_pedido()
    {
        if(cant_bodega<cant_min_requerida){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public double total_pagar(int unidades)
    {
        return (unidades*precio_compra)*(1-porcentaje);
    }
    





}
