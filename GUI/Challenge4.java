import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField; //must now import this for the textfield
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.stage.WindowEvent;
import javafx.scene.control.Label; //needed to print something
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;//two needed to add image


public class Challenge4
{
    private static TextField txtFieldRanks;
    private static TextField txtFieldUni;
    private static TextField txtFieldCountry;

    public static void main (String args[])//to start the GUI
    {
        launchFX();
    }

    private static void launchFX()
    {
        new JFXPanel();
        Platform.runLater(() -> initialiseGUI());
    }

    private static void initialiseGUI()//details on actual GUI
    {

        Stage stage = new Stage();
        stage.setTitle("Top Universities by Jogerson"); //displayed name on the window
        stage.setResizable(false);
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        stage.setWidth(700);
        stage.setHeight(600);
        stage.show();

        Label label = new Label("Enter details of topUniversitys"); //prints onto the GUI but doesnt make it a button
        label.setLayoutX(30);
        label.setLayoutY(50);
        rootPane.getChildren().add(label);

        Button btn = new Button();
        txtFieldRanks = new TextField();
        txtFieldRanks.setLayoutX(30);
        txtFieldRanks.setLayoutY(100);
        txtFieldRanks.setPrefWidth(200);
        txtFieldRanks.setPromptText("Enter Ranking"); //input
        rootPane.getChildren().add(txtFieldRanks);

        Button btn2 = new Button();
        txtFieldUni = new TextField();
        txtFieldUni.setLayoutX(30);
        txtFieldUni.setLayoutY(150);
        txtFieldUni.setPrefWidth(200);
        txtFieldUni.setPromptText("Enter Name"); //input
        rootPane.getChildren().add(txtFieldUni);

        Button btn3 = new Button();
        txtFieldCountry = new TextField();
        txtFieldCountry.setLayoutX(30);
        txtFieldCountry.setLayoutY(200);
        txtFieldCountry.setPrefWidth(200);
        txtFieldCountry.setPromptText("Enter Country"); //input
        rootPane.getChildren().add(txtFieldCountry);

        btn.setText("Enter");
        btn.setLayoutX(30);
        btn.setLayoutY(500);
        btn.setOnAction((ActionEvent ae) -> printMessage());//button for action
        rootPane.getChildren().add(btn);
        
        // load the image
        Image image = new Image("kobe.jpeg");
        ImageView iv1 = new ImageView();
        iv1.setImage(image);
        iv1.setLayoutX(90); //image location
        iv1.setLayoutY(280); //image location
        iv1.setFitWidth(500); //image width
        iv1.setPreserveRatio(true);
        rootPane.getChildren().add(iv1); 
 

    }

    private static void printMessage()
    {
      String ranking = txtFieldRanks.getText();
        System.out.println(ranking);
        String uni = txtFieldUni.getText();
        System.out.println(uni);
        String country = txtFieldCountry.getText();
        System.out.println(country);
    }
}

