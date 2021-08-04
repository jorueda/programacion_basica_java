import
javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import
javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class App extends Application {
public static void main(String[] args)
{
launch(args);
}

@Override
public void start(Stage primaryStage) {
primaryStage.setTitle("Hello! Group 58 MinTic"); Button btn = new Button();
btn.setText("Say 'Hello World'");
btn.setOnAction(new EventHandler<ActionEvent>() {
@Override
public void handle(ActionEvent event)
{ System.out.println("Hello! Estamos en la configuración de Javafx");
}
});
StackPane root = new StackPane();
root.getChildren().add(btn);
primaryStage.setScene(new Scene(root, 300, 250));
primaryStage.show();
}
}