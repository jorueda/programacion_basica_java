import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

        Connection connect() {
        String url = "jdbc:sqlite:C:/Users/jorge/Documents/programacion_basica_java/retos/reto4/src/cuerpos_de_agua.db";
        Connection conn = null;
        try {
            // Creamos la conexión
            conn = DriverManager.getConnection(url);
            System.out.println("Se ha establecido la conexión con la BD.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}