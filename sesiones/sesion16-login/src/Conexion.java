import java.sql.DriverManager;
import java.sql.Connection;

public class Conexion {
    
    Connection connect() {
        String url = "jdbc:sqlite:C:/SQLite/Databases/Almacen.db";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Se ha establecido la conexión con la base de datos.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
}
