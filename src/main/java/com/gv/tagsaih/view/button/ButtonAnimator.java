package com.gv.tagsaih.view.button;

import javafx.animation.ScaleTransition;
import javafx.scene.control.Button;
import javafx.util.Duration;

public class ButtonAnimator {

    public static void addButtonAnimations(Button button) {
        // Animação ao passar o mouse
        ScaleTransition scaleButtonHover = new ScaleTransition(Duration.seconds(0.1), button);
        button.setOnMouseEntered(e -> {
            scaleButtonHover.setToX(1.1);
            scaleButtonHover.setToY(1.1);
            scaleButtonHover.play();
        });

        button.setOnMouseExited(e -> {
            scaleButtonHover.setToX(1);
            scaleButtonHover.setToY(1);
            scaleButtonHover.play();
        });

        // Animação ao clicar
        ScaleTransition scaleButtonClick = new ScaleTransition(Duration.seconds(0.1), button);
        button.setOnMousePressed(e -> {
            scaleButtonClick.setToX(0.9);
            scaleButtonClick.setToY(0.9);
            scaleButtonClick.play();
        });

        button.setOnMouseReleased(e -> {
            scaleButtonClick.setToX(1);
            scaleButtonClick.setToY(1);
            scaleButtonClick.play();
        });
    }
}
