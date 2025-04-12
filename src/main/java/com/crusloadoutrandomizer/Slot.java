package com.crusloadoutrandomizer;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.*;
import java.net.URL;
import java.time.LocalTime;


public class Slot implements Runnable {
    private final ImageView imageView;
    private final Label label;
    private final ImageProcessor imageProcessor;
    private final File[] files;
    private MediaPlayer mediaPlayer;

    public Slot(ImageView imageView, Label label, ImageProcessor imageProcessor) {
        this.imageView = imageView;
        this.label = label;
        this.imageProcessor = imageProcessor;
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

    @Override
    public void run() {

        test();


        int base = 100;

        System.out.println(LocalTime.now());
//        for (int i = 10; i < 500; i+=10) {
//            base += i;
//            int idx = (int)(Math.random() * files.length);
//
//            try {
//                imageView.setImage(imageProcessor.findImage(files[idx].getName()));
//                Thread.sleep(base);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }


        System.out.println(LocalTime.now());

    }
}

