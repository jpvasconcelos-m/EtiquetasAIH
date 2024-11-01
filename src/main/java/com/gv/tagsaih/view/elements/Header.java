package com.gv.tagsaih.view.elements;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.awt.image.ImagingOpException;

public class Header {
    public AnchorPane createHeader() {
        AnchorPane leftPane = new AnchorPane();
        leftPane.setPrefSize(600, 400); // Ajuste o tamanho conforme necessário
        leftPane.setMinWidth(600);
        leftPane.setMinHeight(200);

        Line line = new Line();
        line.setLayoutX(268);
        line.setLayoutY(0);
        line.setStartX(0);
        line.setEndX(0);
        line.setStartY(-80);
        line.setEndY(360);




        Label titleLabel = new Label("""
                Etiquetas
                       AIH""");
        titleLabel.setTextFill(javafx.scene.paint.Color.web("#33a179"));
        titleLabel.setFont(Font.font("Impact", FontWeight.BOLD, FontPosture.REGULAR, 36));
        titleLabel.setStyle("-fx-background-color: transparent; ");
        ImageView logo2 =new ImageView("tagger7.png");
        logo2.setLayoutY(10);

        logo2.setFitWidth(253);
        logo2.setFitHeight(353);


        // Centralizando o título horizontalmente
        titleLabel.setLayoutX(53);
        titleLabel.setLayoutY(210); // Ajuste a posição vertical conforme necessário

        // Posicionando o logo no topo


        // Adicionando logo e título ao pane
        leftPane.getChildren().addAll(logo2,line);
        return leftPane;
    }
}
