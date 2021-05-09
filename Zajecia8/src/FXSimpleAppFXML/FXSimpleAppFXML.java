package FXSimpleAppFXML;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FXSimpleAppFXML extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("FXSimpleAppFXML.fxml"));

        Scene scene = new Scene(root, 300, 250);

        stage.setTitle("FXML Welcome");
        stage.setScene(scene);
        stage.show();
    }

    public void buttonClickHandler(ActionEvent actionEvent) {
        System.out.println("HELLO WORLD!");
    }
}