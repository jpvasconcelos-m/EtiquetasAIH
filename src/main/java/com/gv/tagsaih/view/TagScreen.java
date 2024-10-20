package com.gv.tagsaih.view;

import com.gv.tagsaih.model.TagGenerator;
import javafx.animation.PauseTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

import static com.gv.tagsaih.view.button.ButtonAnimator.addButtonAnimations;

public class TagScreen extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criando o BorderPane
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(600, 400);

        // Criando o AnchorPane para o topo
        AnchorPane topPane = new AnchorPane();
        topPane.setPrefSize(600, 165);
        ImageView logo = new ImageView(new Image("ses-pe-secretaria-de-saude-do-estado-de-pernambuco.png"));
        logo.setFitHeight(150);
        logo.setFitWidth(188);

        Label titleLabel = new Label("    Gerador de Etiquetas");
        titleLabel.setTextFill(javafx.scene.paint.Color.web("#2ecd70"));
        titleLabel.setFont(Font.font("Georgia", FontWeight.BOLD, FontPosture.ITALIC, 29));
        titleLabel.setStyle("-fx-background-color: transparent; -fx-padding: 10; -fx-border-color: #2ecd70; -fx-border-width: 2; -fx-border-radius: 1;");

        AnchorPane.setLeftAnchor(logo, 0.0);
        AnchorPane.setRightAnchor(titleLabel, 0.0);
        AnchorPane.setTopAnchor(titleLabel, 75.0);
        AnchorPane.setLeftAnchor(titleLabel, 202.0);

        topPane.getChildren().addAll(logo, titleLabel);
        borderPane.setTop(topPane);

        // Criando o AnchorPane para a parte inferior
        AnchorPane bottomPane = new AnchorPane();
        bottomPane.setPrefSize(600, 200);

        TextField campo1 = new TextField();
        campo1.setPrefHeight(38);
        campo1.setPrefWidth(176);
        campo1.setLayoutX(250);
        campo1.setLayoutY(6);
        campo1.setPromptText("Etiqueta Inicial");
        campo1.getStyleClass().add("no-border");

        TextField campo2 = new TextField();
        campo2.setPrefHeight(37);
        campo2.setPrefWidth(176);
        campo2.setLayoutX(250);
        campo2.setLayoutY(52);
        campo2.setPromptText("Etiqueta Final");
        campo2.getStyleClass().add("no-border");

        TextField campoNumero = new TextField();
        campoNumero.setPrefHeight(37);
        campoNumero.setPrefWidth(176);
        campoNumero.setLayoutX(250);
        campoNumero.setLayoutY(52);
        campoNumero.getStyleClass().add("no-border");
        campoNumero.setVisible(false); // Inicialmente invisível

        ImageView imageView1 = new ImageView(new Image("images.png"));
        imageView1.setFitHeight(25);
        imageView1.setFitWidth(22);
        imageView1.setLayoutX(220);
        imageView1.setLayoutY(13);

        ImageView imageView2 = new ImageView(new Image("images.png"));
        imageView2.setFitHeight(25);
        imageView2.setFitWidth(22);
        imageView2.setLayoutX(220);
        imageView2.setLayoutY(58);

        CheckBox checkBox = new CheckBox("Gerar usando Etq. inicial e Quantidade de etiquetas");
        checkBox.setLayoutX(210);
        checkBox.setLayoutY(100);
        checkBox.setOnAction(event -> {
            boolean isChecked = checkBox.isSelected();
            campo2.setVisible(!isChecked);
            campoNumero.setVisible(isChecked);

            if (isChecked) {
                imageView2.setImage(new Image(getClass().getResourceAsStream("/8631648.png")));
                campoNumero.setPromptText("Quantidade de Etiquetas");
            } else {
                campo2.setPrefWidth(176);
                imageView2.setImage(new Image(getClass().getResourceAsStream("/images.png")));
                campo2.clear();
            }
        });

        Button gerarButton = new Button("GERAR");
        gerarButton.setLayoutX(290);
        gerarButton.setLayoutY(135);
        gerarButton.setPrefSize(100, 30); // Tamanho inicial ajustado
        gerarButton.setStyle("-fx-background-color: #2ecd70; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14px;");

        // Animações para o botão "GERAR"
        addButtonAnimations(gerarButton);

        gerarButton.setOnAction(event -> {
            String textoCampo1 = campo1.getText();
            String textoCampo2 = checkBox.isSelected() ? campoNumero.getText() : campo2.getText();
            System.out.println("Campo 1: " + textoCampo1);
            System.out.println("Campo 2: " + textoCampo2);
            try {
                TagGenerator.generatePdfFile(textoCampo1, textoCampo2);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        bottomPane.getChildren().addAll(campo1, campo2, campoNumero, gerarButton, imageView1, imageView2, checkBox);
        borderPane.setBottom(bottomPane);
        PauseTransition pause = new PauseTransition(Duration.millis(1));

        pause.setOnFinished(event -> {
            // Foca na cena para remover o foco dos campos
            gerarButton.requestFocus();
        });
        pause.play();

        // Criando a cena e configurando o palco
        Scene scene = new Scene(borderPane);
        scene.setFill(Color.WHITE);
        primaryStage.getIcons().add(new Image("icone.png"));
        scene.getStylesheets().add("caixaDeTexto.css");
        primaryStage.setScene(scene);
        primaryStage.setTitle("Gerador de Etiquetas");
        primaryStage.setResizable(false);
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
