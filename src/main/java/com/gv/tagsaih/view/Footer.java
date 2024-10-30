package com.gv.tagsaih.view;

import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class Footer {
   public static    HBox  createFooter(){
        HBox footer = new HBox();
        footer.setStyle("-fx-background-color: #f0f0f0; -fx-padding: 10; -fx-alignment: center;");


        Text devs = new Text("Desenvolvedores: Aloísio Glarkson Andrade de Jesus | João Pedro Vasconcelos Mendes");
        devs.setFill(Color.DARKGRAY);
        devs.setTextAlignment(TextAlignment.CENTER);
        footer.getChildren().add(devs);
        return footer;

    }

}
