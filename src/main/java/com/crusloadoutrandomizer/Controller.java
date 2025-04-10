package com.crusloadoutrandomizer;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Controller {
    @FXML
    private Label welcomeText;

    @FXML
    private StackPane stpMain;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    public void initialize() {
        ImageProcessor imageProcessor = new ImageProcessor();

        stpMain.setBackground(imageProcessor.imageToBackground(imageProcessor.findImage(ImageGroups.BORDERS_W_BG, "Divine Light.png")));

        // Этот метод вызывается после загрузки FXML
        System.out.println("VBox найден: " + stpMain);

        // Можно работать с VBox, например, добавить в него кнопку
        Button btn = new Button("Новая кнопка");
        stpMain.getChildren().add(btn);
    }
}