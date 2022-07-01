package games.mongodb.mongodbquizgame;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import org.bson.Document;


import java.net.URL;
import java.util.ResourceBundle;

public class QuizController implements Initializable {

    private static final String MONGODB_IP = "localhost";
    private static final int MONGODB_PORT = 27017;

    //Main menu
    @FXML
    private Pane titlePane;
    @FXML
    private Button playButton;
    @FXML
    private Button questionButton;
    @FXML
    private Button exitButton;

    //Question menu
    @FXML
    private Pane questionPane;
    @FXML
    private Button backToMenuButton;
    @FXML
    private Button removeSelectedButton;
    @FXML
    private Button addQuestionButton;



    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    private MongoCollection<Document> mongoCollection;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        mongoClient = new MongoClient(MONGODB_IP,MONGODB_PORT);
        mongoDatabase = mongoClient.getDatabase("MyTests");
        mongoCollection = mongoDatabase.getCollection("questions");

        //tested connection - working
        /*Document document = new Document();
        document.put("Question", "Cake is a lie");
        document.put("Answers", List.of("Yes","Of course","Bet u know it", "Not this time"));
        document.put("CorrectAnswer", "Not this time");
        document.put("HardnessLevel", "Easy");

        mongoCollection.insertOne(document);*/

    }

    //Buttons actions On Main Menu (titlePane)
    public void Play(){

        SetButtonsDisable(true, new Button[] {playButton, exitButton, questionButton});

        fadeOut(titlePane, questionPane);

        SetButtonsDisable(false, new Button[] {addQuestionButton, backToMenuButton, removeSelectedButton});
    }
    public void Exit(){

    }
    public void Questions(){

    }
    
    //Buttons actions On questionPane
    public void BackToMenu(){

        SetButtonsDisable(true, new Button[] {addQuestionButton, backToMenuButton, removeSelectedButton});

        fadeOut(questionPane, titlePane);

        SetButtonsDisable(false, new Button[] {playButton, exitButton, questionButton});
    }

    //Sets Button state
    private static void SetButtonsDisable(boolean state, Button[] buttons){

        for(Button button : buttons)
            button.setDisable(state);

    }

    private void fadeOut(Pane toFadeOut, Pane toFadeIn){

        toFadeOut.setDisable(true);

        ParallelTransition parallelTransition = new ParallelTransition();

        parallelTransition.setOnFinished(event -> {
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.3), toFadeOut);
            fadeTransition.setFromValue(1.0);
            fadeTransition.setToValue(0.0);
            fadeTransition.play();
        });

        parallelTransition.play();

        ParallelTransition parallelTransition1 = new ParallelTransition();

        parallelTransition1.setOnFinished(event -> {
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.3), toFadeIn);
            fadeTransition.setFromValue(0.0);
            fadeTransition.setToValue(1.0);
            fadeTransition.play();
        });

        parallelTransition1.play();

        toFadeIn.setDisable(false);

    }
}