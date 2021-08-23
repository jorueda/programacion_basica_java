public class DensidadPoblacional extends ObjetoGeografico {


    public DensidadPoblacional(String Nombre, int id_objeto, String Municipio) {
        super(Nombre, id_objeto, Municipio);
    }


    public static int afeccion(int habitantes) {

        int nivel_afeccion = 0;
        if (habitantes < 10000)
            nivel_afeccion = 0;
        else if (habitantes >= 10000 && habitantes <= 50000)
            nivel_afeccion = 1;
        else
            nivel_afeccion = 2;

        return nivel_afeccion;
    }

}
