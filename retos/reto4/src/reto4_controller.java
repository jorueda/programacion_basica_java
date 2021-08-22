import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class reto4_controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Tab ingresar_tab;

    @FXML
    private TextField Nombre;

    @FXML
    private TextField id_objeto;

    @FXML
    private TextField Municipio;

    @FXML
    private TextField tipo_agua;

    @FXML
    private TextField tipo_cuerpo;

    @FXML
    private TextField IRCA;

    @FXML
    private Tab procesar_datos_tab;

    @FXML
    private TextArea texto_ingresado;

    @FXML
    private TextArea texto_procesado;

    @FXML
    private Tab editar_tab;

    @FXML
    private TextField Nombre_editar;

    @FXML
    private TextField id_editar;

    @FXML
    private TextField Municipio_editar;

    @FXML
    private TextField tipo_agua_editar;

    @FXML
    private TextField tipo_cuerpo_editar;

    @FXML
    private TextField IRCA_editar;

    @FXML
    private TextField id_buscar;

    @FXML
    void boton_buscar(ActionEvent event) {
        Conexion objConexion = new Conexion();
        try (Connection conn = objConexion.connect();
            Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM CuerposDeAgua WHERE id_objeto = " + id_buscar.getText());
            ResultSetMetaData rsmd = rs.getMetaData();
            int num_columnas = rsmd.getColumnCount();   
            while (rs.next()) {
                for (int i = 1; i <= num_columnas; i++) {
                    String valor = rs.getString(i);
                    switch (rsmd.getColumnName(i)) {
                        case "id_objeto": id_editar.setText(valor);
                            break;
                        case "Nombre": Nombre_editar.setText(valor);
                            break;
                        case "Municipio": Municipio_editar.setText(valor);
                            break;
                        case "tipo_agua": tipo_agua_editar.setText(valor);
                            break;
                        case "tipo_cuerpo": tipo_cuerpo_editar.setText(valor);
                            break;
                        case "IRCA": IRCA_editar.setText(valor);
                            break;
                    };
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    void boton_editar(ActionEvent event) {
        if (Nombre_editar.getText().equals("") || id_editar.getText().equals("") || Municipio_editar.getText().equals("") || tipo_agua_editar.getText().equals("") || tipo_cuerpo_editar.getText().equals("") || IRCA_editar.getText().equals("")) {
            
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Campos vacíos");
            alerta.setHeaderText("Hay al menos un campo vacío. Por favor rellenar todos los campos.");
            alerta.showAndWait();

        } else {
            Conexion objConexion = new Conexion();
            String Nombre_ingresado = Nombre_editar.getText();
            Integer id_objeto_ingresado = Integer.parseInt(id_editar.getText());
            String Municipio_ingresado = Municipio_editar.getText();
            String tipo_agua_ingresado = tipo_agua_editar.getText();
            String tipo_cuerpo_ingresado = tipo_cuerpo_editar.getText();
            Float IRCA_ingresado = Float.parseFloat(IRCA_editar.getText());

            try (Connection conn = objConexion.connect();
                Statement stmt = conn.createStatement()) {
                stmt.executeUpdate(
                "UPDATE CuerposDeAgua SET id_objeto = "
                    + id_objeto_ingresado +  ", Nombre = '"
                    + Nombre_ingresado + "', Municipio = '"
                    + Municipio_ingresado + "', tipo_agua = '"
                    + tipo_agua_ingresado + "', tipo_cuerpo = '"
                    + tipo_cuerpo_ingresado + "', IRCA = "
                    + IRCA_ingresado + " WHERE id_objeto = "
                    + id_objeto_ingresado);
                
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Objeto editado");
                alerta.setHeaderText("Objeto tipo Cuerpo de Agua con id " + id_buscar.getText() + " editado.");
                alerta.showAndWait();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    @FXML
    void boton_eliminar(ActionEvent event) {
        if (Nombre_editar.getText().equals("") || id_editar.getText().equals("") || Municipio_editar.getText().equals("") || tipo_agua_editar.getText().equals("") || tipo_cuerpo_editar.getText().equals("") || IRCA_editar.getText().equals("")) {
            
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Campos vacíos");
            alerta.setHeaderText("Hay al menos un campo vacío. Por favor rellenar todos los campos.");
            alerta.showAndWait();

        } else {
            Conexion objConexion = new Conexion();
            try (Connection conn = objConexion.connect();
                Statement stmt = conn.createStatement()) {
                stmt.executeUpdate("DELETE FROM CuerposDeAgua WHERE id_objeto = " + id_buscar.getText());
                
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Objeto eliminado");
                alerta.setHeaderText("Objeto tipo Cuerpo de Agua con id " + id_buscar.getText() + " eliminado.");
                alerta.showAndWait();

                id_buscar.setText("");
                Nombre_editar.setText("");
                id_editar.setText("");
                Municipio_editar.setText("");
                tipo_agua_editar.setText("");
                tipo_cuerpo_editar.setText("");
                IRCA_editar.setText("");
                
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    @FXML
    void boton_ingresar(ActionEvent event) {
        if (Nombre.getText().equals("") || id_objeto.getText().equals("") || Municipio.getText().equals("") || tipo_agua.getText().equals("") || tipo_cuerpo.getText().equals("") || IRCA.getText().equals("")) {

            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Campos vacíos");
            alerta.setHeaderText("Hay al menos un campo vacío. Por favor rellenar todos los campos.");
            alerta.showAndWait();

        } else {
            Conexion objConexion = new Conexion();
            String Nombre_ingresado = Nombre.getText();
            Integer id_objeto_ingresado = Integer.parseInt(id_objeto.getText());
            String Municipio_ingresado = Municipio.getText();
            String tipo_agua_ingresado = tipo_agua.getText();
            String tipo_cuerpo_ingresado = tipo_cuerpo.getText();
            Float IRCA_ingresado = Float.parseFloat(IRCA.getText());

            try (Connection conn = objConexion.connect();
                Statement stmt = conn.createStatement()) {
                stmt.executeUpdate(
                "INSERT INTO CuerposDeAgua (id_objeto, Nombre, Municipio, tipo_agua, tipo_cuerpo, IRCA) VALUES ("
                            + id_objeto_ingresado + ",'"
                            + Nombre_ingresado + "','"
                            + Municipio_ingresado + "','"
                            + tipo_agua_ingresado + "','"
                            + tipo_cuerpo_ingresado + "',"
                            + IRCA_ingresado + ");");

                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Objeto creado");
                alerta.setHeaderText("Objeto tipo Cuerpo de Agua con id " + id_objeto.getText() + " creado.");
                alerta.showAndWait();

                Nombre.setText("");
                id_objeto.setText("");
                Municipio.setText("");
                tipo_agua.setText("");
                tipo_cuerpo.setText("");
                IRCA.setText("");

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    @FXML
    void boton_obtener_datos(ActionEvent event) {
        Conexion objConexion = new Conexion();
        try (Connection conn = objConexion.connect();
            Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM CuerposDeAgua");
            ResultSetMetaData rsmd = rs.getMetaData();
            int num_columnas = rsmd.getColumnCount();   
            String fila = "";
            while (rs.next()) {
                for (int i = 1; i <= num_columnas; i++) {
                    String valor = rs.getString(i);
                    fila += rsmd.getColumnName(i) + ":" + " " + valor + "\n";
                }
                fila += "\n";
            }
            texto_ingresado.setText(fila);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    void boton_procesar_datos(ActionEvent event) {
        String fila = "";
        int contador = 0;
        float mas_alto = 0;

        Conexion objConexion = new Conexion();
        try (Connection conn = objConexion.connect();
            Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * from CuerposDeAgua");
            ResultSetMetaData rsmd = rs.getMetaData();
            int num_columnas = rsmd.getColumnCount();
            String nombre_municipios = "";
            
            while (rs.next()) {
                String municipio = "";
                for (int i = 1; i <= num_columnas; i++) {
                    String valor = rs.getString(i);
                    if (rsmd.getColumnName(i).equals("Nombre"))
                        fila += valor + " ";
                    else if (rsmd.getColumnName(i).equals("Municipio")) {
                        fila += valor + " \n";
                        municipio = valor;
                        }
                    else if (rsmd.getColumnName(i).equals("IRCA")) {
                        if (Double.compare(Float.parseFloat(valor), 35) > 0)
                            contador += 1;
                        if (Double.compare(Float.parseFloat(valor), mas_alto) > 0)
                            mas_alto = Float.parseFloat(valor);
                        if (CuerpoDeAgua.nivel(Float.parseFloat(valor)).equals("ALTO"))
                            nombre_municipios += municipio + " ";
                        
                    }
                    
                }
                
            }
            String contador_string = String.format("%.2f", (float)contador);
            fila += contador_string + "\n";

            if (nombre_municipios == "")
                fila += "NA\n";
            else
                fila += nombre_municipios + "\n";

            fila += CuerpoDeAgua.nivel(mas_alto) + "\n";

            texto_procesado.setText(fila);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

    @FXML
    void initialize() {

    }
}
