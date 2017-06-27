import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField; //must now import this for the textfield
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.stage.WindowEvent;
import javafx.scene.control.ListView;
import java.util.ArrayList;
import javafx.scene.input.MouseEvent;

public class challenge6
{
    private static TextField txtFieldRank;
    private static TextField txtFieldUni;
    private static TextField txtFieldCountry;
    private static ListView<University> uniListView;
    private static ArrayList<University> uniArrList = new ArrayList<University>();
    private static University currentlySelectedUniversity = null;

    public static void main (String args[])//to start the GUI
    {
        launchFX();
    }

    private static void launchFX()
    {
        new JFXPanel();
        Platform.runLater(() -> initialiseGUI());
    }

    private static void initialiseGUI()
    {
        Stage stage = new Stage();
        stage.setTitle("Top Universities by Jogerson");
        stage.setResizable(true);
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        stage.setWidth(1024);
        stage.setHeight(768);
        stage.setOnCloseRequest((WindowEvent we) -> terminate());
        stage.show();

        uniListView = new ListView<University>();
        uniListView.setLayoutX(700);
        uniListView.setLayoutY(50);
        uniListView.setOnMouseClicked((MouseEvent me) -> {
                currentlySelectedUniversity = uniListView.getSelectionModel().getSelectedItem();
            });
        rootPane.getChildren().add(uniListView);

        txtFieldRank = new TextField();
        txtFieldRank.setLayoutX(50);
        txtFieldRank.setLayoutY(100);
        txtFieldRank.setPrefWidth(200);
        txtFieldRank.setPromptText("Enter Ranking");
        rootPane.getChildren().add(txtFieldRank);

        txtFieldUni = new TextField();
        txtFieldUni.setLayoutX(50);
        txtFieldUni.setLayoutY(150);
        txtFieldUni.setPrefWidth(200);
        txtFieldUni.setPromptText("Enter Name");
        rootPane.getChildren().add(txtFieldUni);

        txtFieldCountry = new TextField();
        txtFieldCountry.setLayoutX(50);
        txtFieldCountry.setLayoutY(200);
        txtFieldCountry.setPrefWidth(400);
        txtFieldCountry.setPromptText("Enter Country");
        rootPane.getChildren().add(txtFieldCountry);

        Button btn = new Button();
        btn.setText("Add");
        btn.setLayoutX(50);
        btn.setLayoutY(500);
        btn.setOnAction((ActionEvent ae) -> addNewItem());
        rootPane.getChildren().add(btn);

        Button btn2 = new Button();
        btn2.setText("Delete");
        btn2.setLayoutX(50);
        btn2.setLayoutY(550);
        btn2.setOnAction((ActionEvent ae) -> deleteItem());
        rootPane.getChildren().add(btn2);

    }

    private static void addNewItem() {
        int rank = Integer.parseInt(txtFieldRank.getText());
        String name = txtFieldUni.getText();
        String country = txtFieldCountry.getText();
        uniArrList.add(new University(rank, name, country));
        updateListView();
    }

    private static void updateListView(){
        uniListView.getItems().clear();

        for(University uni : uniArrList){ 
            uniListView.getItems().add(uni);
        }

    }

    private static void deleteItem() {
        System.out.print("Sup");
        uniArrList.remove(currentlySelectedUniversity);
        updateListView();

    }

    private static void terminate()
    {
        System.out.println("Bye, Bye!");
        System.exit(0);
    }

}