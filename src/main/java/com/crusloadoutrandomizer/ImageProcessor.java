package com.crusloadoutrandomizer;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.File;
import java.net.URISyntaxException;

public class ImageProcessor {
    private String pathRoot;
    private ImageGroups imageGroup;

    protected ImageProcessor(ImageGroups imageGroup) {
        pathRoot = "images";
        this.imageGroup = imageGroup;
    }

    protected Image findImage(String imageName) {
        return new Image(Main.class.getResource(String.format("%s/%s/%s", pathRoot, imageGroup.toString(), imageName)).toExternalForm());
    }

    protected File[] getFiles() {
        try {
            return new File(getClass().getResource("/com/crusloadoutrandomizer/images/head/").toURI()).listFiles();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    protected Background imageToBackground(Image img) {
        BackgroundImage bgImg = new BackgroundImage(img,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(
                        1.0, 1.0, true, true, false, false
                ));
        return new Background(bgImg);
    }
}
