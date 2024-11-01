package com.gv.tagsaih.view;
import com.gv.tagsaih.view.elements.Header;
import com.gv.tagsaih.view.elements.InputArea;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TagScreen extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(600, 400);

        Header header = new Header();
        borderPane.setLeft(header.createHeader());

        InputArea inputArea = new InputArea();
        borderPane.setBottom(inputArea.createInputArea());

        Scene scene = new Scene(borderPane);
        primaryStage.getIcons().add(new Image("taggerIco.png"));
        scene.getStylesheets().add("caixaDeTexto.css");
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tagger - Gerador de Etiquetas AIH");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
