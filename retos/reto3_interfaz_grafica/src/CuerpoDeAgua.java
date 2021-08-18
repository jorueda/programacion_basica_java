public class CuerpoDeAgua extends ObjetoGeografico {

    String tipo_agua;
    String tipo_cuerpo;
    float IRCA;    


    public CuerpoDeAgua(String Nombre, int id_objeto, String Municipio, String tipo_agua, String tipo_cuerpo, float IRCA) {
        super(Nombre, id_objeto, Municipio);
        this.tipo_agua = tipo_agua;
        this.tipo_cuerpo = tipo_cuerpo;
        this.IRCA = IRCA;
    }


    public String getTipo_agua() {
        return this.tipo_agua;
    }

    public void setTipo_agua(String tipo_agua) {
        this.tipo_agua = tipo_agua;
    }

    public String getTipo_cuerpo() {
        return this.tipo_cuerpo;
    }

    public void setTipo_cuerpo(String tipo_cuerpo) {
        this.tipo_cuerpo = tipo_cuerpo;
    }

    public float getIRCA() {
        return this.IRCA;
    }

    public void setIRCA(float IRCA) {
        this.IRCA = IRCA;
    }


    public static String nivel(float irca_recibido) {

        String texto_nivel = "SIN RIESGO";
        if (irca_recibido >= 80.1 && irca_recibido <= 100)
            texto_nivel = "INVIABLE SANITARIAMENTE";
        else if (irca_recibido >= 35.1 && irca_recibido <= 80)
            texto_nivel = "ALTO";
        else if (irca_recibido >= 14.1 && irca_recibido <= 35)
            texto_nivel = "MEDIO";
        else if (irca_recibido >= 5.1 && irca_recibido <= 14)
            texto_nivel = "BAJO";

        return texto_nivel;
    }

}