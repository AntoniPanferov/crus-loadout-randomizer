package com.crusloadoutrandomizer;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.*;
import java.net.URL;
import java.time.LocalTime;


public class Slot {
    private final ImageView imageView;
    private final Label label;
    private final ImageProcessor imageProcessor;
    private final File[] files;
    private MediaPlayer mediaPlayer;

    public Slot(ImageView imageView, Label label, ImageGroups imageGroup) {
        this.imageView = imageView;
        this.label = label;
        this.imageProcessor = new ImageProcessor(imageGroup);
        files = imageProcessor.getFiles();

    }

    private void test() {
        String path = "sounds/slot_machine.mp3";
        System.out.println(path);

        URL soundUrl = getClass().getResource(path);

        Media sound = new Media(soundUrl.toExternalForm());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    public void roll() {
        test();
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

