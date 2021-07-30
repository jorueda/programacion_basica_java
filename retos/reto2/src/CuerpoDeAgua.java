public class CuerpoDeAgua {

    String Nombre;
    int Id_cuerpo_agua;
    String Municipio;
    float IRCA;    


    public CuerpoDeAgua(String Nombre, int Id_cuerpo_agua, String Municipio, float IRCA) {
        this.Nombre = Nombre;
        this.Id_cuerpo_agua = Id_cuerpo_agua;
        this.Municipio = Municipio;
        this.IRCA = IRCA;
    }


    public String getNombre() {
        return this.Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getId_cuerpo_agua() {
        return this.Id_cuerpo_agua;
    }

    public void setId_cuerpo_agua(int Id_cuerpo_agua) {
        this.Id_cuerpo_agua = Id_cuerpo_agua;
    }

    public String getMunicipio() {
        return this.Municipio;
    }

    public void setMunicipio(String Municipio) {
        this.Municipio = Municipio;
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