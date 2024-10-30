package com.gv.tagsaih.view.elements;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;


public class Header {
    public AnchorPane createHeader(){
       AnchorPane topPane = new AnchorPane();
       topPane.setPrefSize(600,165);

        ImageView logo = new ImageView("ses.png");
        logo.setFitHeight(150);
        logo.setFitWidth(188);

        Label titleLabel = new Label("Gerador de Etiquetas");
        titleLabel.setTextFill(javafx.scene.paint.Color.web("#2ecd70"));
        titleLabel.setFont(Font.font("Georgia", FontWeight.BOLD, FontPosture.ITALIC, 29));
        titleLabel.setStyle("-fx-background-color: transparent; -fx-padding: 10; -fx-border-color: #2ecd70; -fx-border-width: 2; -fx-border-radius: 10;");

        AnchorPane.setLeftAnchor(logo, 0.0);
        AnchorPane.setRightAnchor(titleLabel, 50.0);
        AnchorPane.setTopAnchor(titleLabel, 60.0);
        AnchorPane.setLeftAnchor(titleLabel, 200.0);

        topPane.getChildren().addAll(logo, titleLabel);
        return topPane;

    }
}
