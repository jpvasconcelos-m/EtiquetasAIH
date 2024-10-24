package com.gv.tagsaih.view;

import com.gv.tagsaih.model.TagGenerator;
import javafx.animation.PauseTransition;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import static com.gv.tagsaih.view.button.ButtonAnimator.addButtonAnimations;

public class InputArea {
    public AnchorPane createInputArea() {
        AnchorPane bottomPane = new AnchorPane();
        bottomPane.setPrefSize(600, 200);

        TextField campo1 = createTextField("Etiqueta Inicial", 6);
        TextField campo2 = createTextField("Etiqueta Final", 52);
        TextField campoNumero = createTextField("Quantidade de Etiquetas", 52);
        campoNumero.setVisible(false); // Inicialmente invisível

        ImageView imageView1 = createImageView("images.png", 220, 13);
        ImageView imageView2 = createImageView("images.png", 220, 58);

        CheckBox checkBox = new CheckBox("Gerar usando Etq. inicial e Quantidade de etiquetas");
        checkBox.setLayoutX(210);
        checkBox.setLayoutY(100);
        configureCheckBox(checkBox, campo2, campoNumero, imageView2);

        Button gerarButton = new Button("GERAR");
        configureGenerateButton(gerarButton, campo1, campo2, campoNumero);

        bottomPane.getChildren().addAll(campo1, campo2, campoNumero, gerarButton, imageView1, imageView2, checkBox);
        return bottomPane;
    }

    private TextField createTextField(String promptText, double layoutY) {
        TextField textField = new TextField();
        textField.setPrefHeight(37);
        textField.setPrefWidth(176);
        textField.setLayoutX(250);
        textField.setLayoutY(layoutY);
        textField.setPromptText(promptText);
        textField.getStyleClass().add("no-border");
        return textField;
    }

    private ImageView createImageView(String imagePath, double layoutX, double layoutY) {
        ImageView imageView = new ImageView(new Image(imagePath));
        imageView.setFitHeight(25);
        imageView.setFitWidth(22);
        imageView.setLayoutX(layoutX);
        imageView.setLayoutY(layoutY);
        return imageView;
    }

    private void configureCheckBox(CheckBox checkBox, TextField campo2, TextField campoNumero, ImageView imageView) {
        checkBox.setOnAction(event -> {
            boolean isChecked = checkBox.isSelected();
            campo2.setVisible(!isChecked);
            campoNumero.setVisible(isChecked);
            if (isChecked) {
                imageView.setImage(new Image(getClass().getResourceAsStream("/8631648.png")));
                campoNumero.setPromptText("Quantidade de Etiquetas");
            } else {
                imageView.setImage(new Image(getClass().getResourceAsStream("/images.png")));
                campo2.clear();
            }
        });
    }

    private void configureGenerateButton(Button button, TextField campo1, TextField campo2, TextField campoNumero) {
        button.setLayoutX(290);
        button.setLayoutY(135);
        button.setPrefSize(100, 30);
        button.setStyle("-fx-background-color: #2ecd70; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14px;");
        addButtonAnimations(button);

        button.setOnAction(event -> {
            String textoCampo1 = campo1.getText();
            String textoCampo2 = campo2.isVisible() ? campo2.getText() : campoNumero.getText();
            System.out.println("Campo 1: " + textoCampo1);
            System.out.println("Campo 2: " + textoCampo2);
            try {
                TagGenerator.generatePdfFile(textoCampo1, textoCampo2);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        PauseTransition pause = new PauseTransition(Duration.millis(1));
        pause.setOnFinished(event -> button.requestFocus());
        pause.play();
    }
}
