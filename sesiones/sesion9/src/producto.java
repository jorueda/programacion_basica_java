
import javax.swing.JOptionPane;


public class producto {
    

    //atributos______________________________________________________________________________________________________

    protected int codigo;
    protected double precio_compra;
    protected double precio_venta;
    protected int cant_bodega;
    protected int cant_min_requerida;
    protected int cant_max_inventario;
    protected String descripcion;
    public final static  double porcentaje=0.01;

    //constructores _______________________________________________________________________________________________

    public producto(){

    }

    public producto(int codigop, String descripcionp,double precio_comprap,double precio_ventap,int cant_bodegap,int cant_min_requeridap, int cant_max_inventariop) {

        this.codigo=codigop;
        this.precio_compra=precio_comprap;
        this.precio_venta=precio_ventap;
        this.cant_bodega=cant_bodegap;
        this.cant_min_requerida=cant_min_requeridap;
        this.cant_max_inventario=cant_max_inventariop;
        this.descripcion=descripcionp;
        // this.porcentaje=porcentajep;
        
    }

    // metodos get_________________________________________________________________________________________________

    public int getcodigo(){
        return codigo;
    }

    public String getdescripcion(){
        return descripcion;
    }

    public double getprecio_compra(){
        return precio_compra;
    }

    public double getprecio_venta(){
        return precio_venta;
    }

    public int getcant_bodega(){
        return cant_bodega;
    }

    public int getcant_minima(){
        return cant_min_requerida;
    }
    public int getcant_maxima(){
        return cant_max_inventario;
    }
    public double getporcentaje(){
        return porcentaje;
    }

    //metodos set__________________________________________________________________________________________________
    
    public void setcodigo(int codig){
        this.codigo=codig;
    }

    public void setdescripcion(String descripcionp){
        this.descripcion=descripcionp;
    }

    public void gsetprecio_compra(double precio){
        this.precio_compra=precio;
    }

    public void gsetprecio_venta(double precio){
        this.precio_venta=precio;
    }

    public void setcant_bodega(int bodega){
        this.cant_bodega=bodega;
    }

    public void setcant_minima(int cant_min){
        if(cant_min<0){
            this.cant_min_requerida=0;

        }else{
            this.cant_min_requerida= cant_min;
        }
        
    }

    public void setcant_maxima(int cant_max_inventariop){
        this.cant_max_inventario=cant_max_inventariop;
    }
    

   //metodos de la clase producto_________________________________________________________________________________

    public boolean solicitar_pedido(){

        if(cant_bodega<cant_min_requerida){
            return true;
        }else{
            return false;
        }
    }

    public double total_pagar(int unidades){
        return (unidades*precio_compra)*(1-porcentaje);
    }


    
    public String Mostrar() {
        return "{" +
            " codigo=" + getcodigo()+ " " +
            "- descripcion= " + getdescripcion() + " " +
            "- precio_compra= " + getprecio_compra() + " " +
            "- precio_venta= " + getprecio_venta() + " " +
            "- cant_bodega= " + getcant_bodega() + " " +
            "- cant_min_requerida= " + getcant_minima() + " " +
            "- cant_max_inventario= " + getcant_maxima()+ " " +
            "}";
    }
    

    //________________________________________________________________________________________________________


    public static void main(String[] args) { 
       
        //Prueba de escritorio:
        //101,Deportivo,30000,45000,100,70,10,40
        //102,Casual,70000,80000,120,150,200,37
        //103,Blusa,35000,50000,300,350,400,S,true
        //104,Camisa,60000,75000,350,150,250,L,false

        
        //Creacion de los vectores calzado y prendas de vestir: terminado___________________________________________________________________________________________________________________________________________________________________________
        
        String mensaje = JOptionPane.showInputDialog(null,"ingrese la cantidad de productos","Calzado",-1);
        int cantc = Integer.parseInt(mensaje);

        String mensaj = JOptionPane.showInputDialog(null,"ingrese la cantidad de productos","Prendas de vestir",-1);
        int cantp = Integer.parseInt(mensaj);

        Calzado calzado[]= new Calzado[cantc];
        Prendas_vestir prendas_vestir[]= new Prendas_vestir[cantp];

        for(int i=0;i<cantc; i++){
            mensaje = JOptionPane.showInputDialog(null,"ingrese en orden y separadas por (,) \n codigo del producto \n Descripcion \n precio de compra \n precio de venta  \n cantidad en bodega \n cantidad minima requerida \n cantidad maxima en inventario \n talla","Intrucciones: Calzado",-1);
            String []datos=mensaje.split(",");

            calzado[i]= new Calzado(Integer.parseInt(datos[0]),datos[1],Integer.parseInt(datos[2]),Integer.parseInt(datos[3]),Integer.parseInt(datos[4]),Integer.parseInt(datos[5]),Integer.parseInt(datos[6]),Integer.parseInt(datos[7]));
        }

        for(int i=0;i<cantp; i++){
            mensaje = JOptionPane.showInputDialog(null,"ingrese en orden y separadas por (,) \n codigo del producto \n Descripcion \n precio de compra \n precio de venta  \n cantidad en bodega \n cantidad minima requerida \n cantidad maxima en inventario \ntalla \n Planchado ","Intrucciones: Prendas de vestir",-1);
            String []datos=mensaje.split(",");

            prendas_vestir[i]= new Prendas_vestir(Integer.parseInt(datos[0]),datos[1],Integer.parseInt(datos[2]),Integer.parseInt(datos[3]),Integer.parseInt(datos[4]),Integer.parseInt(datos[5]),Integer.parseInt(datos[6]),datos[7],datos[8]);
        }

        //_____________________________________________________________________________________________________________________________________________________________________________________________________________________________________

        boolean sw=false;

        do{
            mensaje = JOptionPane.showInputDialog(null,"Opcion 1: verificar productos a pedir \n Opcion 2: producto con mayor cantidad de unidades \n Opcion 3: total a pagar por pedido a realizar  \n Opcion 4: modificar cantidad minima requerida en bodega \n Opcion 5: vender producto \n Opcion 6: Mostrar inventario \n Digite la opcion deseada:  ","Menu de opciones",-1);
            int opcion = Integer.parseInt(mensaje);

            switch (opcion) {
                case 1: { //verificar productos a pedir terminado__________________________________________________________________________________________________________________________________________________________________________________________________
            
                    for(int i=0;i<cantc; i++){ //calzado________________________________________________________________________________________
                        if(calzado[i].solicitar_pedido()){
                            JOptionPane.showMessageDialog(null,"¡¡ALERTA!! -- codigo producto: "+calzado[i].getcodigo(),"Calzado",-1);
                        
                        }else{
                            JOptionPane.showMessageDialog(null,"No es necesario socilitar pedido ---codigo producto: "+calzado[i].getcodigo(),"Calzado",-1);
                        }
                    }
                    for(int i=0;i<cantp; i++){//prendas de vestir_______________________________________________________________________________
                        if(prendas_vestir[i].solicitar_pedido()){
                            JOptionPane.showMessageDialog(null,"¡¡ALERTA!! -- codigo producto: "+prendas_vestir[i].getcodigo(),"Prendas de vestir",-1);
                        
                        }else{
                            JOptionPane.showMessageDialog(null,"No es necesario socilitar pedido ---codigo producto: "+prendas_vestir[i].getcodigo(),"Prendas de vestir",-1);
                        }
                    }
                
                    break;
                }
                case 2: {//producto con mayor cantidad de unidades: terminado_________________________________________________________________________________________________________________________________________________________________________________
                    int mayorc=calzado[0].getcant_bodega();
                    int cmayorc=calzado[0].getcodigo();

                    int mayorp=prendas_vestir[0].getcant_bodega();
                    int cmayorp=prendas_vestir[0].getcodigo();
            
                    for(int i=0;i<cantc; i++){ //mayor calzado_________________
            
                        if(calzado[i].getcant_bodega()>mayorc){
                            mayorc=calzado[i].getcant_bodega();
                            cmayorc=calzado[i].getcodigo();
                        }
                    }

                    for(int i=0;i<cantp; i++){//mayor prendas de vestir________
            
                        if(prendas_vestir[i].getcant_bodega()>mayorp){
                            mayorp=prendas_vestir[i].getcant_bodega();
                            cmayorp=prendas_vestir[i].getcodigo();
                        }
                    }
                    JOptionPane.showMessageDialog(null,"El producto "+ cmayorc +" tiene mayor cantidad en bodega con "+ mayorc +" unidades","Calzado",-1);
                    JOptionPane.showMessageDialog(null,"El producto "+ cmayorp +" tiene mayor cantidad en bodega con "+ mayorp +" unidades","Prendas de vestir",-1);
                    
                    break;
                }
                case 3: {// total a pagar por pedido: terminado__________________________________________________________________________________________________________________________________________________________________________________

                    do{
                    String m= JOptionPane.showInputDialog(null,"1.Calzado \n 2.Prendas de vestir","Opciones: total a pagar",-1);
                    int c= Integer.parseInt(m);

                    switch (c) {
                        case 1:
                        String mensa= JOptionPane.showInputDialog(null,"ingrese el codigo del producto","Calzado",-1);
                        int cod= Integer.parseInt(mensa);
    
                        for(int i=0;i<cantc; i++){
                
                            if(calzado[i].getcodigo()==cod){
                                String mens= JOptionPane.showInputDialog(null,"ingrese el numero de unidades","Calzado",-1);
                                int num_unidades= Integer.parseInt(mens);
    
                                int unidades_permitidas= calzado[i].getcant_maxima()-(calzado[i].getcant_bodega()-calzado[i].getcant_minima()); 
                    
                                sw=true;
                                if(num_unidades<=unidades_permitidas){
                                    JOptionPane.showConfirmDialog(null,"el tortal a pagar es de: "+calzado[i].total_pagar(num_unidades),"Total a pagar: Calzado",-1);
                                    
                                }else{
                                    JOptionPane.showConfirmDialog(null,"excede la capacidad","Alerta de bodega",-1);
                
                                }
                            }
                            JOptionPane.showConfirmDialog(null,calzado[i].toString(),"Calzado: bodega",-1);
                        }
                        if(sw==false){ //revisar
                            JOptionPane.showMessageDialog(null,"el producto no hace parte del inventario","Alerta de bodega",-1);
                        }
                            break;
                        case 2:
                        String mens= JOptionPane.showInputDialog(null,"ingrese el codigo del producto","Prendas de vestir",-1);
                        int co= Integer.parseInt(mens);
    
                        for(int i=0;i<cantp; i++){
                
                            if(prendas_vestir[i].getcodigo()==co){
                                String men= JOptionPane.showInputDialog(null,"ingrese el numero de unidades","Prendas de vestir",-1);
                                int num_unidades= Integer.parseInt(men);
    
                                int unidades_permitidas= prendas_vestir[i].getcant_maxima()-(prendas_vestir[i].getcant_bodega()-prendas_vestir[i].getcant_minima()); 
                    
                                sw=true;
                                if(num_unidades<=unidades_permitidas){
                                    JOptionPane.showConfirmDialog(null,"el tortal a pagar es de: "+prendas_vestir[i].total_pagar(num_unidades),"Total a pagar: Prendas d evestir",-1);
                                    
                                }else{
                                    JOptionPane.showConfirmDialog(null,"excede la capacidad","Alerta de bodega",-1);
                
                                }
                            }
                            JOptionPane.showConfirmDialog(null,prendas_vestir[i].toString(),"Prendas de vestir: bodega",-1);
                        }
                        if(sw==false){ //revisar
                            JOptionPane.showMessageDialog(null,"el producto no hace parte del inventario","Alerta de bodega",-1);
                        }
                            break;
                    
                        default:
                            break;
                    }

                   
                }while( JOptionPane.showConfirmDialog(null,"Desea regresar","Confirmar",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE)==0);

                    break;
                }
                case 4: {// modificar cantidad minima requerida: terminado__________________________________________________________________________________________________________________________________________________________________________

                    do{
                        String m= JOptionPane.showInputDialog(null,"1.Calzado \n 2.Prendas de vestir","Opciones: modificar cantidad minima requerida",-1);
                        int c= Integer.parseInt(m);
    
                        switch (c) {
                            case 1:
                            String mens= JOptionPane.showInputDialog(null,"ingrese el codigo del producto a modificar","Calzado: modificar cantidad minima",-1);
                            int co= Integer.parseInt(mens);
                                for(int j=0;j<cantc; j++){
                        
                                    if(calzado[j].getcodigo()==co){
                                        sw=true;
                                        String me= JOptionPane.showInputDialog(null,"ingrese el nuevo valor de la cantidad minima requeridad","Calzado",-1);
                                        int cmin= Integer.parseInt(me);
                                        calzado[j].setcant_minima(cmin);
                    
                                    }
                                    JOptionPane.showConfirmDialog(null,calzado[j].toString(),"Calzado: bodega",-1);
                                }
                                if(sw==false){
                                    System.out.println("el producto no hace parte del inventario");
                                }
                                break;
                            case 2:
                            String des= JOptionPane.showInputDialog(null,"ingrese el codigo del producto a modificar","Prendas de vestir: modificar cantidad minima",-1);
                            int code= Integer.parseInt(des);
                                for(int j=0;j<cantp; j++){
                        
                                    if(prendas_vestir[j].getcodigo()==code){
                                        sw=true;
                                        String desd= JOptionPane.showInputDialog(null,"ingrese el nuevo valor de la cantidad minima requeridad","Prendas de vestir",-1);
                                        int cmin= Integer.parseInt(desd);
                                        prendas_vestir[j].setcant_minima(cmin);
                    
                                    }
                                    JOptionPane.showConfirmDialog(null,prendas_vestir[j].toString(),"Prendas de vestir: bodega",-1);
                                }
                                if(sw==false){
                                    System.out.println("el producto no hace parte del inventario");
                                }
                                break;
                        
                            default:
                                break;
                        }
    
                       
                    }while( JOptionPane.showConfirmDialog(null,"Desea regresar","Confirmar",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE)==0);
    
                    
                    break;
                }
                case 5: {// vender producto_______________________________________________________________________________________________________________________________________________________________________________________________
                   
                    double total_pagar_desc=0;
                    double total_pagar_sindesc=0;
                    do{
                        String m= JOptionPane.showInputDialog(null,"1.Calzado \n 2.Prendas de vestir","Opciones: vender producto",-1);
                        int op= Integer.parseInt(m);

                        if(op==1){// calzado___________________________________________________________________________________________
                            String des= JOptionPane.showInputDialog(null,"ingrese el codigo del producto a vender","Calzado: vender producto",-1);
                            int cod= Integer.parseInt(des);
        
                            for(int i=0;i<cantc; i++){
                    
                                if(calzado[i].getcodigo()==cod){
        
                                    String de= JOptionPane.showInputDialog(null,"ingrese el numero de unidades a vender","Calzado: vender producto",-1);
                                    int num_unidades= Integer.parseInt(de);
                                    sw=true;
                                    if(num_unidades<=calzado[i].getcant_bodega()){
                                        double precio_descuento=calzado[i].getprecio_venta()*num_unidades*(1-porcentaje);
                                        double precio_sindes=calzado[i].getprecio_venta()*num_unidades;
        
                                        calzado[i].setcant_bodega(calzado[i].getcant_bodega()- num_unidades);
                                        
                                        total_pagar_desc+=precio_descuento;
                                        total_pagar_sindesc+=precio_sindes;
                                        JOptionPane.showConfirmDialog(null,"con descuento:  "+precio_descuento,"Calzado: total a pagar",-1);
                                        JOptionPane.showConfirmDialog(null,"sin descuento:  "+precio_sindes,"Calzado: total a pagar",-1);
        
        
                                    }else{
                                        JOptionPane.showConfirmDialog(null,"excede la capacidad","Alerta de bodega",-1);
                    
                                    }
                                }
                                JOptionPane.showConfirmDialog(null,calzado[i].toString(),"Calzado: bodega",-1);
                            }
                        }else{//prendas de vestir___________________________________________________________________________________________
                            String des= JOptionPane.showInputDialog(null,"ingrese el codigo del producto a vender","Prendas de vestir: vender producto",-1);
                            int co= Integer.parseInt(des);
        
                            for(int i=0;i<cantp; i++){
                    
                                if(prendas_vestir[i].getcodigo()==co){
        
                                    String de= JOptionPane.showInputDialog(null,"ingrese el numero de unidades a vender","Prendas de vestir: vender producto",-1);
                                    int num_unidades= Integer.parseInt(de);
                                    sw=true;
                                    if(num_unidades<=prendas_vestir[i].getcant_bodega()){
                                        double precio_descuento=prendas_vestir[i].getprecio_venta()*num_unidades*(1-porcentaje);
                                        double precio_sindes=prendas_vestir[i].getprecio_venta()*num_unidades;
        
                                        prendas_vestir[i].setcant_bodega(prendas_vestir[i].getcant_bodega()- num_unidades);
                                        
                                        total_pagar_desc+=precio_descuento;
                                        total_pagar_sindesc+=precio_sindes;
                                        
                                        JOptionPane.showConfirmDialog(null,"con descuento:  "+precio_descuento,"Prendas de vestir: total a pagar",-1);
                                        JOptionPane.showConfirmDialog(null,"sin descuento:  "+precio_sindes,"Prendas de vestir: total a pagar",-1);
        
        
                                    }else{
                                        JOptionPane.showConfirmDialog(null,"excede la capacidad","Alerta de bodega",-1);
                    
                                    }
                                }
                                JOptionPane.showConfirmDialog(null,prendas_vestir[i].toString(),"Prendas de vestir: bodega",-1);
                            }

                        }//________________________________________________________________________________________________________________________

                   
                    if(sw==false){
                        System.out.println("el producto no hace parte del inventario");
                    }

                    //total de toda la compra______________________________________________________________________________________________________

                }while(JOptionPane.showConfirmDialog(null,"¿ Desea agregar otro producto ?","Confirmar",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE)==0);
                    JOptionPane.showConfirmDialog(null,"TOTAL A PAGAR - "+total_pagar_desc,"TOTAL A PAGAR: DESCUENTO",-1);
                    JOptionPane.showConfirmDialog(null,"TOTAL A PAGAR - "+total_pagar_sindesc,"TOTAL A PAGAR: SIN DESCUENTO",-1);
                    break;//________________________________________________________________________________________________________________________
                }
                case 6:{//Consultar producto: solicite el código de un producto, el tipo (calzado o prenda) y muestre la información del mismo.
                    
                    String de= JOptionPane.showInputDialog(null,"ingrese el codigo del producto","Mostrar: inventario",-1);
                    int code= Integer.parseInt(de);
                    String d= JOptionPane.showInputDialog(null,"Tipo:  \n 1.Calzado \n 2.Prendas de vestir","Mostrar: inventario",-1);
                    int tipo= Integer.parseInt(d);

                    if(tipo==1){//Calzado
                       
                        for(int i=0; i<calzado.length;i++){
                            if(calzado[i].getcodigo()==code){
                                JOptionPane.showConfirmDialog(null, calzado[i].Mostrar(),"Calzado: bodega",-1);
                            
                            }else{
                                JOptionPane.showConfirmDialog(null,"El producto: "+code+" No existe en la bodega Calzado","alerta: bodega",-1);
                            
                            }
                        }
                       

                    }else if(tipo ==2){// prendas de vestir

                        for(int i=0; i<prendas_vestir.length;i++){
                            if(prendas_vestir[i].getcodigo()==code){
                                JOptionPane.showConfirmDialog(null, prendas_vestir[i].Mostrar(),"Calzado: bodega",-1);                           
                            }else{
                                JOptionPane.showConfirmDialog(null,"El producto: "+code+" No existe en la bodega Prendas de vestir","alerta: bodega",-1); 
                            }   
                        }
                   
                    break;
                    }
                }
                default:{
                       
                    break;
                }

             }

        }while(JOptionPane.showConfirmDialog(null,"Desea regresar al menu principal","Confirmar",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE)==0);

      
    }      

}







