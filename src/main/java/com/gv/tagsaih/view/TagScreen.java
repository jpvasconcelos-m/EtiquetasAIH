package com.gv.tagsaih.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TagScreen extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Etiquetas AIH");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/ses-pe-secretaria-de-saude-do-estado-de-pernambuco.png")));


        // Criar o ImageView
        ImageView imageView = new ImageView();
        imageView.setFitHeight(150.0);
        imageView.setFitWidth(188.0);
        imageView.setImage(new Image(getClass().getResourceAsStream("/ses-pe-secretaria-de-saude-do-estado-de-pernambuco.png"))); // Ajuste o caminho conforme necessário

        // Criar o AnchorPane para a parte superior
        AnchorPane topPane = new AnchorPane();
        topPane.getChildren().add(imageView);

        // Criar os TextFields
        TextField campo1 = new TextField();
        campo1.setLayoutX(226.0);
        campo1.setLayoutY(73.0);
        campo1.getStyleClass().add("campo-texto"); // Adicione o CSS se necessário

        TextField campo2 = new TextField();
        campo2.setLayoutX(226.0);
        campo2.setLayoutY(131.0);

        Label developersLabel = new Label("Desenvolvido por : Aloísio Glarkson Andrade de Jesus e João Pedro Vasconcelos Mendes");
        developersLabel.setLayoutX(10.0);
        developersLabel.setLayoutY(10.0);

        // Criar o AnchorPane para a parte central
        AnchorPane middlePane = new AnchorPane();
        middlePane.getChildren().addAll(campo1, campo2, developersLabel);

        // Criar o AnchorPane para a parte Inferior
        AnchorPane bottomPane = new AnchorPane();
       bottomPane.getChildren().addAll(developersLabel);


        // Criar o BorderPane
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topPane);
        borderPane.setCenter(middlePane);
        borderPane.setBottom(bottomPane);

        // Definir a cor de fundo do BorderPane
        borderPane.setStyle("-fx-background-color: white;"); // Define o fundo como branco

        // Configurar a cena
        Scene scene = new Scene(borderPane, 600, 400);
        scene.getStylesheets().add(getClass().getResource("/caixaDeTexto.css").toExternalForm()); // Adicione o CSS corretamente

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
