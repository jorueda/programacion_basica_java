public abstract class ObjetoGeografico {

    String Nombre;
    int id_objeto;
    String Municipio; 


    public ObjetoGeografico(String Nombre, int id_objeto, String Municipio) {
        this.Nombre = Nombre;
        this.id_objeto = id_objeto;
        this.Municipio = Municipio;
    }


    public String getNombre() {
        return this.Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getid_objeto() {
        return this.id_objeto;
    }

    public void setid_objeto(int id_objeto) {
        this.id_objeto = id_objeto;
    }

    public String getMunicipio() {
        return this.Municipio;
    }

    public void setMunicipio(String Municipio) {
        this.Municipio = Municipio;
    }


}