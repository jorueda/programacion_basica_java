import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ToggleGroup;

public class operaciones_controller implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField num1;

    @FXML
    private TextField num2;

    @FXML
    private TextField resultado;

    @FXML
    private RadioButton rdb_sum;

    @FXML
    private RadioButton rdb_res;

    @FXML
    private RadioButton rdb_mul;

    @FXML
    private RadioButton rdb_div;

    @FXML
    void realizar_calculo(ActionEvent event) {
        int operador1 = Integer.parseInt(num1.getText());
        int operador2 = Integer.parseInt(num2.getText());

        Operaciones operador = new Operaciones(operador1, operador2);

        if (rdb_sum.isSelected())
            resultado.setText(operador.sumar() + "");
        else if (rdb_res.isSelected())
            resultado.setText(operador.restar() + "");
        else if (rdb_mul.isSelected())
            resultado.setText(operador.multiplicar() + "");
        else if (rdb_div.isSelected()) {
            if (operador2 == 0) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error");
                alerta.setContentText("El operador 2 no puede ser 0.");
                alerta.showAndWait();
                num2.setText("");
            } else
                resultado.setText(operador.dividir() + "");
            }   

    }

    @FXML
    void resetear(ActionEvent event) {
        num1.setText("");
        num2.setText("");
        resultado.setText("");
    }

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup tg = new ToggleGroup();
        rdb_sum.setToggleGroup(tg);
        rdb_res.setToggleGroup(tg);
        rdb_mul.setToggleGroup(tg);
        rdb_div.setToggleGroup(tg);
    }
}
