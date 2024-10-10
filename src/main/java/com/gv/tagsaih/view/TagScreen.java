package com.gv.tagsaih.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;

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

        Label titleLabel = new Label("Gerador de Etiquetas");
        titleLabel.setTextFill(javafx.scene.paint.Color.web("#2ecd70"));
        titleLabel.setFont(Font.font("Impact", 36));
        titleLabel.setFont(Font.font("Georgia", FontPosture.ITALIC, 36)); // Use a fonte que preferir

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
        campo1.setLayoutX(226);
        campo1.setLayoutY(6);
        campo1.getStyleClass().add("no-border");


        TextField campo2 = new TextField();
        campo2.setPrefHeight(37);
        campo2.setPrefWidth(177);
        campo2.setLayoutX(226);
        campo2.setLayoutY(52);
        campo2.getStyleClass().add("no-border");

        Button gerarButton = new Button("GERAR");
        gerarButton.setLayoutX(273);
        gerarButton.setLayoutY(116);
        gerarButton.getStyleClass().add("elegant-button");

        ImageView imageView1 = new ImageView(new Image("21251.png"));
        imageView1.setFitHeight(25);
        imageView1.setFitWidth(22);
        imageView1.setLayoutX(198);
        imageView1.setLayoutY(13);

        ImageView imageView2 = new ImageView(new Image("21251.png"));
        imageView2.setFitHeight(25);
        imageView2.setFitWidth(22);
        imageView2.setLayoutX(198);
        imageView2.setLayoutY(58);

        bottomPane.getChildren().addAll(campo1, campo2, gerarButton, imageView1, imageView2);
        borderPane.setBottom(bottomPane);

        // Criando a cena e configurando o palco
        Scene scene = new Scene(borderPane);
        scene.setFill(Color.WHITE);
        primaryStage.getIcons().add(new Image("icone.png"));
        scene.getStylesheets().add("caixaDeTexto.css");
        primaryStage.setScene(scene);
        primaryStage.setTitle("Gerador de Etiquetas");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
