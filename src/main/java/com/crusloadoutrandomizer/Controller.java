package com.crusloadoutrandomizer;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.File;

import static com.crusloadoutrandomizer.ImageGroup.*;

public class Controller {
    @FXML private AnchorPane anpMain;
    @FXML private GridPane grpMain;

    @FXML private ImageView imvHead, imvChest, imvArms, imvLegs, imvWeapon1, imvWeapon2, imvMission, imvPunishment, imvChaos;
    @FXML private Label lblHead, lblChest, lblArms, lblLegs, lblWeapon1, lblWeapon2, lblMission, lblPunishment, lblChaos;

    private Slot slotHead, slotChest, slotArms, slotLegs, slotWeapon1, slotWeapon2, slotMission, slotPunishment, slotChaos, slotBorder;
    private Slot[] slots;

    private double defaultPadding = 60;

    @FXML
    public void initialize() {
        ImageProcessor imageProcessor = new ImageProcessor(BORDERS);
        anpMain.setBackground(imageProcessor.imageToBackground(imageProcessor.findImage("Divine Light.png")));

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
        slotBorder = new Slot(null, null, BORDERS);

        slots = new Slot[] {
                slotHead, slotChest, slotArms, slotLegs,
                slotMission, slotWeapon1, slotWeapon2,
                slotPunishment, slotChaos
        };
    }

    @FXML
    private void handleRerollAllClick() {
        for (Slot slot : slots) {
            slot.roll();
        }
        slotBorder.rollBackground(anpMain);
    }

    @FXML
    private void handleQuickReroll() {
        for (Slot slot : slots) {
            slot.roll(1);
        }
        slotBorder.rollBackground(1, anpMain);
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

    @FXML
    private void handlePunishmentClick() {
        slotPunishment.roll();
    }

    @FXML
    private void handleChaosClick() {
        slotChaos.roll();
    }

    @FXML
    private void handleBorderClick() {
        slotBorder.rollBackground(anpMain);
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
