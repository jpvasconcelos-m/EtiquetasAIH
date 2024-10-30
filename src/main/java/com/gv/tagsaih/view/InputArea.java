package com.gv.tagsaih.view;

import com.gv.tagsaih.model.TagGenerator;
import com.gv.tagsaih.model.textFormatting.StringFormatter;
import com.gv.tagsaih.view.exceptions.ErrorHandler;
import com.gv.tagsaih.view.exceptions.TagEndsWithZeroException;
import javafx.animation.PauseTransition;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

import static com.gv.tagsaih.view.button.ButtonAnimator.addButtonAnimations;

public class InputArea {

    static StringFormatter stringFormatter = new StringFormatter();


    public AnchorPane createInputArea() {
        AnchorPane bottomPane = new AnchorPane();
        bottomPane.setPrefSize(600, 200);

        TextField campo1 = createTextField("Etiqueta Inicial", 6);
        TextField campo2 = createTextField("Etiqueta Final", 52);
        TextField campoNumero = createTextField("Quantidade de Etiquetas", 52);
        campoNumero.setVisible(false); // Inicialmente invisível

        ImageView imageView1 = createImageView("images.png", 220, 6);
        ImageView imageView2 = createImageView("images.png", 220, 50);

        CheckBox checkBox = new CheckBox("Gerar usando Etq. inicial e Quantidade de etiquetas");
        checkBox.setLayoutX(210);
        checkBox.setLayoutY(100);
        configureCheckBox(checkBox, campo2, campoNumero, imageView2);

        HBox footer = Footer.createFooter();
        AnchorPane.setBottomAnchor(footer, 0.0);
        AnchorPane.setLeftAnchor(footer, 0.0);
        AnchorPane.setRightAnchor(footer, 0.0);
        bottomPane.getChildren().add(footer);

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
        textField.setLayoutY(layoutY-10);
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

    private void configureGenerateButton(Button button, TextField field1, TextField field2, TextField numberField) {
        button.setLayoutX(280);
        button.setLayoutY(130);
        button.setPrefSize(100, 30);
        button.setStyle("-fx-background-color: #2ecd70; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14px;");
        addButtonAnimations(button);

        button.setOnAction(event -> {

            String field1Text = field1.getText().replace("-","");
            String field2Text = field2.isVisible() ? field2.getText().replace("-","") : numberField.getText();

            System.out.println("Campo 1: " + field1Text);
            System.out.println("Campo 2: " + field2Text);
            try {
                if(field1Text.endsWith("0")){
                    throw new TagEndsWithZeroException("A etiqueta termina com zero, informe a última aih impressa.");

                }

                if (numberField.isVisible()){
                    field1Text.replace("-","");
                    TagGenerator.generatePdfFile(stringFormatter.formatString(field1Text), Integer.parseInt(field2Text));
                }
                else
                 TagGenerator.generatePdfFile(stringFormatter.formatString(field1Text), stringFormatter.formatString(field2Text));
            } catch (Exception e) {
                ErrorHandler.showError(e.getMessage());
            }
        });

        PauseTransition pause = new PauseTransition(Duration.millis(1));
        pause.setOnFinished(event -> button.requestFocus());
        pause.play();
    }
}
