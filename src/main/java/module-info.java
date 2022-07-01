module games.mongodb.mongodbquizgame {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires mongo.java.driver;

    opens games.mongodb.mongodbquizgame to javafx.fxml;
    exports games.mongodb.mongodbquizgame;
}