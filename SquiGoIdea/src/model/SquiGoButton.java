package model;

import javafx.scene.control.Button;

public class SquiGoButton extends Button {
    private final String BUTTON_PRESSED_STYLE = "-fx-background-color: transparent; -fx-background-image: url('pressed.png')";
    private final String BUTTON_FREE_STYLE = "-fx-background-color: transparent; -fx-background-image: url('free.png')";
    private final String FONT_PATH = "src/model/resources/kenvector_future.ttr";

    public SquiGoButton(String text) {
        setText(text);
        setPrefHeight(199);
        setPrefWidth(49);
    }

}
