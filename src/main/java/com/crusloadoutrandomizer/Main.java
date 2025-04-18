package com.crusloadoutrandomizer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);

        stage.setTitle("Gorbino´s slots | 500 hours of mind pumping gambling!") ;
        scene.getStylesheets().add(Main.class.getResource("/styles.css").toExternalForm());
        scene.getRoot().setStyle("-fx-font-family: 'MINGLIU';");
        stage.getIcons().add(new Image(Main.class.getResource("images/misc/icon.png").toExternalForm()));

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}