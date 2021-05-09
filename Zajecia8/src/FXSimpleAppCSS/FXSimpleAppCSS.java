package FXSimpleAppCSS;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FXSimpleAppCSS extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Scene scene;
        StackPane root = new StackPane();
        Button btn = new Button();

        primaryStage.setTitle("Hello World!");


        btn.setText("Przywitaj się!");
        btn.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println("HELLO WORLD!");
                    }
                }
        );
        btn.setId("btn");

        root.getChildren().add(btn);
        scene = new Scene(root, 300, 250);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(FXSimpleAppCSS.class.getResource("style.css").toExternalForm());
        primaryStage.show();
    }
}
