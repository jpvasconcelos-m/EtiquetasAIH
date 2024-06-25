package com.gv.tagsaih.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AihController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}