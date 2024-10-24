package com.gv.tagsaih.view;

import com.gv.tagsaih.model.TagGenerator;
import javafx.animation.PauseTransition;
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
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(600, 400);

        Header header = new Header();
        borderPane.setTop(header.createHeader());

        InputArea inputArea = new InputArea();
        borderPane.setBottom(inputArea.createInputArea());

        Scene scene = new Scene(borderPane);
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
