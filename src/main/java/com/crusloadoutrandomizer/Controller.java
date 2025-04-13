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

import static com.crusloadoutrandomizer.ImageGroups.*;

public class Controller {
    @FXML private AnchorPane anpMain;
    @FXML private GridPane grpMain;

    @FXML private ImageView imvHead, imvChest, imvArms, imvLegs, imvWeapon1, imvWeapon2, imvMission, imvPunishment, imvChaos;
    @FXML private Label lblHead, lblChest, lblArms, lblLegs, lblWeapon1, lblWeapon2, lblMission, lblPunishment, lblChaos;

    private Slot slotHead, slotChest, slotArms, slotLegs, slotWeapon1, slotWeapon2, slotMission, slotPunishment, slotChaos;

    private double defaultPadding = 60;
    private double initialLoadoutWidth;
    private double initialLoadoutHeight;
    private double initialImageSize = 50.0;

    @FXML
    public void initialize() {
        ImageProcessor imageProcessor = new ImageProcessor(ImageGroups.BORDERS_W_BG);
        anpMain.setBackground(imageProcessor.imageToBackground(
                imageProcessor.findImage("Divine Light.png")));

        anpMain.widthProperty().addListener((obs, oldVal, newVal) -> {
            double scale = (double)newVal / anpMain.getPrefWidth();
            grpMain.setPadding(new Insets(defaultPadding * scale));
        });
        anpMain.heightProperty().addListener((obs, oldVal, newVal) -> {
            double scale = (double)newVal / anpMain.getPrefHeight();
            grpMain.setPadding(new Insets(defaultPadding * scale));
        });

        slotHead = new Slot(imvHead, lblHead, HEAD);
        slotChest = new Slot(imvChest, lblChest, CHEST);
        slotArms = new Slot(imvArms, lblArms, ARMS);
        slotLegs = new Slot(imvLegs, lblLegs, LEGS);
        slotWeapon1 = new Slot(imvWeapon1, lblWeapon1, WEAPONS);
        slotWeapon2 = new Slot(imvWeapon2, lblWeapon2, WEAPONS);
        slotMission = new Slot(imvMission, lblMission, MISSIONS);
        slotPunishment = new Slot(imvPunishment, lblPunishment, PUNISHMENT);
        slotChaos = new Slot(imvChaos, lblChaos, CHAOS);
    }

    @FXML
    private void handleRerollAllClick() {
        slotHead.roll();
        slotChest.roll();
        slotArms.roll();
        slotLegs.roll();
        slotMission.roll();
        slotWeapon1.roll();
        slotWeapon2.roll();
        slotPunishment.roll();
        slotChaos.roll();
    }

    @FXML
    private void handleHeadClick() {
        slotHead.roll();
    }

    @FXML
    private void handleChestClick() {
        slotChest.roll();
    }

    @FXML
    private void handleArmsClick() {
        slotArms.roll();
    }

    @FXML
    private void handleLegsClick() {
        slotLegs.roll();
    }

    @FXML
    private void handleWeapon1Click() {
        slotWeapon1.roll();
    }

    @FXML
    private void handleWeapon2Click() {
        slotWeapon2.roll();
    }

    @FXML
    private void handleMissionClick() {
        slotMission.roll();
    }

    private void roll(ImageView imageView, Label label) {

        System.out.println("asdasdas");
        //        int idx = (int)(Math.random() * files.length);
//        Image image = imageProcessor.findImage(files[idx].getName());
//        String name = files[idx].getName();
//
//        imageView.setImage(image);
//        label.setText(name);
        startAnimation(imageView, label);
    }

    public void startAnimation(ImageView imageView, Label label) {
        ImageProcessor imageProcessor = new ImageProcessor(HEAD);
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
