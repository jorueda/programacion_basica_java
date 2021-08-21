import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private Button btnLogin;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Label mensajeError;

    @FXML
    void Iniciarsesion(ActionEvent event) throws IOException {
        String usuario = username.getText();
        String contrasena = password.getText();
        String error = "";

        if (usuario.equals("prueba") || usuario.contains("prueba")) {
            error = "Usuario no válido";
        }

        if (contrasena.length() < 6) {
            error = "Contraseña debe contar con más de 6 caracteres. Intente nuevamente";
        } else if (contrasena.equals(usuario)) {
            error = "Contraseña no puede ser igual a usuario. Intente nuevamente";
        }

        if (error.isEmpty()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/frmInicio.fxml"));
            Parent root = loader.load();
            loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();   
        } else {
            mensajeError.setText(error);
        }
     
    }

}

