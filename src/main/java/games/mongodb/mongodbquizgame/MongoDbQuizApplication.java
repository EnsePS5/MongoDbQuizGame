package games.mongodb.mongodbquizgame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MongoDbQuizApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MongoDbQuizApplication.class.getResource("quiz.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Quiz game!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}