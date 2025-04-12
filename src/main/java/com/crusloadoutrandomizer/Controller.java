package com.crusloadoutrandomizer;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.io.File;

public class Controller {
    @FXML private AnchorPane anpMain;
    @FXML private GridPane grpMain;

    @FXML private ImageView imvHead, imvChest, imvArms, imvLegs;
    @FXML private Label lblHead, lblChest, lblArms, lblLegs;

    private double defaultPadding = 60;
    private double initialLoadoutWidth;
    private double initialLoadoutHeight;
    private double initialImageSize = 50.0;

    @FXML
    public void initialize() {
        ImageProcessor imageProcessor = new ImageProcessor(ImageGroups.BORDERS_W_BG);
        anpMain.setBackground(imageProcessor.imageToBackground(
                imageProcessor.findImage("Divine Light.png")));

        roll(imvHead, lblHead);
        roll(imvChest, lblChest);

        anpMain.widthProperty().addListener((obs, oldVal, newVal) -> {
            double scale = (double)newVal / anpMain.getPrefWidth();


            //grpMain.setPadding(new Insets(anpMain.getPadding().getTop(), defaultPadding * scale, anpMain.getPadding().getBottom(), defaultPadding * scale));
            grpMain.setPadding(new Insets(defaultPadding * scale));
        });
        anpMain.heightProperty().addListener((obs, oldVal, newVal) -> {
            double scale = (double)newVal / anpMain.getPrefHeight();
            //grpMain.setPadding(new Insets(defaultPadding * scale, anpMain.getPadding().getRight(), defaultPadding * scale, anpMain.getPadding().getLeft()));
            grpMain.setPadding(new Insets(defaultPadding * scale));


        });

    }

    private void roll(ImageView imageView, Label label) {


//        int idx = (int)(Math.random() * files.length);
//        Image image = imageProcessor.findImage(files[idx].getName());
//        String name = files[idx].getName();
//
//        imageView.setImage(image);
//        label.setText(name);
        startAnimation(imageView, label);
    }

    public void startAnimation(ImageView imageView, Label label) {
        ImageProcessor imageProcessor = new ImageProcessor(ImageGroups.HEAD);
        File[] files = imageProcessor.getFiles();


        int baseDelay = 100;
        int iterations = 100;

        Timeline timeline = new Timeline();
        timeline.setCycleCount(iterations);

        KeyFrame keyFrame = new KeyFrame(Duration.millis(baseDelay), event -> {
            int idx = (int)(Math.random() * files.length);
            Image image = imageProcessor.findImage(files[idx].getName());
            String name = files[idx].getName();

            imageView.setImage(image);
            label.setText(name);
        });

        timeline.getKeyFrames().add(keyFrame);
        timeline.play();




    }




}
