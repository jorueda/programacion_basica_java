import java.sql.Statement;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class InicioController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button createButton;

    @FXML
    private TextField codeProduct;

    @FXML
    private TextField nameProduct;

    @FXML
    private TextField precioCompra;

    @FXML
    private TextField precioVenta;

    @FXML
    private TextField cantBodega;

    @FXML
    private TextField cantMin;

    @FXML
    private TextField cantMax;

    @FXML
    private Button viewButton;

    @FXML
    private TextArea productsList;

    @FXML
    private Button btnRegistro;

    @FXML
    void Registro(ActionEvent event) {

    }

    @FXML
    void createProduct(ActionEvent event) {

        Conexion objConexion = new Conexion();

        Integer code = Integer.parseInt(codeProduct.getText());
        String name = nameProduct.getText();
        Integer pCompra = Integer.parseInt(precioCompra.getText());
        Integer pVenta = Integer.parseInt(precioVenta.getText());
        Integer cBodega = Integer.parseInt(cantBodega.getText());
        Integer cMin = Integer.parseInt(cantMin.getText());
        Integer cMax = Integer.parseInt(cantMax.getText());

        try (Connection conn = objConexion.connect(); 
            Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(
                    "INSERT INTO Productos (codigo,nombre,precio_compra,precio_venta,cant_bodega,cant_min_requerida,cant_max_inv_permitida) VALUES ("
                            + code + "," + "'" + name + "'" + "," + pCompra + "," + pVenta + "," + cBodega + "," + cMin
                            + "," + cMax + ");");
            System.out.println("Producto creado");
            codeProduct.setText("");
            nameProduct.setText("");
            precioCompra.setText("");
            precioVenta.setText("");
            cantBodega.setText("");
            cantMin.setText("");
            cantMax.setText("");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }

    @FXML
    void viewProduct(ActionEvent event) {

        Conexion objConexion = new Conexion();
        productsList.setEditable(false);
        try (Connection conn = objConexion.connect(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * from Productos");
            ResultSetMetaData rsmd = rs.getMetaData();
            int num_columnas = rsmd.getColumnCount();   
            String producto = "";
            while (rs.next()) {
                for (int i = 1; i <= num_columnas; i++) {
                    String valor = rs.getString(i);
                    producto = producto + rsmd.getColumnName(i) + ":" + " " + valor + "\n";
                }
                productsList.setText(producto);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    void initialize() {
       

    }
}