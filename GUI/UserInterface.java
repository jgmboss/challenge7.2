import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;

public class UserInterface{
    public static void main (String args[]){
        launchFX();
    }

    public static void launchFX()
    {
        // Initialises JavaFX
        new JFXPanel();
        // Runs initialisation on the JavaFX thread
        Platform.runLater(() -> initialiseGUI());
    }

    public static void initialiseGUI()
    {
        Stage stage = new Stage();
        stage.setTitle("My First GUI");
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane)); 
        stage.setWidth(1024);
        stage.setHeight(768);
        stage.show();

        Button btn = new Button();
        btn.setText("Try me!");
        btn.setLayoutX(500);
        btn.setLayoutY(390);
        btn.setOnAction((ActionEvent ae) -> printHello());
        rootPane.getChildren().add(btn);
    }

    private static void printHello(){
        System.out.println("You're cool");
    }
}