import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class reto3_controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField cantidad_cuerpos_de_agua;

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
    private TextArea texto_ingresado;

    @FXML
    private TextArea texto_procesado;

    int cantidad_cuerpos = 0;
    CuerpoDeAgua cuerpo[] = new CuerpoDeAgua[10];

    String texto_acumulado = "";
    int contador_acumulado = 0;

    @FXML
    void ingresar(ActionEvent event) {
        cantidad_cuerpos = Integer.parseInt(cantidad_cuerpos_de_agua.getText());
        
        if (contador_acumulado < cantidad_cuerpos) {
            cuerpo[contador_acumulado] = new CuerpoDeAgua(Nombre.getText(), Integer.parseInt(id_objeto.getText()), Municipio.getText(), tipo_agua.getText(), tipo_cuerpo.getText(), Float.parseFloat(IRCA.getText()));
            texto_acumulado += cuerpo[contador_acumulado].getNombre() + " " + cuerpo[contador_acumulado].getid_objeto() + " " + cuerpo[contador_acumulado].getMunicipio() + " " + cuerpo[contador_acumulado].getTipo_agua() + " " + cuerpo[contador_acumulado].getTipo_cuerpo() + " " + cuerpo[contador_acumulado].getIRCA() + "\n";
            texto_ingresado.setText(texto_acumulado);
            contador_acumulado += 1;

        } 
    
    }

    @FXML
    void procesar(ActionEvent event) {
        String texto = "";
        int contador = 0;
        float mas_alto = 0;

        for (int i = 0; i < cantidad_cuerpos; i++) {
            texto += cuerpo[i].getNombre() + " " + cuerpo[i].getMunicipio() + "\n";

            if (cuerpo[i].getIRCA() >= 35.1)
            contador += 1;

            if (cuerpo[i].getIRCA() > mas_alto)
            mas_alto = cuerpo[i].getIRCA();
        }        

        String contador_string = String.format("%.2f", (float)contador);
        texto += contador_string + "\n";

        String nombre_municipios = "";
        for (int i = 0; i < cantidad_cuerpos; i++) {
            if (CuerpoDeAgua.nivel(cuerpo[i].getIRCA()) == "ALTO")
                nombre_municipios += cuerpo[i].getMunicipio() + " ";
        }

        if (nombre_municipios == "")
            texto += "NA";
        else
            texto += nombre_municipios;

        texto += "\n" + CuerpoDeAgua.nivel(mas_alto);
        texto_procesado.setText(texto);
    }

    @FXML
    void initialize() {

    }
}
