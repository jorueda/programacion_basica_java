import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

@FXML
void viewProduct(ActionEvent event) {
    Conexion con = new Conexion();
    try (Connection conn = con.connect(); Statement stmt = conn.createStatement()) {
        ResultSet rs = stmt.executeQuery("SELECT * FROM Producto");
        ResultSetMetaData rsmd = rs.getMetadata();
        int num_columnas = rsmd.getColumnCount();

        String producto = "";

        while (rs.next()) {
            for (int i = 1; i <= num_columnas; i++) {
                String contenido = rs.getString(i);
                producto = producto + rsmd.getColumnName(i) + ": " + contenido + "\n";
            }
            productList.setText(producto);
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }

}

// Conectarse para insertar un nuevo producto
Conexion objConexion = new Conexion();
try (Connection conn = objConexion.connect(); 
            Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(
                    "INSERT INTO Productos (codigo,nombre,precio_compra,precio_venta,cant_bodega,cant_min_requerida,cant_max_inv_permitida) VALUES ("
                            + code + "," + "'" + name + "'" + "," + pCompra + "," + pVenta + "," + cBodega + "," + cMin
                            + "," + cMax + ");");
            System.out.println("Producto creado");