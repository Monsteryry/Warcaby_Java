package FXSimpleAppFXMLiCSS.FXSimpleAppFXML;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

        Scene scene = new Scene(root, 640, 480);

        stage.setTitle("FXML Welcome");
        stage.setScene(scene);
        stage.show();
    }

    public void buttonClickHandler(ActionEvent actionEvent) {
        System.out.println("HELLO WORLD!");
    }
}