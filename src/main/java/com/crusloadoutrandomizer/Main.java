package com.crusloadoutrandomizer;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {






        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        scene.getRoot().setStyle("-fx-font-family: 'MINGLIU';");


        stage.setTitle("Gorbino´s slots | 500 hours of mind pumping gambling!") ;
        stage.setScene(scene);
        stage.show();
    }

    public void start1(Stage st)
    {
        try {
            st.widthProperty().addListener((obs, oldVal, newVal) -> {
                //System.out.println("Width: " + newVal);
                st.setHeight((Double)newVal * 9 / 16);
                System.out.println(st.widthProperty());
                System.out.println(st.heightProperty());

            });


            st.widthProperty().addListener(new ChangeListener<Number>() {
                @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) {
                    //System.out.println("Width: " + newSceneWidth);
                }
            });
            st.heightProperty().addListener(new ChangeListener<Number>() {
                @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) {
                   //System.out.println("Height: " + newSceneHeight);
                }
            });


            st.show();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }




    public static void main(String[] args) {
        launch();
    }
}