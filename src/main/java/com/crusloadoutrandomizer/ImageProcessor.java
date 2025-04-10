package com.crusloadoutrandomizer;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class ImageProcessor {
    private String pathRoot;

    protected ImageProcessor() {
        pathRoot = "images";
    }

    protected Image findImage(ImageGroups pathGroup, String pathImage) {
        return new Image(Main.class.getResource(String.format("%s/%s/%s", pathRoot, pathGroup.toString(), pathImage)).toExternalForm());
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
