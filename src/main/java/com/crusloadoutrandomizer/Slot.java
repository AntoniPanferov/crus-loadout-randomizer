package com.crusloadoutrandomizer;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.*;

import static com.crusloadoutrandomizer.ImageGroup.*;


public class Slot {
    private final ImageView imageView;
    private final Label label;
    private final ImageProcessor imageProcessor;
    private final File[] files;
    private MediaPlayer mediaPlayer;
    private final int rollsAmount;
    private final int rollDurationInMs;

    public Slot(ImageView imageView, Label label, ImageGroup imageGroup) {
        this.imageView = imageView;
        this.label = label;
        this.imageProcessor = new ImageProcessor(imageGroup);
        files = imageProcessor.getFiles();

        rollsAmount = 75;
        rollDurationInMs = 100;

        mediaPlayer = setUpMediaPlayer("sounds/euegh_euegh_euegh.mp3");
    }

    private MediaPlayer setUpMediaPlayer(String soundPath) {
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(getClass().getResource(soundPath).toExternalForm()));
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        return mediaPlayer;
    }

    public void roll(int rollsAmount) {
        if (mediaPlayer != null)
            mediaPlayer.play();

        Timeline timeline = new Timeline();
        timeline.setCycleCount(rollsAmount);

        KeyFrame keyFrame = new KeyFrame(Duration.millis(rollDurationInMs), event -> updateSlotContent());

        timeline.getKeyFrames().add(keyFrame);
        timeline.play();

        timeline.setOnFinished(e -> {
            if (mediaPlayer != null)
                mediaPlayer.stop();
        });
    }

    public void roll() {
        roll(rollsAmount);
    }

    public void rollBackground(int rollsAmount, AnchorPane anchorPane) {
        ImageProcessor imageProcessor = new ImageProcessor(BORDERS);

        if (mediaPlayer != null)
            mediaPlayer.play();

        Timeline timeline = new Timeline();
        timeline.setCycleCount(rollsAmount);

        KeyFrame keyFrame = new KeyFrame(Duration.millis(rollDurationInMs), event -> {
            int idx = (int)(Math.random() * files.length);
            Image image = imageProcessor.findImage(files[idx].getName());
            anchorPane.setBackground(imageProcessor.imageToBackground(image));
        });

        timeline.getKeyFrames().add(keyFrame);
        timeline.play();

        timeline.setOnFinished(e -> {
            if (mediaPlayer != null)
                mediaPlayer.stop();
        });
    }

    public void rollBackground(AnchorPane anchorPane) {
        rollBackground(rollsAmount, anchorPane);
    }

    private void updateSlotContent() {
        int idx = (int)(Math.random() * files.length);
        Image image = imageProcessor.findImage(files[idx].getName());
        String name = files[idx].getName();

        imageView.setImage(image);
        label.setText(name.substring(0, name.lastIndexOf('.')));
    }
}

